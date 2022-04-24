package prob_가장큰정사각형_1915_220423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// DP(해설 보고 해결)
public class Main {

	static int N,M;
	static int[][] ar;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N+1][M+1];

		for (int i = 1; i <= N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				ar[i][j] = c[j-1]-'0';
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(ar[i][j] != 0) {
					ar[i][j] = Math.min(ar[i-1][j-1], Math.min(ar[i-1][j], ar[i][j-1])) + 1;
					ans = Math.max(ans, ar[i][j]);
				}
			}
		}
		System.out.println(ans*ans);
	}

}
