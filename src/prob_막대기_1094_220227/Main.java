package prob_막대기_1094_220227;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,ans,cnt;
	static int a = 64;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		while(N > 0) {
			int b = a;
			while(N < a) {
				a >>= 1;
			}
			b = a;
			N -= b;
			cnt++;
		}
		System.out.println(cnt);
	}

}
