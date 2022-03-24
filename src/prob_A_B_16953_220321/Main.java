package prob_A_B_16953_220321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long N,M;
	static long cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		// 그리디로 한번 풀어보자
		while(M > 0) {
			 
			if(M == N) {
				cnt++;
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(M % 2 == 0) {
				M /= 2;
			}
			else if(M % 10 == 1) {
				M /= 10;
			}
			else {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(-1);
		/*
		 a*2를 하거나 (a*10) + 1을 진행 
		 */
	}
}