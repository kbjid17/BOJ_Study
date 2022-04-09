package prob_경사로_14890_220409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	
	static int n,m,answer;
	static int[][] ar;
	static boolean[][] rowc;
	static boolean[][] colc;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ar = new int[n][n];
		rowc = new boolean[n][n];
		colc = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			check_col(i);
			check_row(i);
		}
		System.out.println(answer);
	}

	static void check_col(int r) { // 행으로 체크(왼쪽 -> 오른쪽 길)
		for (int i = 1; i < n; i++) {
			if(ar[r][i] > ar[r][i-1]) { 
				if(i < m || ar[r][i] - ar[r][i-1] > 1) return; 
				
				for (int j = i-1; j >= i-m; j--) {
					if(ar[r][j] != ar[r][i-1] || rowc[r][j]) return; 
				}
					for (int j = i-1; j >= i-m; j--) {
						rowc[r][j] = true;
					}
			}
			else if(ar[r][i] < ar[r][i-1]) { 
				if(n-i < m || ar[r][i] - ar[r][i-1] < -1) return; 
				
				for (int j = i; j < i+m; j++) {
					if(ar[r][j] != ar[r][i] || rowc[r][j]) return; 
				}
				for (int j = i; j < i+m; j++) {
					rowc[r][j] = true;
				}
			}
		}
		answer++;
	}
	
	static void check_row(int c) {
		for (int i = 1; i < n; i++) {
			if(ar[i][c] > ar[i-1][c]) {
				if(i < m || ar[i][c] - ar[i-1][c] > 1) return;
				for (int j = i-1; j >= i-m; j--) {
					if(ar[j][c] != ar[i-1][c] || colc[j][c]) return;
				}
				for (int j = i-1; j >= i-m; j--) {
					colc[j][c] = true;
				}
			}
			else if(ar[i][c] < ar[i-1][c]) {
				if(n-i < m || ar[i][c] - ar[i-1][c] < -1) return; 
				for (int j = i; j < i+m; j++) {
					if(ar[j][c] != ar[i][c] || colc[j][c]) return;
				}
				for (int j = i; j < i+m; j++) {
					colc[j][c] = true;
				}
			}
		}
		answer++;
	}
}
