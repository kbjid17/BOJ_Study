package prob_수학은체육과목입니다2_17362_220923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		while(a > 8) {
			a-=8;
		}
		if(a == 1) {
			System.out.println(1);
		}
		else if(a == 2 || a == 8) {
			System.out.println(2);
		}
		else if(a == 3 || a == 7) {
			System.out.println(3);
		}
		else if(a == 4 || a == 6) {
			System.out.println(4);
		}
		else if(a == 5) {
			System.out.println(5);
		}
		
		

	}

}
