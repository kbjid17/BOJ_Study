package prob_2578_빙고;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] ar = new int[5][5];
	static int[][] ar2 = new int[5][5];
	static boolean cross1;
	static boolean cross2;
	static int count;
	static int round = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				ar2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					for (int k2 = 0; k2 < 5; k2++) {
						if(count >= 3) {
							System.out.println(round);
							return;
						}
						if(ar[k][k2] == ar2[i][j]) {
							ar[k][k2] = 0;
							round +=1;
							if(ar[k][0] == 0 && ar[k][1] == 0 && ar[k][2] == 0 && ar[k][3] == 0 && ar[k][4] == 0 ) {
								count++;
							}
							if(ar[0][k2] == 0 && ar[1][k2] == 0 && ar[2][k2] == 0 && ar[3][k2] == 0 && ar[4][k2] == 0 ) {
								count++;
							}
							if(ar[0][0] == 0 && ar[1][1] == 0 && ar[2][2] == 0 && ar[3][3] == 0 && ar[4][4] == 0 && !cross1) {
								cross1 = true;
								count++;
							}
							if(ar[0][4] == 0 && ar[1][3] == 0 && ar[2][2] == 0 && ar[3][1] == 0 && ar[4][0] == 0 && !cross2) {
									cross2 = true;
									count++;
							}
						}
					}
				}
			}
		}
	}
}