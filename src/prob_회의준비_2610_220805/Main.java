package prob_회의준비_2610_220805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parents;
	static int[][] ar;
	static int result;
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
			if(union(a,b)) result++;
		}
		
		// 중간에 대푯값의 재설정 과정이 필요함
		// 플로이드로 경로 최적화
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					ar[i][j] = Math.min(ar[i][j], ar[i][k] + ar[k][j]);
				}
			}
		}
		
//		for (int i = 1; i < N+1; i++) {
//			for (int j = 1; j < N+1; j++) {
//				System.out.print(ar[i][j] + " ");
//			}
//		System.out.println();
//	}
		
		for (int i = 0; i < parents.length; i++) {
			if(!map.containsKey(parents[i])) {
					map.put(parents[i], new ArrayList<Integer>());			
				}
			map.get(parents[i]).add(i);
		}
		
		for (int i = 1; i <= N; i++) {
			if(!map.containsKey(i)) continue;
//			System.out.println(i + " 발견" +  map.get(i).toString());
			int min_idx = i;
			int set_dis = Integer.MAX_VALUE; // 최소 거리를 저장하기 위함
			for (int j = 0; j < map.get(i).size(); j++) { // j번에서 k번으로 가는 거리를 계산할거임 (i번 키 그룹의 최대 거리가 가장 작은 대표값의 경우를 찾는다)
				int max_dis = Integer.MIN_VALUE; // i번 그룹 내 j번 원소에서의 최대 이동 거리를 저장할것
				for (int k = 0; k < map.get(i).size(); k++) {
					if(j == k) continue;
					int dis = ar[map.get(i).get(j)][map.get(i).get(k)];
					max_dis = Math.max(max_dis, dis);
				}
//				System.out.println(map.get(i).get(j) + " : " + max_dis);
				if(set_dis > max_dis) {
					set_dis = max_dis;
					min_idx = map.get(i).get(j);
//					System.out.println("ffffffffff " + min_idx);
//					System.out.println(set_dis + " and " + min_idx);
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
