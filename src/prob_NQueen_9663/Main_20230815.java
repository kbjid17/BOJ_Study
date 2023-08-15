package prob_NQueen_9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_20230815 {
	static int N;
	static int[] ar;
	static int ans = 0;
	static boolean[] visit1;
	static boolean[] visit2;
	static boolean[] visit3;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		visit1 = new boolean[N];
		visit2 = new boolean[2*N-1]; // 좌상 > 우하 대각선 확인
		visit3 = new boolean[2*N-1]; // 우상 > 좌하 대각선 확인

		
		queen(0);
		
		System.out.println(ans);
	}

	static void queen(int tgtIdx) {
		if(tgtIdx == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit1[i] || visit2[tgtIdx+i] || visit3[tgtIdx-i+(N-1)]) continue;
			
			visit1[i] = true;
			visit2[tgtIdx+i] = true;
			visit3[tgtIdx-i+(N-1)] = true;
			queen(tgtIdx+1);
			
			visit1[i] = false;
			visit2[tgtIdx+i] = false;
			visit3[tgtIdx-i+(N-1)] = false;
		}
	}
}
