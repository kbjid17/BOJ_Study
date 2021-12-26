package prob_LCM_5347.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//2. 최소공배수
			long 최소공배수 = 최대공약수(N,M) * (N/최대공약수(N,M)) * (M/최대공약수(N,M));
			System.out.println(최소공배수);
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
