package prob_부분수열의합_230815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,S, ans;
	static int[] ar;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		ar = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			bt(0,0,i,0);
		}
		
		System.out.println(ans);
	}

	static void bt(int tgtIdx, int srcIdx, int size, long sum) {
		if(tgtIdx == size) {
			if(sum == S) {
//				System.out.println(size);
				ans++;
			}
			return;
		}
		
		for (int i = srcIdx; i < ar.length; i++) {
			bt(tgtIdx+1,i+1, size, sum+ar[i]);
			
		}
	}
}
