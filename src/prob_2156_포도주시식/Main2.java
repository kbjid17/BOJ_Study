package prob_2156_포도주시식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

	static int n,sum;
	static int max = Integer.MIN_VALUE;
	static int[] ar;
	static Integer[] dp; //dp : 누적합을 저장하는 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ar = new int[n+1];
		dp = new Integer[n+1];
		for (int i = 1; i <= n; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = ar[1];
		
		//1번 후 한칸 이동해서 1은 됨.
		//1번 후 한칸 이동해서 2는 안됨.
		//(0913) top - down 방식 또는 bottom-up 방식으로 풀 수 있음.
		if(n > 1) {
			dp[2] = ar[1]+ ar[2];
		}
		
		System.out.println(recur(n));
	}
		//dp를 뭐라고 정의해야 하지? : n까지 쓰는 함수랑 n 전까지 쓰는 함수가 그대로 계속 이어지는 논리를 사용(ex.점화식)
	
	static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(Math.max(recur(n-2), recur(n-3)+ar[n-1]) + ar[n], recur(n-1));
		}
		
		return dp[n];
	}
}