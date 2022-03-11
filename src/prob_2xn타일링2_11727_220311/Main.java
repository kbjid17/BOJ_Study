package prob_2xn타일링2_11727_220311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
//	static long[] ar;
	static long[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new long[1001];
//		ar = new long[1001];
//		ar[1] = 2;
//		for (int i = 2; i <= 1000; i++) {
//			ar[i] = (ar[i-1]*2) % 10007;
//		}
		dp[1] = 1;
		dp[2] = 3;
//		for (int i = 2; i <= 1000; i++) {
//			dp[i] = (ar[i]-(dp[i-1]% 10007)) % 10007;
//		}
		for (int i = 3; i <= 1000; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
		}
		System.out.println(dp[N]);
		
	}

}
