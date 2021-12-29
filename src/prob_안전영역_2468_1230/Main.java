package prob_안전영역_2468_1230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visit;
	static Queue <Node> queue = new LinkedList<Node>();
	static int N,area,maxArea = Integer.MIN_VALUE;
	static int deep = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				deep = Math.max(ar[i][j], deep);
			}
		}
		for (int k = 0; k < deep; k++) {
			visit = new boolean[N][N];
			area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visit[i][j]) continue;
					if(ar[i][j] > k) {
//						System.out.println(k);
//						System.out.println(i + " " + j);
						bfs(k,i,j);
						area++;
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(visit[i][j]);
//				}
//				System.out.println();
//			}
			maxArea = Math.max(maxArea, area);
		}
		System.out.println(maxArea);
	}

	static void bfs(int k,int y,int x) {
		queue.offer(new Node(y,x));
		visit[y][x] = true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || ar[ny][nx] <= k) continue;
				queue.offer(new Node(ny,nx));
				visit[ny][nx] = true;
			}
		}
	}
	
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
