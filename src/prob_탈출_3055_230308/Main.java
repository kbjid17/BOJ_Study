package prob_탈출_3055_230308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R,C; // 50보다 작거나 같은 자연수
	static char[][] ar;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<hog> h = new LinkedList<hog>();
	static Queue<water> w = new LinkedList<water>();
	static boolean[][] visited;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int hog_y = 0;
		int hog_x = 0;
		ar = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			ar[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(ar[i][j] == 'S') {
					h.offer(new hog(i,j,0));
					visited[i][j] = true;
					hog_y  = i;
					hog_x  = j;
				}
				else if(ar[i][j] == '*') {
					visited[i][j] = true;
					w.offer(new water(i,j));
				}
				else if(ar[i][j] == 'X') visited[i][j] = true;
			}
		}
		// 비어있는 곳	: '.'
		// 물이 차있는 지역 : '*'
		// 돌  : 'X'
		// 비버의 굴 : 'D'
		// 고슴도치 : 'S'
		
		bfs(hog_y, hog_x);
		
		if(ans == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(ans);
	}
	
	private static void bfs(int y, int x) {
			
			
			
			int ny = 0;
			int nx = 0;
			
			while(h.size() > 0) { // 고슴도치가 없으면 bfs 돌릴 필요 X ==> 고슴도치가 있을 땐 계속 돌아감
				
				int w_size = w.size(); // 물의 크기를 구함
				if(w_size > 0) {
					for (int i = 0; i < w_size; i++) {
						water wn = w.poll();
						for (int d = 0; d < 4; d++) {
							ny = wn.y + dy[d];
							nx = wn.x + dx[d];
							if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] 
									|| ar[ny][nx] == '*' || ar[ny][nx] == 'D' || ar[ny][nx] == 'X') continue;
							// 물이 먼저 차고, 고슴도치가 이동
							// 먼저 놓여져 있는 물의 크기만큼 물을 이동시켜주고 , 앞의 물을 제거
							ar[ny][nx] = '*';
							visited[ny][nx] = true;
							w.offer(new water(ny,nx));
						}
					}
				}
				
				
				ny = 0;
				nx = 0;
				int h_size = h.size();
				for (int i = 0; i < h_size; i++) {
					hog hn = h.poll();
					for (int d = 0; d < 4; d++) {
						ny = hn.y + dy[d];
						nx = hn.x + dx[d];
						
						if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] 
								|| ar[ny][nx] == '*' || ar[ny][nx] == 'X') continue;
						else if(ar[ny][nx] == 'D') {
							ans = Math.min(ans, hn.cnt+1);
						}
						else {
							h.offer(new hog(ny,nx,hn.cnt+1));
//							System.out.println(ny + " " + nx + " " + (hn.cnt+1));
							visited[ny][nx] = true;
						}
					}
				}
		}
	}

	private static class hog {
		int y;
		int x;
		int cnt;
		
		public hog(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	private static class water {
		int y;
		int x;
		
		public water(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
