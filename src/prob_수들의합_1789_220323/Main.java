package prob_수들의합_1789_220323;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		
		long a = 0;
		
		while(true) {
			sum += a;
			a++;
			if(sum == S) {
				a -=1;
				break;
			}
			else if(sum > S) {
				a -=2;
				break;
			}
		}
		System.out.println(a);
	}

}
