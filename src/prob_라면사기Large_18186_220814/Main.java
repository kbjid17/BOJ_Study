package prob_라면사기Large_18186_220814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long N,B,C; // 라면 공장의 개수 N, 두 자연수 B,C
	static long[] ar = new long[1000004];
	static long ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		if(B < C) C = B;
		
		for (int i = 1; i <= N; i++) {
					if(ar[i+1] > ar[i+2]) {
						long two = Math.min(ar[i], ar[i+1] - ar[i+2]);
						ans += (B+C)*two;
						ar[i] -= two;
						ar[i+1]-=two;
						
						long three = Math.min(ar[i], Math.min(ar[i+1], ar[i+2]));
						ans += (B+C+C)*three;
						ar[i] -= three;
						ar[i+1] -= three;
						ar[i+2] -= three;
					}
					else {
						long three = Math.min(ar[i], Math.min(ar[i+1], ar[i+2]));
						ans += (B+C+C)*three;
						ar[i] -= three;
						ar[i+1] -= three;
						ar[i+2] -= three;
						
						long two = Math.min(ar[i], ar[i+1]);
						ans += (B+C)*two;
						ar[i]-=two;
						ar[i+1] -= two;
					}
					ans += B*ar[i];
				}
		System.out.println(ans);
	}

}
