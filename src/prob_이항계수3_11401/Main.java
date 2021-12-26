package prob_이항계수3_11401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long N,K;
	static final long MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long top = fac(N);
		long bottom = fac(K)*fac(N-K) % MOD;
		System.out.println(top*pow(bottom,MOD-2) % MOD);
	}
	static long fac(long n) {
		long a = 1L;
		while(n > 1)
			{
				a = a*n % MOD;
				n--;
			}
		return a % MOD;
	}
	
	static long pow(long a,long b) {
		long num = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				num *= a;
				num %= MOD;
			}
			a = a*a % MOD;
			b /=2;
		}
		return num;
	}
}