package prob_1157;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int maxpoint;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ar = new int[26];
		char[] str = br.readLine().toLowerCase().toCharArray();
		for (int i = 0; i < str.length; i++) {
			ar[str[i]-'a'] +=1;
		}
		
		for (int i = 0; i < ar.length; i++) {
			if(max < ar[i]) {
				max = Math.max(max, ar[i]);
				maxpoint = i;
			}
		}
		for (int i = ar.length-1; i >= 0; i--) {
			if(max == ar[i] && maxpoint != i) {
				System.out.println("?");
				break;
			}
			if(i == 0) {
				System.out.println((char)(maxpoint+'A'));
			}
		}
		
	}
}
