package prob_대소문자바꾸기_2744_220708;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ch = br.readLine().toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] >= 'A' && ch[i] <= 'Z') {
				ch[i] += 32;
			}
			else if(ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] -= 32;
			}
			System.out.print(ch[i]);
		}

	}

}
