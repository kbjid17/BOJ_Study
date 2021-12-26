package prob_1246;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,sum,count,price;
	static int max = Integer.MIN_VALUE;
	static int [] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[M];
		for (int i = 0; i < M; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ar);
		for (int i = ar.length-1; i >= 0; i--) {
			if(count < N)
				count++;
			sum = ar[i]*count;
			if(sum > max) {
				price = ar[i];
				max = sum;
			}
		}
		
		System.out.println(price + " " + max);
	}

}
