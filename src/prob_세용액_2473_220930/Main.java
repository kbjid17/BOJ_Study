package prob_세용액_2473_220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar =new long[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(ar);


		if(ar.length == 3) {
			System.out.println(ar[0] + " " + ar[1] + " " + ar[2]);
		}
		else {
			long ar_min = ar[0];
			long ar_mid = ar[(N-1)/2];
			long ar_max = ar[N-1];
			long ans = ar_min + ar_mid  + ar_max;
			for (int i = 1; i < N-1; i++) {
//				System.out.println("mid 값은 "+ ar[i]);
				int min = 0;
				int max = N-1;
				int mid = i;
				
				if(ans == 0) {
					System.out.println(ar[min] + " " + ar[mid] + " " + ar[max]);
					return;
				}
				while(min <= mid &&  max >= mid && min <= max) {
					long sum_thr = ar[min] + ar[mid] + ar[max];
					if(sum_thr == 0) {
						System.out.println(ar[min] + " " + ar[mid] + " " + ar[max]);
						return;
					}
					if(Math.abs(sum_thr) < Math.abs(ans)) {
						ans = sum_thr;
						ar_min = ar[min];
						ar_mid = ar[mid];
						ar_max = ar[max];
//						System.out.println("갱신 " + ar[min] + " " + ar[mid] + " "  + ar[max]);
					}
					if(sum_thr < 0) {
						if(min+1 == mid) {
							max-=1;
//							System.out.println("max 감소 : " + ar[min] + " " + ar[mid] + " "  + ar[max]);
						}
						else {							
							min++;
//							System.out.println("min 추가 : "  + ar[min] + " " + ar[mid] + " "  + ar[max]);
						}
					}
					else if(sum_thr > 0) {
						if(max-1 == mid) {
							min+=1;
						}
						else {							
							max--;
//							System.out.println("max : "  + ar[max]);
						}
					}
				}
				
			}
			System.out.println(ar_min + " " + ar_mid + " " + ar_max);
		}
		
	}

}
