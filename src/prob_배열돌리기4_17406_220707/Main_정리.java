package prob_배열돌리기4_17406_220707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,M,K,ans = Integer.MAX_VALUE;
	static boolean[] selected;
	static int[][] input,ar,tgt,copy_ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[K][3];
		tgt = new int[K][3];
		selected = new boolean[K];
		ar = new int[N+1][M+1];
		copy_ar = new int[N+1][M+1];
		
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		System.out.println(ans);
	}
	
	static void perm(int tgtIdx) {
		if(tgtIdx == K) {	
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					copy_ar[i][j] = ar[i][j];
				}
			}
			for (int i = 0; i < tgt.length; i++) {
				rotate(tgt[i][0],tgt[i][1],tgt[i][2]);
			}
			
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				for (int j = 1; j <= M; j++) {
					cnt += copy_ar[i][j];
				}
				ans = Math.min(cnt, ans);
			}
			return;
		}
		
		for (int i = 0; i < input.length; i++) {
			if(selected[i]) continue;
			
			tgt[tgtIdx][0] = input[i][0];
			tgt[tgtIdx][1] = input[i][1];
			tgt[tgtIdx][2] = input[i][2];
			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}
	}
	
	static void rotate(int r,int c,int s) {
		for (int i = s; i >= 1; i--) {
			int[] ar_1 = new int[(2*i)+1];
			int[] ar_2 = new int[2*i];
			int[] ar_3 = new int[2*i];
			int[] ar_4 = new int[2*i-1];
			for (int j = 0; j < ar_1.length; j++) {
				ar_1[j] = copy_ar[r-i][c-i+j];
			}
			
			for (int j = 0; j < ar_2.length; j++) {
				ar_2[j] = copy_ar[r-i+1+j][c+i];
			}
			for (int j = 0; j < ar_3.length; j++) {
				ar_3[ar_3.length-1-j] = copy_ar[r+i][c-i+j];
			}
			
			for (int j = 0; j < ar_4.length; j++) {
				ar_4[ar_4.length-1-j] = copy_ar[r-i+1+j][c-i];
			}
			for (int j = 0; j < ar_1.length-1; j++) {
				copy_ar[r-i][c-i+j+1] = ar_1[j];
			}
			copy_ar[r-i+1][c+i] = ar_1[ar_1.length-1];

			for (int j = 0; j < ar_2.length-1; j++) {
				copy_ar[r-i+j+2][c+i] = ar_2[j];
			}
			copy_ar[r+i][c+i-1] = ar_2[ar_2.length-1];
			
			for (int j = 0; j < ar_3.length-1; j++) {
				copy_ar[r+i][c+i-j-2] = ar_3[j];
			}
			copy_ar[r+i-1][c-i] = ar_3[ar_3.length-1];
			
			for (int j = 0; j < ar_4.length; j++) {
				copy_ar[r+i-j-2][c-i] = ar_4[j];
			}
		}
	}
}