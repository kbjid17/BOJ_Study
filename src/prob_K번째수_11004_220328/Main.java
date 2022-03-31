package prob_K번째수_11004_220328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int A,N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[] ar = new int[A];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		System.out.println(ar[N-1]);
	}

}
