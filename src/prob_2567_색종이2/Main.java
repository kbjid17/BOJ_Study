package prob_2567_색종이2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] ar = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j < a+10; j++) {
				for (int j2 = b; j2 < b+10; j2++) {
					ar[j][j2] = 1;
				}
			}
		}
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if(ar[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						if(i+dy[k] >= 0 && i+dy[k] <= 100 && j+dx[k] >= 0 && j + dx[k] <= 100) {
							if(ar[i+dy[k]][j+dx[k]] == 0)
								cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
