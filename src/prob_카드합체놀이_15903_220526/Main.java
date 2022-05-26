package prob_카드합체놀이_15903_220526;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long a,b,sum,ans;
	static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			a = pq.poll();
			b = pq.poll();
			sum = a+b;
			pq.offer(sum);
			pq.offer(sum);
		}
		
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
	}

}
