package prob_2225_합분해_3트만에해결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N,K;
	static int num;
	static long dp[];
	//더해지는 정수는 같을 수 있음. (0,0 이나 10, 10 등 모두 가능)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new long[201];
		dp[1] = 1;
		dp[2] = N+1;
		
		for (int i = 3; i <= K; i++) {
			dp[i] = ((dp[i-1]*(dp[i-1]+1))/2) % 1000000000;
		}
		//값이 너무 높을 경우, 10억으로 나눈 값 마저도 int형의 한계를 넘어섬.
		System.out.println(dp[K]);
	}
}

//20 2 --> 0~20까지의 수 중 2개를 써서 20을 만들 수 있는 경우의 수
//조합 쓰면 모든 경우의 수를 다 쓰니까 안되고
//점화식을 구하는 것이 관건일듯