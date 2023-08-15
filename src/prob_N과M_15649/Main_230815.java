package prob_N과M_15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_230815 {

	static int N,M;
	static int[] ar;
	static boolean[] selected = new boolean[9];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[M];
			bt(0);			


	}

	static void bt(int idx) {
		
		if(idx == M) {
			for (int i = 0; i < ar.length; i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(selected[i]) continue;
			
			ar[idx] = i;
			selected[i] = true;
			
			bt(idx+1);
			selected[i] = false;
			
		}
	}
}
