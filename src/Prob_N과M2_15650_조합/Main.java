package Prob_N과M2_15650_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ar,number;
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
		comb(0,0);
	}
	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx == number.length) {
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}
		if(srcIdx == ar.length) return;
		number[tgtIdx] = ar[srcIdx];
		comb(srcIdx+1,tgtIdx+1);
		comb(srcIdx+1,tgtIdx);
		
		
		
	}
}
