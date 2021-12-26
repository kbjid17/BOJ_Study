package prob_가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,max = Integer.MIN_VALUE, min = Integer.MIN_VALUE;
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
		//최장 길이 증가하는 부분수열
		for (int i = 0; i < N; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if(ar[j] < ar[i]) {
					System.out.println(ar[j]);
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			max = Math.max(max, lis[i]);
			System.out.println("max 값 : " + max);
		}
		System.out.println(max);
	}

}
