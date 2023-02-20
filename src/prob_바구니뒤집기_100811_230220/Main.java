package prob_바구니뒤집기_100811_230220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] ar = new int[N+1];
		for (int k = 0; k < ar.length; k++) {
			ar[k] = k;
		}
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			
			
			int[] temp = new int[j-i+2];
			for (int k = 1; k <= j-i+1; k++) {
				temp[k] = ar[j-k+1];
			}
			for (int k = i; k <= j; k++) {
				ar[k] = temp[k-i+1];
			}
			
		}
		for (int i = 1; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}

}
