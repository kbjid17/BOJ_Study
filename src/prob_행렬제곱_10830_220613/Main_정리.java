package prob_행렬제곱_10830_220613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N;
	static long B;
	static int[][] ar;
	static int[][] sub;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		ar = new int[N][N];
		sub = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(i == j) sub[i][j] = 1;
			}
		}
		
		while(B > 1) {
			if(B % 2 == 0) {
				cal(B);
				B /= 2;
			}
			else { // B가 홀수면
				cal_sub();
				B -= 1;
			}
			
		}
		
		
		cal_sub();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sub[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void cal(long even) {
		int[][] new_ar = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = 0;
					for (int k = 0; k < N; k++) {
						new_ar[i][j] = (new_ar[i][j] + (ar[i][k] * ar[k][j])) % 1000;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ar[i][j] = new_ar[i][j];
				}
			}
	}
	
	static void cal_sub() {
		int[][] new_ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = 0;
				for (int k = 0; k < N; k++) {
					new_ar[i][j] = (new_ar[i][j] + (sub[i][k] * ar[k][j]))% 1000;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sub[i][j] = new_ar[i][j];
			}
		}
	}
}
