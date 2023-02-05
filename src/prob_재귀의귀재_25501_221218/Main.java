package prob_재귀의귀재_25501_221218;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int cnt = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			cnt = 1;
			System.out.println(isPalindrome(br.readLine()) + " " + cnt);
		}
	}

	static int isPalindrome(String str) {
		return recursion(str,0,str.length()-1);
	}
	
	static int recursion(String str, int l, int r) {
		if(l >= r) return 1;
		else if(str.charAt(l) != str.charAt(r)) return 0;
		else {
			cnt++;
			return recursion(str,l+1,r-1);
		}
	}
}
