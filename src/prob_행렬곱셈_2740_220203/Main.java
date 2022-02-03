package prob_행렬곱셈_2740_220203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] ar,ar2,ar3;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ar2 = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				ar2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ar3 = new int[N][K];
		for (int i = 0; i < N; i++) {
			int num = 0;
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < M; k++) {
					ar3[i][j] += ar[i][k] * ar2[k][j];
				}
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(ar3[i][j] + " ");
			}
			System.out.println();
		}
	}

}
