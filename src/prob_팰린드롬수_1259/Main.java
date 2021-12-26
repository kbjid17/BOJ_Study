package prob_팰린드롬수_1259;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			boolean flag = true;
			String s = br.readLine();
			if(s.equals("0")) return;
			String[] str = s.split("");
			for (int i = 0; i < str.length/2; i++) {
				if(!str[i].equals(str[str.length-1-i])) {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "yes" : "no");
		}

	}

}
