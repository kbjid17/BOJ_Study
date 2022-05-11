package prob_청소년상어_19236_220429_220430_220511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3th {
	static fish[][] ar;
	static fish[] info = new fish[17]; // 각 물고기의 정보를 담음(몇번 물고기가, 어느 방향을 향하는지, 죽었는지(죽었으면 계산 생략) ++ 위치도 알고 있어야 함)
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	// 이동 방향 : [1]부터  ↑, ↖, ←, ↙, ↓, ↘, →, ↗
	
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ar = new fish[4][4];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				ar[i][j] = new fish(i,j,num,dir,false); // [i][j]에는 num 물고기가 실고 있으며 dir의 방향을 가진채로 살아있다
				info[num] = new fish(i,j,num,dir,false); // num 물고기는 [i][j]에서 살아있다(num은 더미)
			}
		}
		int size = ar[0][0].num;
		//1. 상어가 [0][0]의 물고기를 먹어치움(상어 : info[0]) ar[0][0]에 있던 물고기는 사망
		info[0] = new fish(0,0,0,ar[0][0].dir,false);
		info[ar[0][0].num].dead = true; //ar[0][0].num의 물고기는 더 볼 필요가 없음
		ar[0][0] = new fish(info[0].y,info[0].x,info[0].num,info[0].dir,info[0].dead);
		
		
		// 2. 물고기의 이동 시작
		// 물고기는 1~16순서대로 이동 진행
		// 죽은 물고기는 생략, 한칸만 이동 가능하며, 두 물고기의 위치를 바꿈. 상어가 있거나 배열 밖으로 나가면 이동이 불가능하며 방향을 +1 해줘야 함.
		for (int i = 1; i <= 16; i++) {
			if(info[i].dead) continue;
//			System.out.println(i + "번 상어의 이동 시작");
			for (int d = 0; d < 8; d++) { // 원래 방향 + 7개 방향 1~8
				int nd = info[i].dir + d; // 8 1 2 3 4 5 6 7
				if(nd >= 9) nd-= 8;
				int ny = info[i].y + dy[nd];
				int nx = info[i].x + dx[nd];
				if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || ar[ny][nx].num == 0) continue;
				// 두 물고기의 위치 변경
				fish f1 = new fish(info[i].y, info[i].x, info[i].num, info[i].dir, info[i].dead); // 현재 물고기
				fish f2 = new fish(ar[ny][nx].y, ar[ny][nx].x, ar[ny][nx].num, ar[ny][nx].dir, ar[ny][nx].dead);	// 이동 위치에 있는 물고기
//				System.out.println(f1);
//				System.out.println(f2);
//				System.out.println(nd);
				// 위치 변경 : 각 물고기의 y/x값은 그대로 놔두고 num,dir,dead 정보만 맞바꾸기
				// 이후 info 값도 변경
				// 죽은 물고기와 이동할 땐 방향이 바뀌면 안됨
				// 이동할 때, 현재 nd 값을 저장해야힘
				ar[info[i].y][info[i].x] = new fish(f1.y,f1.x,f2.num,f2.dir,f2.dead);
				ar[ny][nx] = new fish(f2.y, f2.x, f1.num, nd, f1.dead);
				info[f1.num] = new fish(f2.y, f2.x, f1.num, nd, f1.dead); // f2 정보 -> f1 정보
				info[f2.num] = new fish(f1.y, f1.x, f2.num, f2.dir, f2.dead); // f1 정보 -> f2 정보
				
				break;
			}
		}
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.println(ar[i][j]);
//			}
//		}
//		System.out.println();
//		for (int i = 0; i <= 16; i++) {
//			System.out.println(info[i]);
//		}
		// 여기서부턴 백트래킹 시작
		
		// 상어 이동 : 여러 칸을 이동할 수 있으며 중간의 물고기는 먹지 않음. 먹은 물고기의 방향을 가지게 됨
	
		for (int i = 1; i <= 3; i++) {
			int sny = info[0].y + (dy[info[0].dir]*i);
			int snx = info[0].x + (dx[info[0].dir]*i);
			if(sny < 0 || sny >= 4 || snx < 0 || snx >= 4) break;
			if(ar[sny][snx].dead) continue;
			move(sny,snx,ar,info,size);
		}
		// 과정 요약 : 물고기 이동 -> 상어 이동 -> 물고기 이동 -> 상어 이동 ..... -> 상어 이동 후 더이상 이동할 방향이 없으면 불가능
		
		// 상어가 여러 칸으로 이동 가능
		
		System.out.println(ans);
		
		

	}
	
	static void move(int sny,int snx,fish[][] ar,fish[] info,int size) {
//		System.out.println(sny + " " + snx + " 쪽으로 이동 시작 => (방향 : " + info[0].dir+") -> " + ar[sny][snx].num + "을 먹을것임 (현재 가중치 : "+size + ")");
		fish[] copyInfo = new fish[17];
		for (int i = 0; i <= 16; i++) {
			copyInfo[i] = new fish(info[i].y,info[i].x,info[i].num,info[i].dir,info[i].dead);
		}
		fish[][] copyar = new fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyar[i][j] = new fish(ar[i][j].y,ar[i][j].x,ar[i][j].num,ar[i][j].dir,ar[i][j].dead);
			}
		}
		// 상어-> 물고기간 위치 변경
		fish shark = new fish(copyInfo[0].y,copyInfo[0].x,copyInfo[0].num,copyInfo[0].dir,copyInfo[0].dead);
		fish deadfish = new fish(copyar[sny][snx].y,copyar[sny][snx].x,copyar[sny][snx].num,copyar[sny][snx].dir,true);
		
		int newsize = size + deadfish.num;
		// 각 위치의 정보를 변경(물고기는 죽음)
		copyInfo[0] = new fish(deadfish.y,deadfish.x,0,deadfish.dir,false);
		copyInfo[deadfish.num] = new fish(shark.y,shark.x,deadfish.num,deadfish.dir,true);
		
		copyar[shark.y][shark.x] = new fish(shark.y,shark.x,deadfish.num,deadfish.dir,true); // 상어의 자리엔 물고기가 위치
		copyar[deadfish.y][deadfish.x] = new fish(deadfish.y,deadfish.x,0,deadfish.dir,false); // 물고기의 자리엔 상어가 위치
		
		
		// 이동 후 다시 물고기 이동 시작 => 
		for (int i = 1; i <= 16; i++) {
			if(copyInfo[i].dead) continue;
			for (int d = 0; d < 8; d++) { // 원래 방향 + 7개 방향 1~8
				int nd = copyInfo[i].dir + d; // 8 1 2 3 4 5 6 7
				if(nd >= 9) nd-= 8;
				int ny = copyInfo[i].y + dy[nd];
				int nx = copyInfo[i].x + dx[nd];
				if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || copyar[ny][nx].num == 0) continue;
				// 두 물고기의 위치 변경
				fish f1 = new fish(copyInfo[i].y, copyInfo[i].x, copyInfo[i].num, copyInfo[i].dir, copyInfo[i].dead); // 현재 물고기
				fish f2 = new fish(copyar[ny][nx].y, copyar[ny][nx].x, copyar[ny][nx].num, copyar[ny][nx].dir, copyar[ny][nx].dead);	// 이동 위치에 있는 물고기
//				System.out.println(f1);
//				System.out.println(f2);
//				System.out.println(nd);
				// 위치 변경 : 각 물고기의 y/x값은 그대로 놔두고 num,dir,dead 정보만 맞바꾸기
				// 이후 info 값도 변경
				copyar[copyInfo[i].y][copyInfo[i].x] = new fish(f1.y,f1.x,f2.num,f2.dir,f2.dead);
				copyar[ny][nx] = new fish(f2.y, f2.x, f1.num, nd, f1.dead);
				copyInfo[f1.num] = new fish(f2.y, f2.x, f1.num, nd, f1.dead); // f2 정보 -> f1 정보
				copyInfo[f2.num] = new fish(f1.y, f1.x, f2.num, f2.dir, f2.dead); // f1 정보 -> f2 정보
				
				break;
			}
		}
