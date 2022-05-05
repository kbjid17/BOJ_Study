package prob_내리막길_1520_220504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dp {
	static int N,M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static long[][] dp;
	
	static long ans = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ar = new int[M][N];
		dp = new long[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		
		System.out.println(dfs_dp(0,0));
	}
	
	
static long dfs_dp(int y,int x) {
	
	if(y == M-1 && x == N-1) {
		return 1;
	}
	if(dp[y][x] != -1) {
		return dp[y][x];
	} 
	else {
		
		dp[y][x] = 0;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || ny >= M || nx < 0 || nx >= N || ar[y][x] <= ar[ny][nx]) continue;
			
			dp[y][x] += dfs_dp(ny,nx);
		}
	}
	
	return dp[y][x];
}
}
