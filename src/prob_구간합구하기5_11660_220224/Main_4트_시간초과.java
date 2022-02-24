package prob_구간합구하기5_11660_220224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4트_시간초과 {
	static int N,M;
	static int[][] ar;
	static long[][] sums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		// 4트 : 4차원 배열을 사용하면 메모리 초과가 발생한다 판단. 2차원 배열로 일반적으로 알려진 메모리제이션을 사용하고자 했음
		// 누적합이 없어서 시간 초과 발생
		ar = new int[N+1][N+1];
		sums = new long[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				
				for (int i2 = 1; i2 <= i; i2++) {
					for (int j2 = 1; j2 <= j; j2++) {
						sums[i][j] += ar[i2][j2];
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