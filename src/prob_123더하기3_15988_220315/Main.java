package prob_123더하기3_15988_220315;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T,N;
	static long[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new long[1000001];
		ar[1] = 1;
		ar[2] = 2;
		ar[3] = 4;
		for (int i = 4; i <= 1000000; i++) {
			ar[i] = ((ar[i-1] % 1000000009) + (ar[i-2] % 1000000009) + (ar[i-3] % 1000000009)) % 1000000009;
		}
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(ar[n]);
		}

	}

}
