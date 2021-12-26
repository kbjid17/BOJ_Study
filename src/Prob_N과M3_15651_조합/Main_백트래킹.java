package Prob_N과M3_15651_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백트래킹 {
	static int N,M;
	static int[]  ar = new int[9];
	static boolean[] isused = new boolean[9];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		backtrack(0);
		System.out.println(sb);
	}

	static void backtrack(int tgtIdx) {
		if(tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ar[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
				ar[tgtIdx] = i;
				backtrack(tgtIdx+1);
		}
	}
}
