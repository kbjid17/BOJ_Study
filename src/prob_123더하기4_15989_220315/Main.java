package prob_123더하기4_15989_220315;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T,N;
	static long[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new long[10001];
		ar[0] = 1;
		ar[1] = 1;
		ar[2] = 2;
		ar[3] = 3;
		ar[4] = 4;
		
		for (int i = 5; i <= 10000; i++) {
			ar[i] = 1+(ar[i-2] - ar[i-5])+(ar[i-3]);
//			System.out.println(ar[i]);
		}
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(ar[n]);
		}

	}

}
