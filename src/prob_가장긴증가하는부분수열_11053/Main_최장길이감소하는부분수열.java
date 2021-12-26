package prob_가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_최장길이감소하는부분수열 {
	static int N, min = Integer.MIN_VALUE;
	static int[] ar;
	static int[] lis;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		//최장 길이 감소하는 부분수열
		for (int i = N-1; i >= 0; i--) {
			lis[i] = 1;
			for (int j = N-1; j >= i; j--) {
				if(ar[j] < ar[i]) {
					System.out.println(ar[j]);
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			min = Math.max(min, lis[i]);
			System.out.println("min 값 : " + min);
			System.out.println();
		}
		System.out.println(min);
	}

}
