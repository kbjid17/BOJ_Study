package prob_구간합구하기5_11660_220224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5트_시간초과 {
	static int N,M;
	static int[][] ar;
	static long[][] sums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[N+1][N+1];
		sums = new long[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		// 5트 : 누적합 알고리즘을 삽입함. 그러나 알고리즘이 복잡하여 여전히 시간 초과 발생
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(j == 1) {
					sums[i][j] = sums[i-1][j]+ar[i][j];
				}
				else {
					sums[i][j] = sums[i][j-1];
					for (int k = 1; k <= i; k++) {
						sums[i][j] += ar[k][j];
					}
				}
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(sums[x2][y2]-(sums[x1-1][y2]+sums[x2][y1-1])+sums[x1-1][y1-1]);
		}
	}
}