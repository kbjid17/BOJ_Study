package prob_빗물_14719_220918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	static int[][] ar;
	static long ans;
	static int H,W;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		ar = new int[H+1][W+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= W; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = H; j > H-n; j--) {
				ar[j][i] = 1;
			}
		}
		
		for (int i = H; i >= 1; i--) {
			for (int j = 1; j <= W; j++) {
				if(ar[i][j] == 0) {
					check(i,j);
				}
			}
		}
		
		for (int i = H; i >= 1; i--) {
			for (int j = 1; j <= W; j++) {
				if(ar[i][j] == 0) ans++;
			}
		}
		System.out.println(ans);
		
	}
	static void check(int h,int w) {
		
		for (int i = h; i >= 1; i--) {
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
			
			if(l_end == 0 || r_end == W+1) {
				for (int j = l_end; j < r_end; j++) {
					if(ar[i][j] == 0)
					ar[i][j] = 3;
				}
			}
		}
	}
}
