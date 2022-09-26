package prob_자동완성_24883_220926;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder("Naver ");
		
		String s = br.readLine();
		if(s.equals("n") || s.equals("N")) {
			sb.append("D2");
		}
		else {
			sb.append("Whale");
		}
		
		System.out.println(sb);

	}

}
