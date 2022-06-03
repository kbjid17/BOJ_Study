package prob_보석도둑_1202_220530_실패;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static ArrayList<bag> list = new ArrayList<bag>();
	static int[] bags;
	static jewel[] jewels;
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
		
		jewels = new jewel[N];
		bags = new int[K];
		// 각 가방에는 최대 1개의 보석만 담을 수 있음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // i번 보석의 무게 M
			int V = Integer.parseInt(st.nextToken()); // i번 보석의 가격 V
//			pq.offer(new jewel(M,V));
			
			jewels[i] = new jewel(M,V,false);
		}
		
		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine()); // i번째 가방에 담을 수 있는 최대 무게 C
//			list.add(new bag(null,C));
			bags[i] = C;
		}
		
		Arrays.sort(bags);
		Arrays.sort(jewels, new Comparator<jewel>() {

			@Override
			public int compare(jewel o1, jewel o2) {
				if(o1.m == o2.m) {
					return o2.v - o1.v;
				}
				return o1.m - o2.m;
			}
			
		});
		

		
		for (int i = 0; i < bags.length; i++) {
			PriorityQueue<jewel> pq = new PriorityQueue<jewel>(Collections.reverseOrder());
			for (int j = 0; j < jewels.length; j++) {
				if(!jewels[j].isSelected && bags[i] >= jewels[j].m) {
					pq.offer(jewels[j]);
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
		boolean isSelected;
		public jewel(int m, int v, boolean isSelected) {
			super();
			this.m = m;
			this.v = v;
			this.isSelected = isSelected;
		}
		@Override
		public String toString() {
			return "jewel [m=" + m + ", v=" + v + ", isSelected=" + isSelected + "]";
		}
		
		
		
	}
}
