package prob_링_3036_220119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		ar[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			System.out.println(ar[0]/gcd(ar[0],ar[i])+"/"+ar[i]/gcd(ar[0],ar[i]));
		}
	}
	static long gcd(long a, long b) {
		while(b > 0) {
			long temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}
