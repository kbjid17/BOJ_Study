package prob_공백없는AB_15873_220910;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c = br.readLine().toCharArray();
		String str = "";
		int a = 0;
		int b = c[c.length-1]-'0';
		if(b == 0) {
			String str_b = "";
			for (int i = c.length-2; i < c.length; i++) {
				str_b += c[i];
			}
			b = Integer.parseInt(str_b);
			
			for (int i = 0; i < c.length-2; i++) {
				str += c[i];
			}
			a = Integer.parseInt(str);
		}
		else {
			for (int i = 0; i < c.length-1; i++) {
				str += c[i];
			}
			a = Integer.parseInt(str);
		}
		System.out.println(a+b);
	}

}
