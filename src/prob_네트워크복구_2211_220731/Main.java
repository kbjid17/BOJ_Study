package prob_네트워크복구_2211_220731;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] distance;
	static int min_node = Integer.MAX_VALUE;
	static int min_time = Integer.MAX_VALUE;
	static ArrayList<Node>[] Nodelist;
	static ArrayList<Node> ans_Nodelist = new ArrayList<Node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Nodelist = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			Nodelist[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Nodelist[start].add(new Node(end,weight));
		}
		
		for (int i = 1; i <= N; i++) { // i번째 컴퓨터를 슈퍼컴퓨터로 지정
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[i] = 0;
			dijkstra(i);
			
		}
		// 슈퍼 컴퓨터를 하나 정해놨다는 가정 하에 다익스트라를 돌려야 함
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int v = n.v;
			int w = n.w;
			if(distance[v] < w) continue;
			for (int i = 0; i < Nodelist[v].size(); i++) {
				int v_2 = Nodelist[v].get(i).v;
				int w_2 = Nodelist[v].get(i).w + w;
				if(distance[v_2] > w_2) {
					distance[v_2] = w_2;
					pq.offer(new Node(v_2,w_2));
				}
			}
		}
	}
	
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
		
	}
}
