package prob_이친수_2193_220306;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N; // N자리 이친수의 개수
	static long[] dp = new long[91];
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= 90; i++) {
			dp[i] = dp[i-2]+ dp[i-1];
		}
		N = Integer.parseInt(br.readLine());
		
		System.out.println(dp[N]);
	}

}
