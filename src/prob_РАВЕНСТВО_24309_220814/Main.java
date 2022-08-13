package prob_РАВЕНСТВО_24309_220814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger a = new BigInteger(br.readLine());
		BigInteger b = new BigInteger(br.readLine());
		BigInteger c = new BigInteger(br.readLine());
		BigInteger d = b.subtract(c);
		BigInteger e = d.divide(a);
		System.out.println(e);
	}

}
