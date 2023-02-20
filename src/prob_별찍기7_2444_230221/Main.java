package prob_별찍기7_2444_230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int t = -1;
		for (int i = 1; i <= n; i++) {
			t +=2;
			
			for (int j = 1; j < n-i+1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < t; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < n; i++) {
			t -=2;
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < t; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
