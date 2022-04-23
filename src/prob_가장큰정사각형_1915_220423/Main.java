package prob_가장큰정사각형_1915_220423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static char[][] ar;
	static boolean[][] visit;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
				ar[i] = br.readLine().toCharArray();
			}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == '1' && !visit[i][j]) {
//					System.out.println(i + " " + j);
					check(i,j);
				}
			}
		}
		System.out.println(ans*ans);
		
	}

	static void check(int i, int j) {
		int a = i; // y 초기값
		int b = j; // x 초기값
		int s = 0;
		while(true) {
			s++;
			if(a+s >= N || b+s >= M) return;
			else {
				for (int k = a; k < a+s; k++) {
					if(ar[k][b+s] == '0') {
						ans = Math.max(ans, s);
//						checkvisit(i,j,s);
						return;
					}
				}
				for (int k = b+s; k >= b; k--) {
					if(ar[a+s][k] == '0') {
						ans = Math.max(ans, s);
//						checkvisit(i,j,s);
						return;
					}
				}
			}
		}
	}
	
	static void checkvisit(int i,int j, int s) {
		for (int k = i; k < i+s; k++) {
			for (int d = j; d < j+s; d++) {
				visit[k][d] = true;
			}
		}
	}
}
