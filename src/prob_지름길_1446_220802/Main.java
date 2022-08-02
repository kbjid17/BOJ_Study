package prob_지름길_1446_220802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,D; // 지름길(간선) 개수, 고속도로 길이
	static ArrayList<Edge> list = new ArrayList<Edge>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(end > D) continue;
			list.add(new Edge(start,end,weight));
		}
		int[] dist = new int[10001];
		Arrays.fill(dist, 10001);
		Collections.sort(list);
		dist[0] = 0;
		int idx = 0, move = 0;
		while(move < D) {
			if(idx < list.size()) {
				Edge e = list.get(idx);
				if(move == e.start) {
					dist[e.end] = Math.min(dist[e.end], dist[e.start]+ e.weight);
					idx++;
				}
				else {
					dist[move+1] = Math.min(dist[move]+1,dist[++move]);
				}
			}
			else {
				dist[move+1] = Math.min(dist[move]+1, dist[++move]);
			}
		}
		System.out.println(dist[D]);
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
			// TODO Auto-generated method stub
			if(this.start == o.start) {
				if(this.end == o.end) return this.weight - o.weight;
				return this.end - o.end;
			}
			return this.start - o.start;
		}
		
		
		
	}
}