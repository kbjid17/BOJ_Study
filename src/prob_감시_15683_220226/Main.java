package prob_감시_15683_220226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans = Integer.MAX_VALUE;
	static ArrayList<camera> list = new ArrayList<camera>();
	static int[][] ar;
	static int[] cam = {1,2,3,4};
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static int[] tgt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		/*
		 0 : 빈 공간
		 1~5 : 카메라
		 (1 : 한 방향만
		 2 : 양 방향만(앞뒤 ,위아래)
		 3 : 한 방향 + 직각 한 방향
		 4 : 세 방향
		 5 : 네 방향)
		 
		 6 : 벽
		 */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] > 0 && ar[i][j] < 6) {
					list.add(new camera(i,j,ar[i][j],0));
				}
			}
		}
//		System.out.println(list.size());
		/*
		 카메라들의 방향을 결정해야 함.
		 카메라의 위치를 ArrayList로 가져오고, 카메라의 개수를 A라 하면 중복조합을 통해 0~3 중에서 하나를 택하게 해야 함.
		 */
		comb(0);
		System.out.println(ans);
	}
	static void comb(int tgtIdx) {
		if(tgtIdx == list.size()) {
			for (camera c : list) {
//				System.out.print(c.d +" ");
			}
//			System.out.println();
			view(); // 방향이 모두 정해짐
			return;
		}
		
		for (int i = 0; i < cam.length; i++) {
			list.get(tgtIdx).d = i;
			comb(tgtIdx+1);
		}
	}
	
	static void view() {
		//list 내 카메라들을 모두 보면서 해당 방향으로 감시를 진행
		// 배열을 하나 복사해와야 함.
		int cnt = 0;
		int[][] copyar = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyar[i][j] = ar[i][j];
			}
		}
		for (camera c : list) {
			int ny = c.y;
			int nx = c.x;
			switch(c.n) {
			case 1:
				while(true) {
					ny += dy[c.d];
					nx += dx[c.d];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M || copyar[ny][nx] == 6) break;
					if(copyar[ny][nx] == 0) {
						copyar[ny][nx] = 7;
					}
				}
				break;
			case 2:
				while(true) {
					ny += dy[c.d];
					nx += dx[c.d];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M || copyar[ny][nx] == 6) break;
					if(copyar[ny][nx] == 0) {
						copyar[ny][nx] =7;
					}
				}
					int ny_2 = c.y;
					int nx_2 = c.x;
					while(true) {
						ny_2 -= dy[c.d];
						nx_2 -= dx[c.d];
						if(ny_2 < 0 || ny_2 >= N || nx_2 < 0 || nx_2 >= M || copyar[ny_2][nx_2] == 6) break;
						if(copyar[ny_2][nx_2] == 0) {
							copyar[ny_2][nx_2] = 7;
					}
				}
				
				break;
			case 3:
				for (int i = 0; i < 2; i++) {
					ny = c.y;
					nx = c.x;
					while(true) {
						ny += dy[(c.d+i)%4];
						nx += dx[(c.d+i)%4];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M || copyar[ny][nx] == 6) break;
						if(copyar[ny][nx] == 0) {
							copyar[ny][nx] = 7;
						}
					}
				}
				break;
			case 4:
				for (int i = 0; i < 3; i++) {
					ny = c.y;
					nx = c.x;
					while(true) {
						ny += dy[(c.d+i)%4];
						nx += dx[(c.d+i)%4];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M || copyar[ny][nx] == 6) break;
						if(copyar[ny][nx] == 0) {
							copyar[ny][nx] = 7;
							
						}
					}
				}
				break;
			case 5:
				for (int i = 0; i < 4; i++) {
					ny = c.y;
					nx = c.x;
					while(true) {
						ny += dy[i];
						nx += dx[i];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M || copyar[ny][nx] == 6) break;
						if(copyar[ny][nx] == 0) {
							copyar[ny][nx] = 7;
							
						}
					}
				}
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyar[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}
	
	static class camera {
		int y;
		int x;
		int n; // 카메라 종류
		int d; // 카메라의 방향 정하기(default : 0)
		public camera(int y, int x, int n, int d) {
			super();
			this.y = y;
			this.x = x;
			this.n = n;
			this.d = d;
		}
		@Override
		public String toString() {
			return "camera [y=" + y + ", x=" + x + ", n=" + n + ", d=" + d + "]";
		}
		
		
		
	}
}
