package prob_용액합성하기_14921_221002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar =new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);

		if(ar.length == 2) {
			System.out.println(ar[0] + ar[1]);
		}
		else {
			int ar_min = ar[0];
			int ar_max = ar[N-1];
			int min = 0;
			int max = N-1;
			int ans = ar[min] + ar[max];
			while(min < max) {
				int sum = ar[min] + ar[max];
				if(sum == 0) {
					System.out.println(ar[min] + ar[max]);
					return;
				}
				if(Math.abs(sum) < Math.abs(ans)) {
					ans = ar[min] + ar[max];
					ar_min = ar[min];
					ar_max = ar[max];
				}
				if( sum	 < 0) {
					min++;
				}
				else if( sum > 0) {
					max--;
				}
			}
			
			System.out.println(ar_min + ar_max);
		}
	}

}