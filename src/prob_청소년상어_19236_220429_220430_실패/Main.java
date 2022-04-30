package prob_청소년상어_19236_220429_220430_실패;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static fish[][] ar = new fish[4][4];
	static fish[] fishInfo = new fish[17];
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				ar[i][j] = new fish(i,j,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())-1,false);
				// 각 물고기에 대한 정보를 가져와야 함! ( fishInfo[물고기번호] )
				fishInfo[ar[i][j].num] = new fish(i,j,ar[i][j].num,ar[i][j].dir,false);
			}
		}
		
		//1. 상어가 공간에 들어옴 => [0][0]의 물고기를 먹어치움
		ans += ar[0][0].num;
		fishInfo[ar[0][0].num].isdead = true;
		ar[0][0].num = 0; // num이 0이면 상어
		fishInfo[0] = ar[0][0];
		
		two();
		
	}

	static void two() {
		
		//2. 물고기 이동 시작.
		for (int i = 1; i <= 16; i++) {
			if(fishInfo[i].isdead) continue;
			fish f = fishInfo[i];
			for (int d = 0; d < 8; d++) {
				int ny = f.y + dy[(f.dir+d) % 8];
				int nx = f.x + dx[(f.dir+d) % 8];
				if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || ar[ny][nx].num == 0) continue;
				//물고기가 해당 위치로 이동이 가능하다면 서로 위치를 바꿈
				ar[f.y][f.x] = ar[ny][nx];
				fishInfo[i] = ar[ny][nx];
				fishInfo[i].num = i;
				
				fishInfo[ar[ny][nx].num] = f;
				fishInfo[ar[ny][nx].num].num = ar[ny][nx].num;
				ar[ny][nx] = f;
				break;
			} 
		}
		
		//3. 상어 이동 => 상어의 이동 방향으로 몇칸이든 이동할 수 있다. 도착한 장소의 물고기만 먹고, 이동 중 지나치는 물고기는 먹지 않는다.
		fish shark = fishInfo[0];
		for (int i = 1; i <= 3; i++) {
			int nny = shark.y + (dy[shark.dir] * i);
			int nnx = shark.x + (dx[shark.dir] * i);
			if(nny < 0 || nny >= 4 || nnx < 0 || nnx >= 4) break; // 배열 벗어나면 이동 불가능
			if(ar[nny][nnx].isdead) continue; // 물고기가 죽어있으면, 그곳의 물고기는 없다는 뜻이 되므로 생략
			three(nny,nnx);
		}
	}
	
	static void three(int y,int x) { // 상어를 [y][x]로 이동시키고 그곳의 물고기를 먹어치움(이전 장소와 정보를 바꾸면 될듯)
		fish[][] copyar = new fish[4][4];
		int copyans = ans;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyar[i][j] = ar[i][j];
			}
		}
		
		ans += ar[y][x].num;
		fishInfo[ar[y][x].num].isdead = true;
		
		//상어와 죽은 물고기 위치 변경 진행
		
		ar[0][0].num = 0; // num이 0이면 상어
		fishInfo[0] = ar[0][0];
		
		
		two();
	}
	
	static class fish {
		int y;
		int x;
		int num;
		int dir; // 0~7
		boolean isdead;
		public fish(int y, int x, int num, int dir, boolean isdead) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
			this.isdead = isdead;
		}
		@Override
		public String toString() {
			return "fish [y=" + y + ", x=" + x + ", num=" + num + ", dir=" + dir + ", isdead=" + isdead + "]";
		}
		
		
	}
}
