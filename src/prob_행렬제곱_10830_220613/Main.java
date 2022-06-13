package prob_행렬제곱_10830_220613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // N*N 행렬을 B 제곱을 진행
	static long B;
	static int[][] ar; // [N][N] 행렬
	static int[][] sub;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		/* B의 최댓값이 100000000000 => 1000억.
			단순 반복으로 계산을 진행하면 1000억번까지 할 수도 있다.
		*/
		ar = new int[N][N];
		sub = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(i == j) sub[i][j] = 1;
			}
		}
		
 /*
		 0. 기본 배열 ar 말고도, sub 배열을 준비한다.
		 0-1. sub 배열은 빈 배열로 만든다
		 [1 0]
		 [0 1] <- ar을 곱하면 sub 배열 == ar이 될 수 있도록!
		 1. 입력받은 B가 홀수인지 짝수인지 체크
		 1-1. 홀수면 sub 배열에 ar 배열을 곱한다.
		 1-2. 짝수면 2번 과정으로 넘어간다.
		 
		 2. ar * ar을 진행하고, B/2를 한다.
		 3. B가 1이 될때까지 1,2 과정을 반복한다.
		 4. 최종적으로 sub * ar을 해주고, sub 배열을 출력해주면 해결!
 */
		
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
		
		
		// 최종적으로 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sub[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void cal(long even) { // 행렬 제곱을 진행하는 메서드
		int[][] new_ar = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					ar[i][j]에 대한 거듭제곱 진행
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
	
	static void cal_sub() { // sub 배열에 현재 ar 배열을 곱함
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
