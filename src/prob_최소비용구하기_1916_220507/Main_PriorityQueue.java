package prob_최소비용구하기_1916_220507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_PriorityQueue {
	static int N, M; // 도시의 개수 N, 버스의 개수 M
	static int[][] ar;
	static int[] minCost;
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE;
	static int start,end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		ar = new int[N+1][N+1];
		minCost = new int[N+1];
		visit = new boolean[N+1];
		Arrays.fill(minCost, INF);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken()); // a에서 b로 가는 비용 c ==> edge[a][b] = c;
			ar[a][b] = Math.min(ar[a][b], c); // 두 정점간 경로가 여러개가 주어질 수 있음
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); // 시작 정점
		end = Integer.parseInt(st.nextToken()); // 목적지 정점
		
		minCost[start] = 0;
		visit[start] = true;
		
		dijkstra();
		System.out.println(minCost[end]);
		
		
	}
	
	static void dijkstra() {
		PriorityQueue<edge> pq = new PriorityQueue<edge>((e1,e2) -> e1.cost - e2.cost);
		for (int i = 1; i <= N; i++) {
			if(i != start && ar[start][i] != INF) {
				minCost[i] = Math.min(minCost[i], ar[start][i]);
				pq.offer(new edge(i,ar[start][i]));
			}
		}
		
		while(!pq.isEmpty()) {
			edge e = pq.poll();
			if(visit[e.start]) continue;
			for (int i = 1; i <= N; i++) {
				
				if(ar[e.start][i] != INF) {
					System.out.println(e.start + " " + i + " " + ar[e.start][i]);
					minCost[i] = Math.min(minCost[i], ar[e.start][i] + e.cost);
					pq.offer(new edge(i,minCost[i]));
				}
			}
			visit[e.start] = true; 
		}
	}
	
	static class edge {
		int start;
		int cost;
		public edge(int start,int cost) {
			super();
			this.start = start;
			this.cost = cost;
		}
		
		
	}
}