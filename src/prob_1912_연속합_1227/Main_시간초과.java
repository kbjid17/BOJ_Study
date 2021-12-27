package prob_1912_연속합_1227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_시간초과 {

	static int N;
	static int[] ar;
	static int num = Integer.MIN_VALUE,numb;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			numb = ar[i];
			for (int j = i+1; j < N; j++) {
				num = Math.max(num, numb);
				numb += ar[j];
				
			}
		}
		sb.append(num);
		System.out.println(sb);
	}
}