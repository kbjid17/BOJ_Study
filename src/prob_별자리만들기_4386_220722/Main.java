package prob_별자리만들기_4386_220722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parents;
	static ArrayList<edge> edgelist = new ArrayList<edge>();
	static vertex[] vertexlist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		vertexlist = new vertex[n];
		make();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double y = Double.parseDouble(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			vertexlist[i] = new vertex(y,x);
		}
		
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				edgelist.add(new edge(i,j,Math.sqrt(
						Math.pow(vertexlist[i].y-vertexlist[j].y, 2) +
						Math.pow(vertexlist[i].x-vertexlist[j].x, 2))));
			}
		}
		Collections.sort(edgelist);
		int cnt = 0;
		double result = 0.00;
		for (int i = 0; i < edgelist.size(); i++) {
			edge e = edgelist.get(i);
			if(union(e.start,e.end)) {
				result += e.weight;
				if(++cnt == n-1) {
					break;
				}
			}
		}
		System.out.println(Math.round(result * 100) / 100.0);
	}

	static void make() {
		parents = new int[n+1];
		
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
	
	
	static class edge implements Comparable<edge>{
		int start;
		int end;
		double weight;
		public edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return (int)(this.weight * 100.0) - (int)(o.weight*100.0);
		}
		
		
		
	}
	static class vertex {
		double y;
		double x;
		public vertex(double y, double x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
		
	}
}
