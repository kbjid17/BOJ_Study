package prob_2의보수_24389_220919;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
//		int[] ar_a = new int[32];
//		int[] ar_b = new int[32];
		
		int a = Integer.parseInt(br.readLine());
		int b = ~a +1;
		
		char[] a_str = toBinaryString(a).toCharArray();
		char[] b_str = toBinaryString(b).toCharArray();
		
//		System.out.println(toBinaryString(a));
//		System.out.println(toBinaryString(b));
		
		for (int i = 0; i < a_str.length; i++) {
			if(a_str[i] != b_str[i]) ans++;
		}
		System.out.println(ans);

	}
	
	static String toBinaryString(int a) {
		String str = Integer.toBinaryString(a);
		while(str.length() < 32) {
			str = "0" + str;
		}
		
		return str;
		
	}
 
}
