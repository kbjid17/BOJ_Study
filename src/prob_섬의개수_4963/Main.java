package prob_섬의개수_4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w,h,cnt;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static boolean[][] visit;
	static int[][] ar;
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break; // 둘 다 0이면 끝내기
			ar = new int[h][w];
			visit = new boolean[h][w];
			
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println(bfs(ar));
		}

	}
	static int bfs(int[][] ar) {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(!visit[i][j] && ar[i][j] == 1) { // 섬이 있고, 방문하지 않은 곳이라면 bfs 진행
					cnt++;
					queue.add(new int[] {i,j});
					visit[i][j] = true;
					while(!queue.isEmpty()) {
						int[] a = queue.poll();
						for (int d = 0; d < 8; d++) {
							int ny = a[0] + dy[d];
							int nx = a[1] + dx[d];
							if(ny < 0 || ny >= h || nx < 0 || nx >= w || visit[ny][nx] || ar[ny][nx] == 0) continue;
							queue.offer(new int[] {ny,nx});
							visit[ny][nx] = true;
						}
					}
				}
			}
		}
		return cnt;
		
	}
}
