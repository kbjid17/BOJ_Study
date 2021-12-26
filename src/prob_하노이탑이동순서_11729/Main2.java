package prob_하노이탑이동순서_11729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main2 {

	static int K,a,b,c;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		BigInteger a = new BigInteger("2");
		BigInteger c = BigInteger.ONE;
		BigInteger b = a.pow(K).subtract(c);
		if(K <= 20) {
			System.out.println(b);
			hanoi(K,1,3,2);
		}
		else {
			System.out.println(b);
		}
	}
		static void hanoi (int k,int from,int to,int mid) {
			if(k == 1) {
				System.out.println(from + " " + to);
				return;
			} else {
				hanoi(k-1,from,mid,to);
				
				System.out.println(from + " " + to);
				
				hanoi(k-1,mid,to,from);
			}
		}
}
