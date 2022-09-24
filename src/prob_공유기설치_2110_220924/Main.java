package prob_공유기설치_2110_220924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ar);
		int start = 1;
		int end = ar[n-1] - ar[0];
		
		while(start <= end) {
			int mid = (start + end) /2;
//			System.out.println(mid);
			
			if(calc(mid) < c) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(end);
	}
	
	static int calc(int distance) {
		int home = ar[0];
		int cnt = 1;
		for (int i = 1; i < ar.length; i++) {
			if(ar[i]-home >= distance) {
				home = ar[i];
				cnt++;
			}
		}
		return cnt;
	}
}
