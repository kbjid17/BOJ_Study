package prob_녹색옷입은애가젤다지_4485_210929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_210929 {

	static int N;
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static int[][] cost;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>((e1,e2) -> e1.c - e2.c);
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t= 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			ar = new int[N+1][N+1]; //이동 포인트
			visit = new boolean[N+1][N+1];
			cost = new int[N+1][N+1];
			//인접 행렬 입력
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			System.out.println("Problem " + (++t) + ": " + cost[N][N]);
		}
	}
	static void dijkstra() {
		visit[1][1] = true;
		cost[1][1] = ar[1][1];
		pqueue.offer(new Edge(1,1,ar[1][1]));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = e.y + dy[i];
				int nx = e.x + dx[i];
				if(ny <= 0 || nx <= 0 || ny > N || nx > N || visit[ny][nx]) continue;
				if(e.c + ar[ny][nx] < cost[ny][nx]) {
					visit[ny][nx] = true;
					cost[ny][nx] = e.c + ar[ny][nx];
					pqueue.offer(new Edge(ny,nx,cost[ny][nx]));
				}
			}
		}
	}
	static class Edge {
		int y;
		int x;
		int c;
		public Edge(int y,int x,int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
}