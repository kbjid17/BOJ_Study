package prob_세금_20492_220425;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(br.readLine());
		System.out.println((int)(a * 0.78) + " " + (int)(a - (a*0.2*0.22)));
	}

}
