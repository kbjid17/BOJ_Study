package prob_2225_합분해_3트만에해결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	static int N,K;
	static long dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new long[N+1][K+1];
		Arrays.fill(dp[0], 1);
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i-1][j]+dp[i][j-1]) % 1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}
}

//더해지는 정수는 같을 수 있음. (0,0 이나 10, 10 등 모두 가능)
//dp[i][j] = dp[i][j-1] + dp[0~i-1][j-1]; ex.dp[20][2] = dp[0][1]+dp[1][1]+dp[2][1]...+dp[20][1]; ==> dp[20][2] = dp[19][2]+dp[20][1];
//20 2 --> 0~20까지의 수 중 2개를 써서 20을 만들 수 있는 경우의 수
//조합 쓰면 모든 경우의 수를 다 쓰니까 안되고
//점화식을 구하는 것이 관건일듯