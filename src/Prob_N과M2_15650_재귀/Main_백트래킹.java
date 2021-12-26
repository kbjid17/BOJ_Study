package Prob_N과M2_15650_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백트래킹 {
	static int N,M;
	static int[]  ar = new int[9];
	static boolean[] isused = new boolean[9];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		backtrack(0,1);
	}

	static void backtrack(int tgtIdx,int srcIdx) {
		if(tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = srcIdx; i <= N; i++) {
				ar[tgtIdx] = i;
				backtrack(tgtIdx+1,i+1);
		}
	}
}
