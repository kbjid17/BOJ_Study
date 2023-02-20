package prob_팰린드롬인지확인하기_10988_230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int ans = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ar = br.readLine().toCharArray();

		int n = ar.length/2;
		
		for (int i = 0; i < n; i++) {
			if(ar[i] != ar[ar.length-1-i]) {
				ans = 0;
				break;
			}
		}
		System.out.println(ans);
	}

}
