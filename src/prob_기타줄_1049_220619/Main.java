package prob_기타줄_1049_220619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans = Integer.MAX_VALUE, min_value = Integer.MAX_VALUE; // 답(최소 개수), 최소 가격
//	static int pk_min = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[2][M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				ar[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(ar[0]); // 패키지 가격 정렬
		Arrays.sort(ar[1]); // 낱개 가격 정렬
		
		if(N < 6) {
			System.out.println(Math.min(ar[0][0], ar[1][0] * N));
		}
		else {
			int cnt = -1;
			while(cnt*6 < N) {
				
				cnt++;
				int val = ar[0][0]*cnt;
				if(cnt*6 < N)	val+= ar[1][0]*(N-6*cnt);
				
				min_value = Math.min(min_value, val);
			}
			System.out.println(min_value);
		}
	}
}
