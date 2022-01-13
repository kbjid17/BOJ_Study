package prob_숫자카드_10815_220110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ar;
	static int[] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		M = Integer.parseInt(br.readLine());
		ans = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N-1;
			if(ar[start] == a || ar[end] == a) {
				ans[i]++;
			}
			while(start <= end && ans[i] == 0) {
				if(ar[start] == a || ar[end] == a) {
					ans[i]++;
					break;
				}
				int mid = (start + end)/2;
				
				if(ar[mid]== a) {
					ans[i]++;
					break;
				}
				else if(ar[mid] > a) {
					end = mid-1;
				}
				else if(ar[mid] < a) {
					start = mid+1;
				}
				
				
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
