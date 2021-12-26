package prob_1912_연속합_미완;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] ar;
	static int[] dp;
	static int num = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				dp[i] = Math.max(0, ar[0]);
			} else {
				dp[i] = Math.max(dp[i-1], dp[i-1]+ar[i]);
			}
		}
		
		System.out.println(dp[N-1]);
	}
}