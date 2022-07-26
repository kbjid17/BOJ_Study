package prob_A와B_12904_220726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		while(sb.toString().length() > a.length()) {
			if(sb.charAt(sb.length()-1) == 'A') {
				sb.delete(sb.length()-1, sb.length());
			}
			else if(sb.charAt(sb.length()-1) == 'B') {
				sb.delete(sb.length()-1, sb.length());
				sb.reverse();

			}
		}
		if(sb.toString().equals(a)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}

}
