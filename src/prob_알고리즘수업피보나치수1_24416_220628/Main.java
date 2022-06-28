package prob_알고리즘수업피보나치수1_24416_220628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int cnt_1 = 1,cnt_2 = 0;
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		fib(n);
		
		
		System.out.println(cnt_1 + " " + fibonacci(n));
	}
	static int fib(int n) {
//		cnt_1++;
		if(n == 1 || n == 2) return 1;
		else {
			cnt_1++;
			return (fib(n-1) + fib(n-2));
		}
	}
	
	static int fibonacci(int n) {
		if(n <= 2) return 0;
		else {
			ar = new int[n+1];
			ar[1] = 1;
			ar[2] = 1;
			for(int i = 3; i <= n; i++) {
				cnt_2++;
				ar[i] += (ar[i-1] + ar[i-2]);
			}
			
			return cnt_2;
		}
	}
	

}
