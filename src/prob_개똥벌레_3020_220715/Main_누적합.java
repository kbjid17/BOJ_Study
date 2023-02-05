package prob_개똥벌레_3020_220715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_누적합 {
	static int N,H;
	static int[] ar;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	static int min_obstacle = Integer.MAX_VALUE;
	static int[] obstacle_ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ar = new int[N];
		obstacle_ar = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				if(j == 0) {
					dp[j] = 0;
				}
				if(j > 0) {
					dp[j] = dp[j-1];
				}
				if(j % 2 == 0) {
					if(ar[j] > i) {
						dp[j]++;
					}
				}
				else if(j % 2 != 0) {
					if(ar[j] > (H-1-i)) {
						dp[j]++;
					}
				}
			}
			obstacle_ar[dp[N-1]]++;
			if(min_obstacle > dp[N-1]) {
				min_obstacle = dp[N-1];
			}
		}
		sb.append(min_obstacle).append(" ").append(obstacle_ar[min_obstacle]);
		System.out.println(sb.toString());
	}
}