package prob_청소년상어_19236_220429_220430_220511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2th {
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static fish[][] ar = new fish[4][4];
	static fish[] fishInfo = new fish[17];
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int type = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				ar[i][j] = new fish(type,i,j,false,0,dir); // [i][j]에 type번 물고기가 들어옴
				fishInfo[type] = new fish(type,i,j,false,0,dir); // [type]번 물고기의 정보를 기록
			}
		}
		one(0,0); // (0,0)에 상어가 들어옴.
		
	}
	
	static void one(int y,int x) {
		/*
		 (0,0)에 상어가 들어옴 ==> (0,0)에 있던 물고기는 죽은 게 됨
		 fishInfo[0] 에 상어 정보가 들어감.
		 
		 */
		fishInfo[ar[y][x].type].isdead = true; //[y][x]의 상어가 죽음 (컴파일 시작 시 [0][0]의 물고기가 죽음)
		
		ar[y][x].size += ar[y][x].type;
		ar[y][x].type = 0;
		fishInfo[0] = ar[y][x]; // 상어가 들어감
		two(ar,fishInfo);
		
	}
	
	static void two(fish[][] ar,fish[] fishInfo) { // 물고기 이동
		
		fish[][] copyar = new fish[4][4]; // 상어는 여러번 이동할 수 있음 -> 매 이동마다 다른 물고기 & 상어 배열이 나옴 => 매 상어의 이동마다 다른 ar과 fishInfo가 필요
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyar[i][j] = new fish(ar[i][j].type,ar[i][j].y,ar[i][j].x,ar[i][j].isdead,ar[i][j].size,ar[i][j].dir);
			}
		}
		
		fish[] copyFishInfo = new fish[17];
		for (int i = 0; i < 17; i++) {
			copyFishInfo[i] = new fish(fishInfo[i].type,fishInfo[i].y,fishInfo[i].x,fishInfo[i].isdead,fishInfo[i].size,fishInfo[i].dir);
		}
		/*
		 물고기 이동 start
		 1번 ~ 16번 물고기 순서대로 이동 진행
		 */
		for (int i = 1; i <= 16; i++) {
			if(copyFishInfo[i].isdead) continue; // 죽은 물고기는 스스로 움직이지 않음.
			for (int d = 0; d < 8; d++) {
				int ny = copyFishInfo[i].y + dy[(copyFishInfo[i].dir+d) % 8];
				int nx = copyFishInfo[i].x + dy[(copyFishInfo[i].dir+d) % 8];
				if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || copyar[ny][nx].type == 0) continue; // 경계 밖으로 나가거나 상어가 있으면 이동할 수 없음
				//	ar[fishInfo[i].y][fishInfo[i].x] 의 물고기와 ar[ny][nx]의 물고기의 위치를 바꿈 
				//	ar[fishInfo[i].y][fishInfo[i].x]에는 fishInfo[i].type의 물고기가, ar[ny][nx]에는 ar[ny][nx].type의 물고기가 있음
				fish f1 = copyar[copyFishInfo[i].y][copyFishInfo[i].x];
				fish f2 = copyar[ny][nx];
				// fishInfo에서 : 모든 정보를 서로 바꿔준 후, type 정보만 다시 바꿔주면 될려나
				copyar[copyFishInfo[i].y][copyFishInfo[i].x] = f2;
				copyar[ny][nx] = f1;
				
				copyFishInfo[i] = f2;
				copyFishInfo[f2.type] = f1;
				copyFishInfo[i].type = f1.type;
				copyFishInfo[f2.type].type = f2.type;
				break;
			}
			
		}
		boolean move = false;
		for (int i = 1; i < 4; i++) { // 상어는 여러 칸으로 이동 가능하나 ,물고기가 없는 칸으로는 이동 불가능.
			int nny = copyFishInfo[0].y + (dy[copyFishInfo[0].dir] * i);
			int nnx = copyFishInfo[0].x + (dx[copyFishInfo[0].dir] * i);
			if(nny >= 4 || nny < 0 || nnx >= 4 || nnx < 0) break;
			if(copyar[nny][nnx].isdead) continue;
			move = true;
			three(nny,nnx,copyar,copyFishInfo); // 상어가 copyar[nny][nnx]로 이동
		}
		if(!move) { // 더이상 이동이 불가능하게 된다면, '현재' 상어의 크기를 비교 => 
			ans = Math.max(ans, copyFishInfo[0].size);
			return;
		}
	}
	
	static void three(int y,int x,fish[][] ar, fish[] fishInfo) {
		//물고기의 상태를 dead로 바꾸고 상어의 사이즈에 물고기 type만큼 더한 후, 상어와 물고기의 위치를 변경. 이후 주어진 copyar,copyFishInfo로 two로 다시 돌아감
		fish[][] copyar = new fish[4][4]; // 상어는 여러번 이동할 수 있음 -> 매 이동마다 다른 물고기 & 상어 배열이 나옴 => 매 상어의 이동마다 다른 ar과 fishInfo가 필요
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyar[i][j] = new fish(ar[i][j].type,ar[i][j].y,ar[i][j].x,ar[i][j].isdead,ar[i][j].size,ar[i][j].dir);
			}
		}
		
		fish[] copyFishInfo = new fish[17];
		for (int i = 0; i < 17; i++) {
			copyFishInfo[i] = new fish(fishInfo[i].type,fishInfo[i].y,fishInfo[i].x,fishInfo[i].isdead,fishInfo[i].size,fishInfo[i].dir);
		}
		ar[y][x].isdead = true;
		copyFishInfo[0].size += ar[y][x].type;
		
		fish shark = copyFishInfo[0]; // 상어의 위치 : copyFishInfo[0].y , copyFishInfo[0].x
		fish f = ar[y][x]; // 물고기의 위치 : y,x
		
		copyar[copyFishInfo[0].y][copyFishInfo[0].x] = f;
		copyar[y][x] = shark;

		
	}
	
	
	static class fish {
		int type; // 0 : 상어, 나머지 : 물고기
		int y;
		int x;
		boolean isdead;
		int size; // 상어의 사이즈를 구하기 위함
		int dir;
		public fish(int type, int y, int x, boolean isdead, int size, int dir) {
			super();
			this.type = type;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.isdead = isdead;
			this.size = size;
		}
		
		
		
		
		
	}
}
