package prob_1904_01타일;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])% 15746; //이거 안해주면 오버플로우 발생 우려가 있음.
		}
		System.out.println(dp[N]);
		
	}

}
