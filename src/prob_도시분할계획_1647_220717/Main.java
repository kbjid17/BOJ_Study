package prob_도시분할계획_1647_220717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parents;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(start,end,weight);
		}
		
		Arrays.sort(edgeList);
		make();
		
		int cnt = 0, result = 0;
		for (int i = 0; i < edgeList.length; i++) {
			Edge e = edgeList[i];
			if(union(e.start, e.end)) {
				result += e.weight;
				if(++cnt == N-1) {
					result -= e.weight;
					break;
				}
			}
		}
		System.out.println(result);
	}
	
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
			return this.weight - o.weight;
		}
		
	}

	
	static void make() {
		parents = new int[N+1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
