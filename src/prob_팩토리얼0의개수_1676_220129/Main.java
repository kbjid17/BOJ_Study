package prob_팩토리얼0의개수_1676_220129;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,cnt;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1~4 : 0 추가 x
		//1 2 6 24 120 720 5040 40320 362880 3628800
		// 4*25 = 100 
		N = Integer.parseInt(br.readLine());
		dp = new int[501];
		for (int i = 1; i <= 500; i++) {
			cnt = 0;
			cnt += i/5;
			cnt += i/25;
			cnt += i/125;
			dp[i] = cnt;
		}
		System.out.println(dp[N]);
	}

}
