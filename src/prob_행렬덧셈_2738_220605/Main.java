package prob_행렬덧셈_2738_220605;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] ar = new int[N][M];
		
		for (int t = 1; t <= 3; t++) {
			if(t == 3) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						System.out.print(ar[i][j] + " ");
					}
					System.out.println();
				}
			}
			else {
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < M; j++) {
						ar[i][j] += Integer.parseInt(st.nextToken());
					}
				}
			}
		}
	}
}