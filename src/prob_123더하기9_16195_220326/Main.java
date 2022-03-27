package prob_123더하기9_16195_220326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		long[][] dp = new long[1001][1001];
		
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		for (int i = 4; i <= 1000; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = (((dp[i-1][j-1]) % 1000000009 +dp[i-2][j-1]) % 1000000009 +dp[i-3][j-1]) % 1000000009;
			} 
		}
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // n을 1,2,3으로 구하는 방법의 수
			int m = Integer.parseInt(st.nextToken()); // n을 구할 때 m개 이햐의 수를 써야 함!
			long sum = 0;
			for (int i = 0; i <= m; i++) {
				sum = (sum+dp[n][i]) % 1000000009;
			}
			
			
			System.out.println(sum); // m개 이하의 수를 써서 n을 구하는 경우의 수
		}
	}

}

/*
 1 : 1
 2 : 2, 1 1
 3 : 3, 1 2 / 2 1, 1 1 1
 4 : 0, 1 3 / 3 1, 1 1 2/1 2 1/2 1 1, 1 1 1 1
 5 : 0, 2 3 / 3 2, 
*/