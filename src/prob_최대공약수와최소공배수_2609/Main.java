package prob_최대공약수와최소공배수_2609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//1. 최대공약수
		System.out.println(최대공약수(N,M));
		//2. 최소공배수
		System.out.println(최대공약수(N,M) * N/최대공약수(N,M) * M/최대공약수(N,M));
	}
	static int 최대공약수(int a,int b) {
		while(b > 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}
