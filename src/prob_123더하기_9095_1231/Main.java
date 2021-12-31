package prob_123더하기_9095_1231;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T,N;
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[11];
		ar[1] = 1;
		ar[2] = 2;
		ar[3] = 4;
		for (int i = 4; i <= 10; i++) {
			ar[i] = ar[i-1] + ar[i-2] + ar[i-3];
		}
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(ar[n]);
		}

	}

}
