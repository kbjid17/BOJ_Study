package prob_벽부수고이동하기4_16946_221001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_시간초과 {

	static int[][] ar;
	static int[][] ar_ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ar = new int[n][m];
		ar_ans = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				ar[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(ar[i][j] == 0)
					bfs(i,j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(ar_ans[i][j]);
			}
			System.out.println();
		}
	}
	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		
		q.offer(new int[] {y,x});
		visited[y][x] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] node = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = node[0] + dy[d];
				int nx = node[1] + dx[d];
				
				if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || ar[ny][nx] == 1) continue;
				cnt++;
				visited[ny][nx] = true;
				q.offer(new int[] {ny,nx});
			}
		}
		ar_ans[y][x] = cnt;
	}
}
