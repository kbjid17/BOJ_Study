package prob__쉬운계단수_10084_1226;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int N;
	static long[][] dp;
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		dp = new long[101][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i < 101; i++) {
			for (int j = 0; j < 10; j++) {
				if(j == 0 ) {
					dp[i][j] = dp[i-1][1] %1000000000;	
				} else if(j == 9){
					dp[i][j] = dp[i-1][8] %1000000000;
				} else {
					dp[i][j] = dp[i-1][j-1] %1000000000 + dp[i-1][j+1] %1000000000;
				}
				
			}
		}
		
		for (int i = 1; i < 10; i++) {
			ans+= dp[N][i]%1000000000;
		}
		System.out.println(ans%1000000000);
	}
}