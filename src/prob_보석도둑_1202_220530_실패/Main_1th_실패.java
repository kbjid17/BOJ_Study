package prob_보석도둑_1202_220530_실패;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1th_실패 {
	static int N,K;
	static ArrayList<bag> list = new ArrayList<bag>();
	static PriorityQueue<jewel> pq = new PriorityQueue<jewel>(new Comparator<jewel>() {

		@Override
		public int compare(jewel o1, jewel o2) {
			if(o1.v > o2.v) return -1;
			else return 1;
		}
		
	});
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 보석 총 N개
		K = Integer.parseInt(st.nextToken()); // 상덕이는 가방을 K개 가지고 있다.
		
		// 각 가방에는 최대 1개의 보석만 담을 수 있음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // i번 보석의 무게 M
			int V = Integer.parseInt(st.nextToken()); // i번 보석의 가격 V
			pq.offer(new jewel(M,V));
		}
		
		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine()); // i번째 가방에 담을 수 있는 최대 무게 C
			list.add(new bag(null,C));
		}
		
		Collections.sort(list, new Comparator<bag>() {
			@Override
			public int compare(bag o1, bag o2) {
				if(o1.c < o2.c) return 1;
				else return -1;
			}
		});
		
		while(!pq.isEmpty()) {
			jewel j = pq.poll();
			
			for (int i = 0; i < list.size(); i++) {
				bag b = list.get(i);
				if(b.c >= j.m) {
					System.out.println(b);
					ans += j.v;
					list.remove(i);
					break;
				}
			}
		}
		System.out.println(ans);
	}
	
	static class bag {
		jewel j;
		int c;
		public bag(jewel j, int c) {
			super();
			this.j = j;
			this.c = c;
		}
		@Override
		public String toString() {
			return "bag [j=" + j + ", c=" + c + "]";
		}
		
		
	}

	
	static class jewel{
		int m; // 무게
		int v; // 가격
		public jewel(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public String toString() {
			return "jewel [m=" + m + ", v=" + v + "]";
		}

		
	}
}
