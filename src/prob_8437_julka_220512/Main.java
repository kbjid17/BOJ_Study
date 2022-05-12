package prob_8437_julka_220512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger a,b;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = new BigInteger(br.readLine()); // 1번 + 2번
		b = new BigInteger(br.readLine()); // 1번 - 2번
		
		BigInteger c = a.add(b);
		BigInteger d = a.subtract(b);
		
		System.out.println(c.divide(new BigInteger("2")));
		System.out.println(d.divide(new BigInteger("2")));
	}

}
