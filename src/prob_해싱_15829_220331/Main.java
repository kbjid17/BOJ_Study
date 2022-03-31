package prob_해싱_15829_220331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger sum = new BigInteger("0");
	static BigInteger m,n;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new BigInteger("1234567891");
		int a = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		
		
		for (int i = 0; i < c.length; i++) {
			String str = Long.toString((c[i]-'0')-48);
			n = new BigInteger(str);
			for (int j = 0; j < i; j++) {
				n = n.multiply(new BigInteger("31"));
			}
			
			sum = sum.add(n);
//			System.out.println(sum);
		}
		System.out.println(sum.mod(m));
	}

}
