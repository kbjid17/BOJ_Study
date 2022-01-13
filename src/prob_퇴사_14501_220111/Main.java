package prob_퇴사_14501_220111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long ans;
	static int[][] ar;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1][2];
		dp = new int[N+1];
		dp[0] = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				ar[i][0] = Integer.parseInt(st.nextToken());
				ar[i][1] = Integer.parseInt(st.nextToken());
				dp[i] = -1;
			}
		
		System.out.println(solve(0));
	}
	static int solve(int day) {
		if(day > N) return Integer.MIN_VALUE;
		if(day == N) return 0;
		
		
		if(dp[day] != -1) return dp[day];
		
		dp[day] = Math.max(solve(day+1), solve(day+ar[day][0]) + ar[day][1]);
		return dp[day];
	}
}
