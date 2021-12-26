package prob_GCD합_9613.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,N;
	static long sum;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ar = new int[N];
			for (int i = 0; i < N; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					sum+= 최대공약수(ar[i],ar[j]);
				}
			}
			System.out.println(sum);
		}
		
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
