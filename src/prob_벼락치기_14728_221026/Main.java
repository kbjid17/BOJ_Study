package prob_벼락치기_14728_221026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[][] ar;
	static int[][] test;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		ar = new int[N+1][T+1];
		test = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 2; j++) {
				test[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(test, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}});
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= T; j++) {
				if(j < test[i][1]) ar[i][j] = ar[i-1][j];
				else {
					ar[i][j] = Math.max(ar[i-1][j], ar[i-1][j-test[i][1]] + test[i][2]);
				}
			}
		}

		
		System.out.println(ar[N][T]);
	}

}
