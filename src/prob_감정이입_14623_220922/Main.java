package prob_감정이입_14623_220922;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();

		long c = Integer.parseInt(a,2);
		long d = Integer.parseInt(b,2);
		long e = c*d;
		System.out.println(Long.toBinaryString(e));
	}

}
