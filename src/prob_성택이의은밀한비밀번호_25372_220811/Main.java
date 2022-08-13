package prob_성택이의은밀한비밀번호_25372_220811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			System.out.println(str.length() >= 6 && str.length() <= 9 ? "yes" : "no");
		}
	}
}
