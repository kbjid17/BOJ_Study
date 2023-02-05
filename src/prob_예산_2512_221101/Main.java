package prob_예산_2512_221101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		long ans = Long.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		long M = Integer.parseInt(br.readLine());
		long start = 0;
		long end = ar[n-1];
		while(start <= end) {
			long mid = (start+end)/2;
			long val = 0;
			for (int i = 0; i < ar.length; i++) {
				if(ar[i] < mid) {
					val += ar[i];	
				}
				else {
					val += mid;
				}
			}
				if(val > M) {
					end = mid-1;
				}
				else {
						if(mid > ans) ans = mid;
						start = mid+1;
				}
		}
		System.out.println(ans);
		
	}

}
