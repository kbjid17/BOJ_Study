package prob_계단오르기_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int stairs;
	static int ar[],dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stairs = Integer.parseInt(br.readLine());
		ar = new int[301];
		dp = new int[301][2];

		for (int i = 1; i <= stairs; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		dp[1][0] = ar[1];
		dp[1][1] = 0;
		dp[2][0] = ar[1]+ar[2];
		dp[2][1] = ar[2];
		for (int i = 3; i <= stairs; i++) {
			dp[i][0] = dp[i-1][1] + ar[i];
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + ar[i];
		}
		System.out.println(Math.max(dp[stairs][0], dp[stairs][1]));
		
	}

}
