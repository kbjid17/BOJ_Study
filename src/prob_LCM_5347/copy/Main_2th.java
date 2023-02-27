package prob_LCM_5347.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2th {
	static int T,N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//2. 최소공배수
			BigInteger a = new BigInteger(Integer.toString(N));
			BigInteger b = new BigInteger(Integer.toString(M));
			BigInteger c = new BigInteger(Integer.toString(gcd(N,M)));
//			long lcm = N*M/gcd(N,M);
			BigInteger lcm = a.multiply(b).divide(c);
			System.out.println(lcm);
		}
		
	}
	static int gcd(int a,int b) {
		while(b > 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}
