package prob_문자와문자열_27866_230309;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(br.readLine().charAt(Integer.parseInt(br.readLine())-1));
	}

}
