package prob_세로읽기_10798_230226;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		ar = new char[5][];
		int max = 0;
		for (int i = 0; i < 5; i++) {
			ar[i] = br.readLine().toCharArray();
			max = Math.max(max, ar[i].length);
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if(ar[j].length-1 < i) continue;
				sb.append(ar[j][i]);
			}
		}
		System.out.println(sb);
	}

}
