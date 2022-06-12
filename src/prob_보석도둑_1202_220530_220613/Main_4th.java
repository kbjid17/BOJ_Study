package prob_보석도둑_1202_220530_220613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4th {
	static int N,K; // 보석 수 N, 가방 수 K
	static ArrayList<jewel> jewels = new ArrayList<jewel>();
	static int[] bags;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bags = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 무게
			int V = Integer.parseInt(st.nextToken()); // 가격
			jewels.add(new jewel(M,V));
		}
		
		Collections.sort(jewels, (o1,o2) -> o1.M-o2.M);
		
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> o2 - o1);
		for (int i = 0; i < bags.length; i++) {
			while(idx < jewels.size() && jewels.get(idx).M <= bags[i]) {
				jewel j = jewels.get(idx++);
				pq.offer(j.V);
			}
			if(!pq.isEmpty()) ans += pq.poll();
		}
		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		System.out.println(ans);
	}
	static class jewel {
		int M;
		int V;
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
