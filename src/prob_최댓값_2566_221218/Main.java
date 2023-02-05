package prob_최댓값_2566_221218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int y = 0, x = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] ar = new int[10][10];
		
		for (int i = 1; i <= 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(max < ar[i][j] ) {
					y = i;
					x = j;
					max = ar[i][j];
				}
				
			}
		}
		
		System.out.println(ar[y][x]);
		System.out.println(y + " " + x);
	}

}
