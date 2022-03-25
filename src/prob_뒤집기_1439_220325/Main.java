package prob_뒤집기_1439_220325;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String[] a;
	static int one,zero;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] b = new int[1000000];
		a = br.readLine().split("");
		
		for (int i = 0; i < a.length; i++) {
			if(i == 0) {
				if(a[i].equals("1")) {
					one++;
				}
				else {
					zero++;
				}
			}else {
				if(!a[i-1].equals(a[i])) {
					calc(a[i]);
				}
			}
		}
		System.out.println(Math.min(one,zero));
	}
	
	static void calc(String b) {
		if(b.equals("1")) {
			one++;
		}else if(b.equals("0")) {
			zero++;
		}
	}
}
