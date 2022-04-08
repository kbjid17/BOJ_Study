package prob_스티커_9465_220408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int n;
	static int[][] ar;
	static long[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			long answer = 0;
			n = Integer.parseInt(br.readLine());
			ar = new int[2][n];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp = new long[2][n];
			dp[0][0] = ar[0][0];
			dp[1][0] = ar[1][0];
			if(n >= 2) {
				dp[0][1] = dp[1][0] + ar[0][1];
				dp[1][1] = dp[0][0] + ar[1][1];
				for (int i = 2; i < n; i++) {
					dp[0][i] = Math.max(dp[1][i-2]+ar[0][i], dp[1][i-1]+ar[0][i]);
					dp[1][i] = Math.max(dp[0][i-2]+ar[1][i], dp[0][i-1]+ar[1][i]);
//					System.out.println(dp[0][i] + " " + dp[1][i]);
				}
			}
			
			answer = Math.max(dp[0][n-1], dp[1][n-1]);
			
			System.out.println(answer);
		}
	}

}
