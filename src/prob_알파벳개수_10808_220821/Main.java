package prob_알파벳개수_10808_220821;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] alp = new int[26];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c = br.readLine().toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			alp[c[i]-'a']++;
		}
		sb.append(alp[0]);
		for (int i = 1; i < alp.length; i++) {
			sb.append(" ").append(alp[i]);
		}
		System.out.println(sb.toString());
	}

}
