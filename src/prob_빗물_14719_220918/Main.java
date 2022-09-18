package prob_빗물_14719_220918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] ar;
	static long ans;
	static int H,W;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		
		ar = new int[H+1][W+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= W; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = H; j > H-n; j--) {
				ar[j][i] = 1;
			}
		}
		
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <= W; j++) {
//				System.out.print(ar[i][j]);
//			}
//			System.out.println();
//		}
//		
		// 체크 프로세스
//		for (int i = 1; i <= W; i++) {
//			for (int j = H; j >= 1; j--) {
//				if(ar[j][i] == 0) {
//					System.out.println(j + " " + i +  " 체크");
//					check(i,j);
//				}
//			}
//		}
		
		for (int i = H; i >= 1; i--) {
			for (int j = 1; j <= W; j++) {
				if(ar[i][j] == 0) {
//					System.out.println(i + " " + j +  " 체크");
					check(i,j);
				}
			}
		}
		
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <= W; j++) {
//				System.out.print(ar[i][j]);
//			}
//			System.out.println();
//		}
		
		for (int i = H; i >= 1; i--) {
			for (int j = 1; j <= W; j++) {
				if(ar[i][j] == 0) ans++;
			}
		}
		System.out.println(ans);
		
	}
	static void check(int h,int w) {
		
		for (int i = h; i >= 1; i--) {
			// 1. 왼쪽에 벽이 있는지 체크
			int l_end = w;
			for (int j = l_end; j >= 0; j--) {
				if(ar[i][j] == 1) {
					l_end = j;
					break;
				}
				if(j == 0) {
					l_end = 0;
					break;
				}
			}
			
			// 2. 오른쪽에 벽이 있는지 체크
			int r_end = w;
			for (int j = r_end; j <= w+1; j++) {
				if(ar[i][j] == 1) {
					r_end = j;
					break;
				}
				if(j == w+1) {
					r_end = w+1;
					break;
				}
			}
			
			// 3. 두 체크가 끝난 후, 왼쪽 end가 0이거나, 오른쪽 end가 w+1이면 그 높이에는 물이 쌓일 수 없음. ==> 3으로 처리;
			if(l_end == 0 || r_end == W+1) {
//				System.out.println(i + " " + l_end + " " + r_end + " 물 못채움 " );
				for (int j = l_end; j < r_end; j++) {
					if(ar[i][j] == 0)
					ar[i][j] = 3;
				}
			}
			// 그렇지 않다면 문제 없음 => 2로 채우기
			
			
		}
	}
}
