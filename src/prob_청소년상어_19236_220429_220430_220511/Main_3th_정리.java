package prob_청소년상어_19236_220429_220430_220511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3th_정리 {
	static fish[][] ar;
	static fish[] info = new fish[17];
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ar = new fish[4][4];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				ar[i][j] = new fish(i,j,num,dir,false);
				info[num] = new fish(i,j,num,dir,false);
			}
		}
		int size = ar[0][0].num;
		info[0] = new fish(0,0,0,ar[0][0].dir,false);
		info[ar[0][0].num].dead = true;
		ar[0][0] = new fish(info[0].y,info[0].x,info[0].num,info[0].dir,info[0].dead);
		
		for (int i = 1; i <= 16; i++) {
			if(info[i].dead) continue;
			for (int d = 0; d < 8; d++) {
				int nd = info[i].dir + d;
				if(nd >= 9) nd-= 8;
				int ny = info[i].y + dy[nd];
				int nx = info[i].x + dx[nd];
				if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || ar[ny][nx].num == 0) continue;
				fish f1 = new fish(info[i].y, info[i].x, info[i].num, info[i].dir, info[i].dead);
				fish f2 = new fish(ar[ny][nx].y, ar[ny][nx].x, ar[ny][nx].num, ar[ny][nx].dir, ar[ny][nx].dead);
				ar[info[i].y][info[i].x] = new fish(f1.y,f1.x,f2.num,f2.dir,f2.dead);
				ar[ny][nx] = new fish(f2.y, f2.x, f1.num, nd, f1.dead);
				info[f1.num] = new fish(f2.y, f2.x, f1.num, nd, f1.dead);
				info[f2.num] = new fish(f1.y, f1.x, f2.num, f2.dir, f2.dead);
				
				break;
			}
		}

		for (int i = 1; i <= 3; i++) {
			int sny = info[0].y + (dy[info[0].dir]*i);
			int snx = info[0].x + (dx[info[0].dir]*i);
			if(sny < 0 || sny >= 4 || snx < 0 || snx >= 4) break;
			if(ar[sny][snx].dead) continue;
			move(sny,snx,ar,info,size);
		}

		System.out.println(ans);
	}
	
	static void move(int sny,int snx,fish[][] ar,fish[] info,int size) {
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
		fish shark = new fish(copyInfo[0].y,copyInfo[0].x,copyInfo[0].num,copyInfo[0].dir,copyInfo[0].dead);
		fish deadfish = new fish(copyar[sny][snx].y,copyar[sny][snx].x,copyar[sny][snx].num,copyar[sny][snx].dir,true);
		
		int newsize = size + deadfish.num;
		copyInfo[0] = new fish(deadfish.y,deadfish.x,0,deadfish.dir,false);
		copyInfo[deadfish.num] = new fish(shark.y,shark.x,deadfish.num,deadfish.dir,true);
		
		copyar[shark.y][shark.x] = new fish(shark.y,shark.x,deadfish.num,deadfish.dir,true);
		copyar[deadfish.y][deadfish.x] = new fish(deadfish.y,deadfish.x,0,deadfish.dir,false);
		
		for (int i = 1; i <= 16; i++) {
			if(copyInfo[i].dead) continue;
			for (int d = 0; d < 8; d++) {
				int nd = copyInfo[i].dir + d;
				if(nd >= 9) nd-= 8;
				int ny = copyInfo[i].y + dy[nd];
				int nx = copyInfo[i].x + dx[nd];
				if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || copyar[ny][nx].num == 0) continue;

				fish f1 = new fish(copyInfo[i].y, copyInfo[i].x, copyInfo[i].num, copyInfo[i].dir, copyInfo[i].dead);
				fish f2 = new fish(copyar[ny][nx].y, copyar[ny][nx].x, copyar[ny][nx].num, copyar[ny][nx].dir, copyar[ny][nx].dead);

				copyar[copyInfo[i].y][copyInfo[i].x] = new fish(f1.y,f1.x,f2.num,f2.dir,f2.dead);
				copyar[ny][nx] = new fish(f2.y, f2.x, f1.num, nd, f1.dead);
				copyInfo[f1.num] = new fish(f2.y, f2.x, f1.num, nd, f1.dead); // f2 정보 -> f1 정보
				copyInfo[f2.num] = new fish(f1.y, f1.x, f2.num, f2.dir, f2.dead); // f1 정보 -> f2 정보
				
				break;
			}
		}
		ans = Math.max(ans, newsize);
		for (int i = 1; i <= 3; i++) {
			int ssny = sny + (dy[copyInfo[0].dir]*i);
			int ssnx = snx + (dx[copyInfo[0].dir]*i);
			if(ssny < 0 || ssny >= 4 || ssnx < 0 || ssnx >= 4) break;
			if(copyar[ssny][ssnx].dead) continue;
			move(ssny,ssnx,copyar,copyInfo,newsize);
		}
		
	}
	
	static class fish {
		int y;
		int x;
		int num;
		int dir;
		boolean dead;
		public fish(int y, int x, int num, int dir, boolean dead) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
			this.dead = dead;
		}
	}
}