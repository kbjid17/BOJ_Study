package prob_5의수난_23037_220702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[][] ar = new long[5][6];
	static long sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c = br.readLine().toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			if(c[i]-'0' == 0) continue;
			long num = c[i]-'0';
			sum += (num*num*num*num*num);
		}
		
		System.out.println(sum);
	}

}
