package prob_1912_연속합_미완;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4_해결 {
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
		}
		
		dp[0] = ar[0];
		ans = Math.max(dp[0], ans);
		for (int i = 1; i < N; i++) {
				dp[i] = Math.max(dp[i-1] + ar[i], ar[i]); // 연속 합 알고리즘
				// 
				ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}
}
