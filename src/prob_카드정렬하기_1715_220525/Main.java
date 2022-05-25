package prob_카드정렬하기_1715_220525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static long ans,value;
	static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			long a = Integer.parseInt(br.readLine());
			pq.offer(a);
		}
		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		ans = pq.poll();
		if(!pq.isEmpty()) {
			long ans_b = pq.poll();
//			System.out.println(ans_b);
			ans += ans_b;
//			System.out.println(ans);
			value = ans;
			while(!pq.isEmpty()) {
				long val = pq.poll();
//				System.out.println(val);
//				System.out.println(ans+"에 "+val+"를 더해서 "+(ans+val));
				value = value+val;
//				System.out.println("value : " + value);
				ans += value;
			}
		}
		System.out.println(ans);
	}
}
