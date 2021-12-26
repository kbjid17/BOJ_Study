package prob_나무자르기_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long M,start,mid,end,sum;
	static long[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		ar = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Long.parseLong(st.nextToken());
			end = Math.max(end, ar[i]);
		}
		while(start < end) {
			sum = 0;
			mid = (start+end)/2;
//			System.out.println(start + " " + end);
			for (int i = 0; i < N; i++) {
				sum += (ar[i]-mid);
				if(ar[i]-mid < 0) {
					sum -= (ar[i]-mid);
				}
			}
			if(sum >= M) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		System.out.println(start-1);
	}

}
