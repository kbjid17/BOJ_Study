package prob_LCS_9251_220105;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int ans = Integer.MIN_VALUE;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch1 = br.readLine().toCharArray();
		char[] ch2 = br.readLine().toCharArray();
		
		ar = new int[ch1.length+1][ch2.length+1];
		
		for (int i = 1; i <= ch1.length; i++) {
			for (int j = 1; j <= ch2.length; j++) {
				if(ch1[i-1] == ch2[j-1]) {
					ar[i][j] = ar[i-1][j-1]+1;
				}
				else {
					ar[i][j] = Math.max(ar[i][j-1], ar[i-1][j]);
				}
				ans = Math.max(ans, ar[i][j]);
			}
		}
		System.out.println(ans);
	}

}
