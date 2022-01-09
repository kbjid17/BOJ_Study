package prob_회전하는큐_1021_220109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long n1,n2;
	static long ans;
	static Deque<Integer> d1 = new LinkedList<Integer>();
	static Deque<Integer> d2 = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			d1.offer(i);
			d2.offer(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			n1 = 0;
			n2 = 0;
			int num = Integer.parseInt(st.nextToken());
			//계산1
			while(d1.peekFirst() != num) {
				d1.offerLast(d1.pollFirst());
				n1++;
			}
			//게산2
			while(d2.peekFirst()!= num) {
				d2.offerFirst(d2.pollLast());
				n2++;
			}
			ans+= Math.min(n1,n2);
			d1.pollFirst();
			d2.pollFirst();
		}
		
		System.out.println(ans);
	}
}