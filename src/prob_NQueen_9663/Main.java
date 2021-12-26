package prob_NQueen_9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,count,queencnt;
	static int[] ar;
	static int cnt;
	static boolean[] visit;
	static boolean[] visit_2;
	static boolean[] visit_3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		visit = new boolean[N];
		visit_2 = new boolean[2*N-1];
		visit_3 = new boolean[2*N-1];
		queen(0);
		System.out.println(count);
	}
	static void queen(int tgtIdx) {
		if(tgtIdx == N) {
			count++;
		}
			for (int i = 0; i < N; i++) {
				if(visit[i] || visit_2[tgtIdx - i + (N-1)] || visit_3[tgtIdx + i]) continue; // 한번 골랐던 행이면 제외
				//골랐을 때, 양측 대각선으로 다른 퀸을 잡을 수 없게 만들어야 함!
				
				ar[tgtIdx] = i;
				visit[i] = true;
				visit_2[tgtIdx - i + (N-1)] = true;
				visit_3[tgtIdx + i] = true;
				queen(tgtIdx+1); 
				visit[i] = false;
				visit_2[tgtIdx - i + (N-1)] = false;
				visit_3[tgtIdx + i] = false;
			}
	}
}
