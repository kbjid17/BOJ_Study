package prob_수정렬하기2_2751;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int[] ar;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		ar = new int[a];
		for (int i = 0; i < a; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ar);
		for (int i = 0; i < a; i++) {
			sb.append(ar[i]).append("\n");
		}
		System.out.println(sb);
	}
}