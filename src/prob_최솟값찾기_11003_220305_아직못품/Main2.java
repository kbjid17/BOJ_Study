package prob_최솟값찾기_11003_220305_아직못품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
	static Deque<Long> d = new LinkedList<Long>();
	static PriorityQueue<Long> p = new PriorityQueue<Long>();
	static StringBuilder sb = new StringBuilder();
	static int N,L;
	static long ans  =Long.MAX_VALUE;
	static long[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		ar = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ar[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			if(i <= L) {
				d.offer(ar[i]);
				ans = Math.min(ans, d.peek());
				sb.append(ans).append(" ");
			}
			else {
				d.offer(ar[i]);
				Long a = d.pollFirst();
				if(a != ans) {
					ans = Math.min(ans, d.peekLast());
				
				}
				else if(a == ans) {
					ans = Long.MAX_VALUE;
					for (Long l : d) {
						ans = Math.min(ans, l);
					}	
				}
				sb.append(ans).append(" ");
			}
		}
		System.out.println(sb);
	}

}

//1 1 1 2 2 2 2 2 3 3 2 2
