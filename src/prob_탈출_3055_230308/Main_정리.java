package prob_탈출_3055_230308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {

	static int R,C;
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
		
		bfs(hog_y, hog_x);
		
		if(ans == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(ans);
	}
	
	private static void bfs(int y, int x) {
			
			
			
			int ny = 0;
			int nx = 0;
			
			while(h.size() > 0) {
				
				int w_size = w.size();
				if(w_size > 0) {
					for (int i = 0; i < w_size; i++) {
						water wn = w.poll();
						for (int d = 0; d < 4; d++) {
							ny = wn.y + dy[d];
							nx = wn.x + dx[d];
							if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] 
									|| ar[ny][nx] == '*' || ar[ny][nx] == 'D' || ar[ny][nx] == 'X') continue;

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
