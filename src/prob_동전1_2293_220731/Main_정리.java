package prob_동전1_2293_220731;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n][m+1];
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			if(i == 0) {
				int idx = val;
				while(idx <= m) {
					dp[i][idx]++;
					idx += val;
				}
			}
			else {
				for (int j = 0; j < dp[i].length; j++) {
					int idx_2 = j;
					while(idx_2 >= 0) {
						dp[i][j] += dp[i-1][idx_2];
						idx_2 -= val;
					}
				}
			}
		}
		System.out.println(dp[n-1][m]);
	}
}