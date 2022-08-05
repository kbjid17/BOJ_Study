package prob_회의준비_2610_220805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,M;
	static int[] parents;
	static int[][] ar;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parents = new int[N+1];
		ar = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(ar[i], 100000);
		}
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a][b] = 1;
			ar[b][a] = 1;
			union(a,b);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					ar[i][j] = Math.min(ar[i][j], ar[i][k] + ar[k][j]);
				}
			}
		}
		
		for (int i = 0; i < parents.length; i++) {
			if(!map.containsKey(parents[i])) {
					map.put(parents[i], new ArrayList<Integer>());			
				}
			map.get(parents[i]).add(i);
		}
		
		for (int i = 1; i <= N; i++) {
			if(!map.containsKey(i)) continue;
			int min_idx = i;
			int set_dis = Integer.MAX_VALUE;
			for (int j = 0; j < map.get(i).size(); j++) { 
				int max_dis = Integer.MIN_VALUE; 
				for (int k = 0; k < map.get(i).size(); k++) {
					if(j == k) continue;
					int dis = ar[map.get(i).get(j)][map.get(i).get(k)];
					max_dis = Math.max(max_dis, dis);
				}
				if(set_dis > max_dis) {
					set_dis = max_dis;
					min_idx = map.get(i).get(j);
				}
				else if(set_dis == max_dis) {
					min_idx = Math.min(min_idx, map.get(i).get(j));
				}
			}
			pq.offer(min_idx);
		}
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		for (int i = 0; i < parents.length; i++) {
			if(parents[i] == bRoot) parents[i] = aRoot;
		}
		return true;
	}
}
