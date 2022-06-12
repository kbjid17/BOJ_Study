package prob_보석도둑_1202_220530_220613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_3th {
	static int N,K;
	static int ans;
	static int[][] bags;
	static jewel[] jewels;
	static PriorityQueue<jewel> pq = new PriorityQueue<jewel>(new Comparator<jewel>() {
		@Override
		public int compare(jewel o1, jewel o2) {
			if(o1.V > o2.V) {
				return o2.V-o1.V;
			}
			else if(o1.V == o2.V) {
				if(o1.M > o2.M) {
					System.out.println(o1.M - o2.M);
				}
				else return o2.M - o1.M;
			}
			else return 1;
			return 0;
		}
	});
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		jewels = new jewel[N];
		bags = new int[K][2];
		
		for (int i = 0; i < N; i++) {
			// i번째 보석의 정보(M : 무게, V : 가격)
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels[i] = new jewel(M,V);
			pq.offer(jewels[i]);
		}
		
		
		for (int i = 0; i < K; i++) {
			// i번째 가방의 특징(C : 최대 무게)
			bags[i][0] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) return -1;
				else return 1;
			}
			
		});
		// 가장 무게가 작은 가방부터 보자.
		int cnt = 0;
		while(!pq.isEmpty()) {
			jewel j = pq.poll();
			System.out.println(j);
//			System.out.println(j);
			for (int i = 0; i < bags.length; i++) {
				if(bags[i][1] == 1) continue;
				if(bags[i][0] >= j.M) {
					cnt++;
					bags[i][1] = 1;
					ans += j.V;
					break;
				}
			}
			if(cnt == K) break;
		}
		
		// 가장 가중치가 높은 보석이 어느 가방으로 들어가는게 가장 알맞은가?
		System.out.println(ans);
	}
	
	static class jewel {
		int M; // 무게
		int V; // 가격
		public jewel(int m, int v) {
			super();
			M = m;
			V = v;
		}
		@Override
		public String toString() {
			return "jewel [M=" + M + ", V=" + V + "]";
		}
	}
}
