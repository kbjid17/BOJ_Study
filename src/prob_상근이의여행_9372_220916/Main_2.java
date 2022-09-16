package prob_상근이의여행_9372_220916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2 {

	static int[] parents;
	static ArrayList<edge> edgelist = new ArrayList<edge>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edgelist.add(new edge(a,b));
			}
//			Collections.sort(edgelist);
//			int cnt = 0;
//			int result = 0;
//			for (int i = 0; i < edgelist.size(); i++) {
//				edge e = edgelist.get(i);
//				if(union(e.start, e.end)) {
//					result++;
//					if(++cnt == n-1) {
//						break;
//					}
//				}
//			}
			System.out.println(n-1);
		}
		

	}

	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static class edge implements Comparable<edge>{
		int start;
		int end;
		public edge(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(edge o) {
			if(this.start < o.start) return 1;
			else {
				if(this.end <= o.end) return 1;
				else return -1;
			}
		}
	}
}
