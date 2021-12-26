package prob_최단경로_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_복습 {
	static int V,E,K; // 정점 개수, 간선 개수, 시작 정점
	static int[] dist;
	static ArrayList<Edge>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int startPoint = Integer.parseInt(st.nextToken());
			int endPoint = Integer.parseInt(st.nextToken());
			int weightPoint= Integer.parseInt(st.nextToken());
			list[startPoint].add(new Edge(endPoint,weightPoint));
		}
		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	static void dijkstra(int start) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(start,0));
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			int v_end = edge.end;
			int v_weight = edge.weight;
			if(dist[v_end] < v_weight) {
				continue;
			}
			for (int i = 0; i < list[v_end].size(); i++) {
				int v_end_2 = list[v_end].get(i).end;
				int v_weight_2 = list[v_end].get(i).weight + v_weight;
				
				if(dist[v_end_2] > v_weight_2) {
					dist[v_end_2] = v_weight_2;
					queue.add(new Edge(v_end_2,v_weight_2));
				}
			}
		}
	}
		
	static class Edge implements Comparable<Edge>{
		int end;
		int weight;
		
		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
}
