package prob_카드정렬하기_1715_220525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2th {
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
		long sum = 0;
		while(pq.size() > 1) {
			long a = pq.poll();
			long b = pq.poll();
			sum += (a+b);
			long val = a+b;
			pq.offer(val);
		}
		
		System.out.println(sum);
	}
}