//		System.out.println(newsize > ans ? newsize+"로 새로 갱신" : ans+" 그대로 유지");
		ans = Math.max(ans, newsize);
		// 상어가 이동 가능한곳을 체크
		for (int i = 1; i <= 3; i++) {
			int ssny = sny + (dy[copyInfo[0].dir]*i);
			int ssnx = snx + (dx[copyInfo[0].dir]*i);
			if(ssny < 0 || ssny >= 4 || ssnx < 0 || ssnx >= 4) break;
			if(copyar[ssny][ssnx].dead) continue;
//			System.out.println(sny + "," + snx + " 에서 " + ssny + " " + ssnx + "로 이동하여 " + copyar[ssny][ssnx].num + "을 먹을거임");
			move(ssny,ssnx,copyar,copyInfo,newsize);
		}
		
	}
	
	static class fish {
		int y;
		int x;
		int num; // 물고기 넘버(0 : 상어 : 나머지 : 물고기들)
		int dir; // 물고기 방향
		boolean dead; // 물고기가 죽었는지 살았는지(죽은 물고기는 없는 물고기로 취급)
		public fish(int y, int x, int num, int dir, boolean dead) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
			this.dead = dead;
		}
		@Override
		public String toString() {
			return "fish [y=" + y + ", x=" + x + ", num=" + num + ", dir=" + dir + ", dead=" + dead + "]";
		}
		
		
		
		
	}
}