package prob_1912_연속합_미완;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3_시간초과 {
	static int[] ar;
	static long[] dp;
	static long ans = Long.MIN_VALUE;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N];
		dp = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			dp[i] = ar[i];
			ans = Math.max(ans, dp[i]);
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				dp[i] += ar[j];
				ans = Math.max(ans, dp[i]);
			}
		}
		System.out.println(ans);
	}

}
