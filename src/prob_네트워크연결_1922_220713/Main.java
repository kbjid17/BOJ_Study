package prob_네트워크연결_1922_220713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] parents;
	static edge[] edgelist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edgelist = new edge[M];
		make();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgelist[i] = new edge(start,end,weight);
		}
		
		Arrays.sort(edgelist);
		
		int cnt = 0, result = 0;
		for (int i = 0; i < M; i++) {
			int start = edgelist[i].start;
			int end = edgelist[i].end;
			int weight = edgelist[i].weight;
			
			if(union(start,end)) {
				result += weight;
				if(++cnt == N-1) break;
			}
		}
		System.out.println(result);
	}

	static void make() {
		parents = new int[N+1];
		for (int i = 1; i < N; i++) {
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
	
	static class edge implements Comparable<edge>{
		int start;
		int end;
		int weight;
		public edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(edge o) {
			return this.weight - o.weight;
		}
	}
}
