package prob_FourSquare_17626_220430;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2th {
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[50001];
		dp[1] = 1;
		for (int i = 2; i <= 50000; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int j = 1; j*j <= i; j++) {
				int a = i-j*j;
				min = Math.min(min, dp[a]);
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[n]);
	}

}
