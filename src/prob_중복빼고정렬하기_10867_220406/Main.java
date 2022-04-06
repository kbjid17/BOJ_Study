package prob_중복빼고정렬하기_10867_220406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ar = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		sb.append(ar[0]);
		for (int i = 1; i < n; i++) {
			if(ar[i] == ar[i-1]) continue;
			sb.append(" ").append(ar[i]);
		}
		System.out.println(sb.toString());
		

	}

}
