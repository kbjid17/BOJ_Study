package prob_팰린드롬_10942_220809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i][i] = 1;
		}
		for (int i = 1; i <= n-1; i++) {
			if(ar[i] == ar[i+1]) dp[i][i+1] = 1;
		}
		
		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n-i; j++) {
				if(ar[j] == ar[j+i] && dp[j+1][j+i-1] == 1) dp[j][j+i] = 1;
			}
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(dp[a][b]).append("\n");
		}
		
		System.out.println(sb);
	}
}
