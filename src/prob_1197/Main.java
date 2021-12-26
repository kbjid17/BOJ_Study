package prob_1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	static void makeSet() {
		parents = new int[V+1];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; //이미 같은 집합이면 합치지 않음
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); //a 정점
			int end = Integer.parseInt(st.nextToken()); //b 정점
			int weight = Integer.parseInt(st.nextToken()); //가중치
			edgeList[i] = new Edge(start,end,weight);
		}
		Arrays.sort(edgeList);
		
		makeSet();
		int cnt = 0; int result = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start,edge.end)) {
				result += edge.weight;
				if(++cnt == V-1) break; // union이 성립된 간선 수가 V-1 ==> 신장트리 완성
			}
		}
		System.out.println(result);
	}
}
