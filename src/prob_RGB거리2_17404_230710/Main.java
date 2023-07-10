package prob_RGB거리2_17404_230710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ar;
	static long[][] dp;
	static long ans = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N][3];
		dp = new long[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int c = 0; c < 3; c++) {
			for (int i = 0; i < 3; i++) {
				if(i == c)
					dp[0][i] = ar[0][i];
				else 
					dp[0][i] = 1000001;
			}
			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i-1][1] + ar[i][0], dp[i-1][2] + ar[i][0]);
				dp[i][1] = Math.min(dp[i-1][0] + ar[i][1], dp[i-1][2] + ar[i][1]);
				dp[i][2] = Math.min(dp[i-1][0] + ar[i][2], dp[i-1][1] + ar[i][2]);
			}
//			dp[N-1][c] = Long.MAX_VALUE;
//			for (int i = 0; i < 3; i++) {
//				if(i == c) continue;
//				dp[N-1][c] = Math.min(dp[N-1][c], dp[N-2][i] + ar[N-1][c]);
//			}
			for (int i = 0; i < 3; i++) {
				if(i == c) continue;
				ans = Math.min(ans, dp[N-1][i]);
			}
		}
			System.out.println(ans);
		
	}
}
