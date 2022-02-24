package prob_구간합구하기5_11660_220224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3트_메모리초과 {
	static int N,M;
	static int[][][][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		//3트 : 아예 4차원 ar 배열 하나로 처리하고자 했음
		ar = new int[N+1][N+1][N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j][0][0] = Integer.parseInt(st.nextToken());
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum = 0;
				for (int i2 = i; i2 <= N; i2++) {
					for (int j2 = j; j2 <= N; j2++) {
						sum+= ar[i2][j2][0][0];
						ar[i][j][i2][j2] = sum;
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
			System.out.println(ar[x1][y1][x2][y2]);
		}
	}
}