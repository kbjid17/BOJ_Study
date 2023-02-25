package prob_공바꾸기_10813_230220;

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
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int temp = ar[a];
			ar[a] = ar[b];
			ar[b] = temp;
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(ar[i] + " ");
		}
	}

}
