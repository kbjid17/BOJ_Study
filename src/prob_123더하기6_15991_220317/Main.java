package prob_123더하기6_15991_220317;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T,N;
	static long[][] dp;
	static long[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[4][100001];
		ar = new long[100001];
		
		ar[0] = 1;
		ar[1] = 1; //1 
		ar[2] = 2; // 2
		ar[3] = 2; // 1+2 2+1 3
		ar[4] = 3; // 1+2+1 1+3 3+1
		ar[5] = 3;
		
		

		for (int i = 6; i <= 100000; i++) {
//			System.out.println(i + "의 경우");
			ar[i] = (ar[i-2] + ar[i-4] + ar[i-6]) % 1_000_000_009;

		}
		for (int i = 0; i < N; i++) { 
			int n = Integer.parseInt(br.readLine());

			System.out.println(ar[n]);
		}

	}

}


/*
 d[0] = 0 (1로 취급)
 d[1] = 1 (1);
 d[2] = 1+1, 2 (2)
 d[3] = 1+1+1, 3 (2)
 d[4] = 1+1+1+1, 1+2+1, 2+2 (3)
 d[5] = 1+1+1+1+1, 1+3+1, 2+1+2 (3)
 d[6] = 1+1+1+1+1+1, 1+1+2+1+1, 1+2+2+1, 2+1+1+2, 2+2+2, 3+3 (6)
 d[7] = 1+1+1+1+1+1+1, 1+2+1+2+1, 1+1+3+1+1, 2+1+1+1+2, 2+3+2, 3+1+3 (6)
 d[8] = 1+1+1+1+1+1+1+1, 1+1+1+2+1+1+1, 1+1+2+2+1+1, 1+2+1+1+2+1, 1+2+2+2+1, 1+3+3+1, 2+1+1+1+1+2, 2+1+2+1+2, 2+2+2+2, 3+1+1+3, 3+2+3 (11)
 */
