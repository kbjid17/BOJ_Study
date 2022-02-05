package prob_N과M8_15657_220205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] input,tgt;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		selected = new boolean[N];
		tgt = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		perm(0);
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(tgt[i] + " ");
				
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			if(tgtIdx > 0) {
				if(input[i] < tgt[tgtIdx-1]) continue;
			}
			tgt[tgtIdx] = input[i];
//			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}
	}
}
