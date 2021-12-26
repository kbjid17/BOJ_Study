package Prob_N과M3_15651_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ar,number;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N];
		number = new int[M];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}
	static void perm(int tgtIdx) { //중복조합
		if(tgtIdx == number.length) {
			for (int i = 0; i < number.length; i++) {
				sb.append(number[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < ar.length; i++) {
			
			number[tgtIdx] = ar[i];
			perm(tgtIdx+1);
		}
		
		
		
	}
}
