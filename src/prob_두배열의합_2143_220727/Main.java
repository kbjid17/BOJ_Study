package prob_두배열의합_2143_220727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
		int a_size = n*(n+1)/2; // if(n == 5) => 5 + 4 + 3 + 2 + 1 등차수열의 합 == n*(n+1)/2
		int b_size = m*(m+1)/2;
		sum_a = new long[a_size]; // ar_a의 누적합 배열
		sum_b = new long[b_size]; // ar_b의 누적합 배열
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
//		System.out.println(Arrays.toString(sum_a));
//		System.out.println(Arrays.toString(sum_b));
		Arrays.sort(sum_a); // ar_a =[1,2,3,4,5] ==> sum_a = {1,3,6,10,15,2,5,9,14,3,7,12}
		Arrays.sort(sum_b);
//		System.out.println(Arrays.toString(sum_a));
//		System.out.println(Arrays.toString(sum_b));
		// 목푯값 : T(sum_a[a][b] + sum_b[c][d] == T)
		// 두 누적합 배열은 이미 정렬되어 있다.
		for (int i = 0; i < a_size; i++) {
			long val = sum_a[i];
//			System.out.println("val = " + val + ", idx = " + i);
//			System.out.println(upper_bound(sum_a,val) + " " + lower_bound(sum_a,val));
//			System.out.println(upper_bound(sum_b,T-val) + " " + lower_bound(sum_b,T-val));
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