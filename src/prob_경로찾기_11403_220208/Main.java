package prob_경로찾기_11403_220208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(ar[i][j] > 0 || (i == k || k == j)) continue;
					if(ar[i][k] == 1 & ar[k][j] == 1) ar[i][j] = 1;

				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}

}
