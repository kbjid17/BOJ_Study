package prob_마인크래프트_18111_220410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	static int n,m,b;
	static int answer = Integer.MAX_VALUE , height = Integer.MAX_VALUE;
	static int[][] ar;
	static double avg;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		ar = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				
			} 
		}
		for (int i = 0; i <= 256; i++) cal(i);
		System.out.println(answer + " " + height);
	}

	static void cal(int val) {
		int cb = b;
		int v = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(ar[i][j] > val) {
					cb += ar[i][j] -val;
					v += 2*(ar[i][j] - val);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(ar[i][j] < val) {
					if(val - ar[i][j] > cb) {
						return;
					}
					cb -= (val-ar[i][j]);
					v += (val-ar[i][j]);
				}
			}
		}
		if(v <= answer) {
			if(v == answer && val <= height) return;
			answer = v;
			height = val;
		}
	}
}
