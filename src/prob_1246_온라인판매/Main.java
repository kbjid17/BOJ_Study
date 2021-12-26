package prob_1246_온라인판매;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

 	static double[] ar;
 	static double avg;
 	static int sum,point;
	public static void main(String[] args) throws Exception{
		/*
		 1. 평균값을 구함(소숫점 나오도록(double). 반올림을 위함.)
		 2. 반올림 진행
		 3. 배열 정렬 후 끝에서부터 1개씩 앞으로 돌리며 평균보다 크거나 같은 값 중 최솟값을 구함.(ex. 2 4 6 8 10 12 14 16 18 20 의 10개(평균 : 11)
		 4. 중 4개를 구한다면 14 16 18 20 중 11보다 큰 값 중 가장 작은 값(14) 을 계란 가격으로 해서 4개를 판매
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ar = new double[M];
		for(int t = 0; t < M; t++) {
			ar[t] = Integer.parseInt(br.readLine());
			avg+= ar[t];
		}
		avg = Math.round(avg/M);
		Arrays.sort(ar);
		
		if(N > M) {
			for(int i = 0; i < ar.length; i++) {
				if(ar[i] >= avg) { 
					sum += avg;
//					System.out.println("sum1 "+sum);
				}
			}
		}
		else if (N <= M) {
			for(int i = ar.length-N; i < ar.length; i++) {
				if(ar[i] >= avg) {
					avg = ar[i];
					break;
				}
			}
			for(int i = ar.length-N; i < ar.length; i++) {
				sum += avg;
//				System.out.println("sum2 "+sum);
			}
		}
		System.out.println((int)avg + " " + sum);
	}
}