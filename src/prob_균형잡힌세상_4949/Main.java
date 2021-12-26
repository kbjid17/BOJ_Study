package prob_균형잡힌세상_4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				return;
			}
			char[] ar = str.toCharArray();
			boolean a = true;
			boolean b = true;
			for (int i = 0; i < ar.length; i++) {
				if(ar[i] == '(') {
					a = false;
					for (int j = i; j < ar.length; j++) {
						if(ar[j] == ']') break;
						if(ar[j] == ')') {
							a = true;
							break;
						}
					}
				} else if(ar[i] == '[') {
					b = false;
					for (int j = i; j < ar.length; j++) {
						if(ar[j] == ')') break;
						if(ar[j] == ']') {
							b = true;
							break;
						}
					}
				}
			} 
			if(a && b) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
