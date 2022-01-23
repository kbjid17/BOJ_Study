package prob_약수의합_17425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2 {
	static int N;
	static int[] ar;
	static long[] ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[1000001];
		ans = new long[1000001];
		Arrays.fill(ar, 1);
		ans[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			for (int j = 1; j*i <= 1000000; j++) {
				ar[i*j] += i;
			}
			ans[i] = ar[i];
		}
		for (int i = 1; i <= 1000000; i++) {
			ans[i] += ans[i-1];
		}
		for (int i = 0; i < N; i++) {
			sb.append(ans[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
	}

}
