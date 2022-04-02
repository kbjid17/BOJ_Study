package prob_피보나치수7_15624_220402;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[] dp = new long[1000001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			dp[i] = (dp[i] +  ((dp[i-1]+dp[i-2]) % 1000000007)) % 1000000007;
		}
		System.out.println(dp[Integer.parseInt(br.readLine())]);

	}

}
