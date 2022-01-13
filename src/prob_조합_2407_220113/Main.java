package prob_조합_2407_220113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int a = 1,b = 1,c,d;
	static BigInteger ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ans = new BigInteger("1");
		for (int i = 1; i <= m; i++) {
			a = n-i+1;
			b = i;
			String c = Integer.toString(a);
			String d = Integer.toString(b);
			BigInteger num3 = ans.multiply(new BigInteger(c));
			BigInteger num4 = num3.divide(new BigInteger(d));
			ans = num4;
//			System.out.println(ans);
		}
		System.out.println(ans);
	}
}
