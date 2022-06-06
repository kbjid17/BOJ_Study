package prob_오르막길_11057_220606;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[][] ar = new long[1001][11];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 10; i++) {
			ar[1][i] = i;
		}
		
		for (int i = 2; i <= 1000; i++) {
			for (int j = 1; j <= 10; j++) {
				ar[i][j] = (ar[i][j-1] % 10007 + ar[i-1][j] % 10007) % 10007;
			}
		}
		
		System.out.println(ar[N][10]);	
	}

}
