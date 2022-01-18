package prob_영역구하기_2583_220118;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k,cnt;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // x 길이
		n = Integer.parseInt(st.nextToken()); // y 길이
		k = Integer.parseInt(st.nextToken());
		ar = new int[m][n];
		visit = new boolean[m][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			for (int j = ay; j < by; j++) {
				for (int d = ax; d < bx; d++) {
					ar[j][d]+=1;
				}
			}
		}
		
		bfs();
		Collections.sort(list);
		System.out.println(cnt);
		for (int a : list) {
			System.out.print(a + " ");
		}
	}
	static void bfs() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && ar[i][j] == 0) {
					cnt++;
					int size = 1;
					queue.add(new int[] {i,j});
					visit[i][j] = true;
					while(!queue.isEmpty()) {
						int[] a = queue.poll();
						for (int d = 0; d < 4; d++) {
							int ny = a[0] + dy[d];
							int nx = a[1] + dx[d];
							if(ny < 0 || ny >= m || nx < 0 || nx >= n || visit[ny][nx] || ar[ny][nx] != 0) continue;
							queue.add(new int[] {ny,nx});
							visit[ny][nx] = true;
							size++;
						}
					}
					list.add(size);
				}
			}
		}
	}
}
