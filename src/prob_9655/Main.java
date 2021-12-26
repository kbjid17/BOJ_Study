package prob_9655;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N %2 == 0) {
			System.out.println("CY");
		}
		else if(N %2 != 0) {
			System.out.println("SK");
		}
	}
}