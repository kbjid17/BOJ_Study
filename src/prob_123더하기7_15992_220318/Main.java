package prob_123더하기7_15992_220318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M;
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp = new long[1001][1001];
	
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		
		

		for (int i = 4; i <= 1000; i++) {
			for (int j = 1; j <= i; j++) {
				if(i > j*3) continue;
				dp[i][j] = ((dp[i-1][j-1] + dp[i-2][j-1]) % 1000000009 + dp[i-3][j-1]) % 1000000009;
			}
		}
		for (int i = 0; i < T; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[N][M]);
		}

	}

}


/*
ar[1] = 1
dp[1][1] = 1
ar[2] = 2
dp[2][1] = 1 dp[2][2] = 1
ar[3] = 4
dp[3][1] = 1 dp[3][2] = 2 dp[3][3] = 1
ar[4] = 7
dp[4][1] = 0 dp[4][2] = 3 dp[4][3] = 3 dp[4][4] = 1
ar[5] = 13
dp[5][1] = 0 dp[5][2] = 2 dp[5][3] = 6 dp[5][4] = 4 dp[5][5] = 1 
ar[6] = 24
dp[6][1] = 0 dp[6][2] = 1 dp[6][3] = 7(dp[5][2] + 5) dp[6][4] = 10 dp[6][5] = 5 dp[6][6] = 1
ar[7] = 44
dp[7][1] = 0 dp[7][2] = 0 dp[7][3] = 6 dp[7][4] = 16(dp[6][3] + 9) dp[7][5] = 15 dp[7][6] = 6 dp[7][7] = 1   1123, 1222(4)
ar[8] = 81
dp[8][1] = 0 dp[8][2] = 0 dp[8][3] = 3 dp[8][4] = ? dp[8][5] = 30(12311 22211) dp[8][6] = 21 dp[8][7] = 7 dp[8][8] = 1
ar[9] = 149
dp[9][1] = 0 dp[9][2] = 0 dp[9][3] = 1 dp[9][4] = ? dp[9][5] = ?
ar[10] = 274
dp[10][1] = 0 dp[10][2] = 0 dp[10][3] = 0 dp[10][4] = ? dp[10][5] = ? dp[10][6] = 90


dp[i][i] = 1
dp[i][i-1] = dp[i-1][i-2] + 1
dp[i][i-2] = dp[i-1][i-3] + i-1(== (dp[i-1][i-3]-dp[i-2][i-4] -1)
dp[i][i-3] = dp[i-1][i-4] + (dp[i-1][i-4]-dp[i-2][i-5] + i-3)
if(i >3*j) dp[i][j] = 0
 */
