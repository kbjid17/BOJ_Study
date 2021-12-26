package prob_3985;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] ar = new int[L+1];
		int size = 0;
		int thinkpeople = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			if(size < a2-a1) {
				thinkpeople = i;
				size = a2-a1;
			}
			for (int j = a1; j <= a2; j++) {
				if(ar[j]  == 0) {
					ar[j] = i;
				}
			}
		}
		int count = 0;
		int max = Integer.MIN_VALUE;
		int realpeople = 0;
		for (int i = 1; i <= N; i++) {
			count = 0;
			for (int j = 1; j <= L; j++) {
				if(ar[j] == i)
					count++;
			}
			if(max < count) {
				realpeople = i;
				max = count;
			}
		}
		System.out.println(thinkpeople);
		System.out.println(realpeople);
	}
}
