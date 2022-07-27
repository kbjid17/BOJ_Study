package prob_두배열의합_2143_220727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정리 {
	static int T,n,m;
	static int[] ar_a,ar_b;
	static long[] sum_a,sum_b;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		ar_a = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			ar_a[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		ar_b = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			ar_b[i]  = Integer.parseInt(st.nextToken());
		}
		int a_size = n*(n+1)/2;
		int b_size = m*(m+1)/2;
		sum_a = new long[a_size];
		sum_b = new long[b_size];
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			long sum = 0;
			for (int j = i; j <= n; j++) {
				sum += ar_a[j];
				sum_a[idx++] = sum;
			}
		}
		
		idx = 0;
		for (int i = 1; i <= m; i++) {
			long sum = 0;
			for (int j = i; j <= m; j++) {
				sum += ar_b[j];
				sum_b[idx++] = sum;
			}
		}
		Arrays.sort(sum_a);
		Arrays.sort(sum_b);
		for (int i = 0; i < a_size; i++) {
			long val = sum_a[i];
			long aTerm = upper_bound(sum_a,val) - lower_bound(sum_a,val);
			long bTerm = upper_bound(sum_b,T-val) - lower_bound(sum_b,T-val);
			ans += (aTerm*bTerm);
			i += aTerm-1;
		}
		System.out.println(ans);
	}
	
	static int upper_bound(long[] ar,long t) {
		int left = 0, right = ar.length;
		while(left < right) {
			int mid = (left + right) /2;
			
			if(t >= ar[mid]) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		return right;
	}
	static int lower_bound(long[] ar,long t) {
		int left = 0, right = ar.length;
		while(left < right) {
			int mid = (left + right) /2;
			if(t <= ar[mid]) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		return right;
	}
}