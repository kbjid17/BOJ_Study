package prob_Coins_3067_220322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] ar = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < ar.length; j++) {
				ar[j] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];
			for (int j = 0; j < ar.length; j++) {
				dp[ar[j]]+=1;
				for (int d = ar[j]; d <= M; d++) {
					dp[d] += dp[d-ar[j]];
				}
			}
			
			System.out.println(dp[M]);
		}

	}

}
