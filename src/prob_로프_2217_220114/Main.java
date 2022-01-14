package prob_로프_2217_220114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N,ans;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int [N];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ar);
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, ar[i]*(N-i));
		}
		System.out.println(ans);
	}

}
