package prob_1912_연속합_미완;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2_메모리초과 {
	static int[] ar;
	static long[][] dp;
	static long ans = Long.MIN_VALUE;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N];
		dp = new long[100000][100000];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = ar[i];
			ans = Math.max(ans, dp[i][i]);
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				dp[i][j] = dp[i][j-1]+ar[j];
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

}
