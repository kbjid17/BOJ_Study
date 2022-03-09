package prob_수열_2559_220305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static int N,M;
	static int sum, max = Integer.MIN_VALUE;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= M; i++) {
			d.offerLast(ar[i]);
			sum+= ar[i];
		}
		max = Math.max(max, sum);
		for (int i = 1; i <= N-M; i++) {
			int a = d.pollFirst();
			d.offerLast(ar[M+i]);
			sum = sum - a + d.peekLast();
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
