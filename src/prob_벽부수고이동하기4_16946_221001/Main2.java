package prob_벽부수고이동하기4_16946_221001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

	static int[][] ar;
	static int[][] ar_ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int n;
	static int m;
	static boolean[][] visited;
	static int groupnum = 1;
	static ArrayList<Integer> groupsize = new ArrayList<Integer>();
	static Queue<int[]> walls = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ar = new int[n][m];
		ar_ans = new int[n][m];
		visited = new boolean[n][m];
		groupsize.add(0);
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				ar[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(ar[i][j] == 0 && !visited[i][j]) {
					bfs(i,j,groupnum);
					groupnum++;
				}
				else if(ar[i][j] == 1) {
					walls.offer(new int[] {i,j});
				}
			}
		}
		
		while(!walls.isEmpty()) {
			boolean[] groupvisit = new boolean[groupnum];
			int[] w = walls.poll();
			for (int d = 0; d < 4; d++) {
				int ny = w[0] + dy[d];
				int nx = w[1] + dx[d];
				if(ny < 0 || ny >= n || nx < 0 || nx >= m || groupvisit[ar_ans[ny][nx]] || ar_ans[ny][nx] == 0) continue;
					ar[w[0]][w[1]] = (ar[w[0]][w[1]] +  groupsize.get(ar_ans[ny][nx])) % 10;
					groupvisit[ar_ans[ny][nx]] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(ar[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(int y, int x,int groupnum) {
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<int[]> list = new ArrayList<int[]>();
		q.offer(new int[] {y,x});
		visited[y][x] = true;
		int cnt = 1;
		list.add(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] node = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = node[0] + dy[d];
				int nx = node[1] + dx[d];
				
				if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || ar[ny][nx] >= 1) continue;
				cnt++;
				visited[ny][nx] = true;
				q.offer(new int[] {ny,nx});
				list.add(new int[] {ny,nx});
			}
		}

		groupsize.add(cnt);
		for (int i = 0; i < list.size(); i++) {
			ar_ans[list.get(i)[0]][list.get(i)[1]] = groupnum;
		}
	}
}