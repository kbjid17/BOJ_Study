package prob_가장긴바이토닉부분수열_11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,max = Integer.MIN_VALUE;
	static int[] ar;
	static int[] lis;
	static int[] lds;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		lis = new int[N];
		lds = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		//for문으로 진행
		/*
		 1. lbs[i]는 1로 먼저 초기화
		 1) 0~i-1 까지의 계산 : 평범한 lbs 로 계산
		 2) i~N-1 까지의 계산 : 가장 긴 감소하는 부분수열 
		 */
		for (int i = 0; i < N; i++) {
			lis[i] =1;
			for (int j = 0; j < i; j++) {
				if(ar[j] < ar[i]) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
		}
		for (int i = N-1; i >= 0; i--) {
			lds[i] = 1;
			for (int j = N-1; j >= i; j--) {
				if(ar[j] < ar[i]) {
					lds[i] = Math.max(lds[i], lds[j]+1);
				}
			}
		}
	for (int i = 0; i < N; i++) {
//		System.out.println(i);
//		System.out.println("lis[i] = " + lis[i]);
//		System.out.println("lds[i] = " + lds[i]);
		max = Math.max(max, lis[i] + lds[i]);
//		System.out.println();
	}
	System.out.println(max-1);
	}

}
