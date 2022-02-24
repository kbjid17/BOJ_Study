package prob_구간합구하기5_11660_220224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2트_메모리초과 {
	static int N,M;
	static int[][] ar;
	static int[][][][] sums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[N+1][N+1];
		sums = new int[N+1][N+1][N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 2트 : 반복문 개수를 6개 -> 4개로 줄여버림
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum = 0;
				for (int i2 = i; i2 <= N; i2++) {
					for (int j2 = j; j2 <= N; j2++) {
						sum+= ar[i2][j2];
						sums[i][j][i2][j2] = sum;
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
			System.out.println(sums[x1][y1][x2][y2]);
		}
	}

}