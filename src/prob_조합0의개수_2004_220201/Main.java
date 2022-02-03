package prob_조합0의개수_2004_220201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long n,m,num;
	static long a_2,b_2,c_2;
	static long a_5,b_5,c_5;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		long num_2 = 2;
		long num_5 = 5;
		
		while(num_2 <= n) {
			if(num_2 <= n) {
				a_2 += n/num_2;
			}
			if(num_2 <= m) {
				b_2+= m/num_2;
			}
			if(num_2 <= n-m) {
				c_2 += (n-m)/num_2;
			}
			num_2 *= 2;
		}
		while(num_5 <= n) {
			if(num_5 <= n) {
				a_5+= n/num_5;
			}
			if(num_5 <= m) {
				b_5+= m/num_5;
			}
			if(num_5 <= n-m) {
				c_5+= (n-m)/num_5;
			}
			num_5 *= 5;
		}
		
		
		System.out.println(Math.min(a_5-b_5-c_5, a_2-b_2-c_2));
//		long ncm = 2;
		//5 25 125 625 3125 15625 78125 390625 1953125 9765625 48828125 244140625 1220703125
	}

}
