package prob_소형기관차_2616_220719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n+1];
		int[] dp = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		int num = Integer.parseInt(br.readLine());
		
		int[][] train = new int[4][n+1];

		for (int i = 1; i < dp.length; i++) {
				dp[i] = dp[i-1] + ar[i];
		}
		// ar 배열에서 i~i+num 의 구간 3개를 골라, 합을 구하고
		// 그렇게 구해지는 여러 합들 중 최댓값을 구하는 문제.
		// 1. 객차 구간을 정하는 알고리즘 필요(3개의 구간을 구해야 하며, 구간이 겹치면 안됨.)
		// 2. 구해진 객차들의 합을 모두 구한다
		
		for (int i = 1; i <= 3; i++) {
			for (int j = i*num; j <= n; j++) {
				train[i][j] = Math.max(train[i][j-1], train[i-1][j-num] + (dp[j]-dp[j-num]));
			}
		}
		
		System.out.println(train[3][n]);
	}

}
