package prob_파이프옮기기1_17070_220308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dp_누적합 {
	static long[][] ar;
	static int N;
	static long ans;
	static long[][][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new long[N+1][N+1];
		dp = new long[3][N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			if(ar[1][i] == 1) break;
			dp[0][1][i] = 1;
		}
		
			// 0: 가로, 1: 세로, 2 : 대각선
			for (int i = 2; i <= N; i++) {
				for (int j = 3; j <= N; j++) {
					if(ar[i][j] == 1) continue;
						// 가로
						dp[0][i][j] = dp[0][i][j-1]+dp[2][i][j-1];
						
						//세로
						dp[1][i][j] = dp[1][i-1][j]+dp[2][i-1][j];
						
						// 대각선
						if(ar[i-1][j] ==0 && ar[i][j-1] == 0)
						dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
					
				}
			}
		
			for (int i = 0; i < 3; i++) {
				ans += dp[i][N][N];
			}
		System.out.println(ans);
	}

	
}
