package prob_다리놓기_1010_230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			10억번
			if (a == b) {
				System.out.println(1);
				continue;
			}
			dp = new long[b+1][b+1];// bCa
			for (int i = 1; i <= b; i++) {
				for (int j = 0; j <= i; j++) {
					if(j == 0) {
						dp[i][j] = 1;
						continue;
					}
					dp[i][j] = dp[i][j-1] * (i-j+1) /j; 
				} 
			}
			// bCa
			
//			for (int i = 1; i <= b; i++) {
//				for (int j = 1; j <= a; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(dp[b][a]);
		}
	}

}
