package prob_바구니순서바꾸기_10812_230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] ar = new int[N+1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i;
		}
		for (int t = 0; t < M; t++) {
			
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] temp = new int[j-i+2];
			
			int mid_end = j-k+1;
			int start_mid = k-i;
			
			for (int l = 1; l <= mid_end; l++) {
				temp[l] = ar[k-1+l];
			}
//			System.out.println(Arrays.toString(temp));
			for (int l = mid_end+1; l <= mid_end+start_mid; l++) {
				temp[l] = ar[l-mid_end-1+i];
			}
//			System.out.println(Arrays.toString(temp));
			for (int l = 1; l < temp.length; l++) {
//				System.out.println(temp.length);
				ar[i+l-1] = temp[l];
			}
//			System.out.println(Arrays.toString(ar));
		}

		for (int i = 1; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}

}
