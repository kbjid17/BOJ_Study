package prob_문자열_9086_220709;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			
			System.out.println(str[0] + "" + str[str.length-1]);
		}
		

	}

}
