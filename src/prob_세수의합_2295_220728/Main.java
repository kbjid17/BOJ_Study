package prob_세수의합_2295_220728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static HashSet<Long> map = new HashSet<Long>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long ans = Long.MIN_VALUE;
		long[] ar = new long[T];
		for (int i = 0; i < T; i++) {
			ar[i] = Long.parseLong(br.readLine());
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = i; j < ar.length; j++) {
				if(!map.contains(ar[i] + ar[j])) {
					map.add(ar[i] + ar[j]);
				}
			}
		}
		Arrays.sort(ar);
		for (int k = ar.length-1; k >= 0; k--) {
			for (int c = 0; c < k; c++) {
				if(map.contains(ar[k]-ar[c])) {
					ans = Math.max(ans,ar[k]);
					break;
				}
			}
		}
		System.out.println(ans);
	}
}