package prob_팰린드롬만들기_1213_220626;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_정리 {
	static int[] alp = new int[26];
	static String wrong = "I'm Sorry Hansoo";
	static char[] str, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine().toCharArray();
		ans = new char[str.length];
		Arrays.sort(str);
		int len = str.length;
		int even = 0; 
		int odd = 0;
		for (int i = 0; i < str.length; i++) {
			alp[str[i]-'A']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if(alp[i] > 0) {
				if(alp[i] % 2 == 0) even++;
				else odd++;
			}
		}
		
		if(len %2 == 0) { 
			if(odd > 0) { 
				System.out.println(wrong);
				return;
			}
			
		}
		else { 
			if(odd > 1) { 
				System.out.println(wrong);
				return;
			}
			for (int i = 0; i < 26; i++) {
				if(alp[i] %2 != 0) {
					char temp = '.';
					 for (int j = 0; j < str.length; j++) {
						if(str[j]-'A' == i && temp == '.') {
							temp = str[j];
							continue;
						}
						if(temp != '.') {
							str[j-1] = str[j];
						}
					}
					str[str.length-1] = temp;
					break;
				}
			}
		}
		
		int idx = 0;
		for (int i = 0; i < str.length; i++) {
			if(i %2 == 0) {
				ans[idx] = str[i];
			}
			else {
				ans[str.length-1-idx] = str[i];
			}
			
			if(i != 0 && i % 2 != 0) {
				idx++;
			}
		}
		System.out.println(ans);
	}
}