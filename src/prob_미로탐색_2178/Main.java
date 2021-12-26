package prob_미로탐색_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,count;
	static Queue<point> queue = new LinkedList<point>();
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				ar[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
	}
	static void bfs() {
		visit[0][0] = true;
		queue.offer(new point(0,0,1));
		while(!queue.isEmpty()) {
			point num = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = num.y + dy[i];
				int nx = num.x + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || ar[ny][nx] == 0 || visit[ny][nx]) continue;
				if(ny == N-1 && nx == M-1) {
					System.out.println(num.d+1);
					return;
				}
				visit[ny][nx] = true;
				queue.offer(new point(ny,nx,num.d+1));
			}
		}
	}
	static class point {
		int y;
		int x;
		int d;
		public point(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}
