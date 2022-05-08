package prob_특정한최단경로_1504_220508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,from,to;
	static int[][] edge;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		edge = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				edge[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edge[start][end] = cost;
			edge[end][start] = cost;
		}
		
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		
		
		int a = dijkstra(1,from);
		int b = dijkstra(from,to);
		int c = dijkstra(to,N);
		
		int d = dijkstra(1,to);
		int e = dijkstra(to,from);
		int f = dijkstra(from,N);
		
		if(from == 1) { //from : 1 => from -> to -> N
			if(to == N) {
				if(b == INF) {
					System.out.println(-1);
					return;
				}
				System.out.println(b);
			}
			else {
				if(b == INF || c == INF) {
					System.out.println(-1);
					return;
				}
				System.out.println(b+c);
			}
		}
		else {
			if(to == N) {
				if(a == INF || b == INF) {
					System.out.println(-1);
					return;
				}
				System.out.println(a+b);
			}
			else {
				int va = a+b+c;
				int vb = d+e+f;
				if(a == INF || b == INF || c == INF) {
					va = INF;
				}
				if(d == INF || e == INF || f == INF) {
					vb = INF;
				}
				if(va == INF && vb == INF) {
					System.out.println(-1);
					return;
				}
				System.out.println(Math.min(a+b+c, d+e+f));
			}
		}
		
		// 출발지는 1, 목적지는 N, from과 to를 거쳐야만 함.
		
		
		// 1 -> from 최소 비용 + from-> to 최소 비용 + to -> N 최소 비용
	}
	
	static int dijkstra(int from,int to) {
		
		int[] minCost = new int[N+1];
		boolean[] visit = new boolean[N+1];
		Arrays.fill(minCost, INF);
		
		minCost[from] = 0;
		visit[from] = true;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((e1,e2) -> e1.cost - e2.cost);
		
		for (int i = 1; i <= N; i++) {
			if(i != from && edge[from][i] != INF) {
				minCost[i] = Math.min(minCost[i], edge[from][i]);
				pq.offer(new Node(i,edge[from][i]));
			}
		}
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(visit[n.start]) continue;
			
			for (int i = 1; i <= N; i++) {
				if(edge[n.start][i] != INF) {
					minCost[i] = Math.min(minCost[i], edge[n.start][i] + n.cost);
					pq.offer(new Node(i,minCost[i]));
				}
			}
			
			visit[n.start] = true;
		}
		return minCost[to];
		
		
	}
static class Node {
	int start;
	int cost;
	
	public Node(int start, int cost) {
		super();
		this.start = start;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Node [start=" + start +", cost=" + cost + "]";
	}
	
	
}
}
