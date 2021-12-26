package prob_유기농배추_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T,M,N,K,X,Y,count;
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			queue.clear();
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ar = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				ar[Y][X] =1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(ar[i][j] == 1 && !visit[i][j]) {
						count++;
						bfs(i,j);
					}
				}
			}
			System.out.println(count);
		}
	}
	static void bfs(int y,int x) {
		visit[y][x] = true;
		queue.offer(new Node(y,x));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx] || ar[ny][nx] == 0) continue;
				visit[ny][nx] = true;
				queue.offer(new Node(ny,nx));
			}
			
		}
	}
	
	static class Node {
		int y;
		int x;
		public Node(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
