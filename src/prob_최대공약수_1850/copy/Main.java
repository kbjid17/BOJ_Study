package prob_최대공약수_1850.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long N,M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		//1. 최대공약수
//		System.out.println(최대공약수(N,M));
//		System.out.println(num(최대공약수(N,M)));
		for (int i = 0; i < 최대공약수(N,M); i++) {
			sb.append("1");
		}
		System.out.println(sb);
	}
//	static long num(long a) {
//		long number = 0;
//		while(a > 0) { 
//			number += Math.pow(10, a-1);
//			a--;
//		}
//		return number;
//	}
	static long 최대공약수(long a,long b) {
		while(b > 0) {
			long temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}
