package prob_삼각형외우기_10101_220830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		if(a+b+c == 180) {
			if(a == b && b == c) {
				System.out.println("Equilateral");
			}
			else if((a == b && b != c) || (a == c && c != b) || (b == c && c != a)) {
				System.out.println("Isosceles");
			}
			else if(a != b && a != c && b != c) {
				System.out.println("Scalene");
			}
		}
		else {
			System.out.println("Error");
		}
	}

}
