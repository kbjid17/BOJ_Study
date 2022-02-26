package prob_감시_15683_220226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_정리 {
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
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] > 0 && ar[i][j] < 6) {
					list.add(new camera(i,j,ar[i][j],0));
				}
			}
		}
		comb(0);
		System.out.println(ans);
	}
	static void comb(int tgtIdx) {
		if(tgtIdx == list.size()) {
			for (camera c : list) {
			}
			view(); // 방향이 모두 정해짐
			return;
		}
		
		for (int i = 0; i < cam.length; i++) {
			list.get(tgtIdx).d = i;
			comb(tgtIdx+1);
		}
	}
	
	static void view() {
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
				for (int i = 0; i < cam.length; i+=2) {
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
	}
}