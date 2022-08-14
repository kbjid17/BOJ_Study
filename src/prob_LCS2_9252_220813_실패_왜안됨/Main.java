package prob_LCS2_9252_220813_실패_왜안됨;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		char[] c_1 = br.readLine().toCharArray();
		char[] c_2 = br.readLine().toCharArray();
		
		int[][] ar = new int[c_2.length][c_1.length];
		
		
		int y = 0;
		int x = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				if(i == 0) {
					if(c_2[i] == c_1[j]) {
						ar[i][j] = 1;
					}
				}
				else {
					if(j == 0) {
						if(c_2[i] == c_1[j]) ar[i][j] = 1;
					}
					else {
						if(c_2[i] == c_1[j]) {
							for (int k = i-1; k >= 0; k--) {
								for (int l = j-1; l >= 0; l--) {
									if(ar[k][l] != 0) {
										ar[i][j] = ar[k][l]+1;
										if(ans < ar[i][j]) {
											ans = ar[i][j];
											y = i;
											x = j;
										}
										break;
									}
								}
								if(ar[i][j] != 0) break;
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.print(ar[i][j] + " ");
				ans = Math.max(ans, ar[i][j]);
			}
			System.out.println();
		}
		StringBuilder sb = new StringBuilder();
		if(ans == 0) {
			System.out.println(0);
			return;
		}
//		sb.append(c_2[y]);
			for (int i = ar.length-1; i >= 0; i--) {
				for (int j = ar[0].length-1; j >= 0; j--) {
					if(ar[i][j] == ans && ans > 0) {
//						System.out.println("fff"+(ans-1) + " " + c_2[i] + " " + i + " " + j);
//						System.out.println(ans + " " + i + " " + j + c_2[i] + " " + c_1[j]);
						x = j;
						sb.append(c_2[i]);
						ans -=1;
						break;
					}
				}
			}
			sb.reverse();
//			sb.delete(0, 1);
			System.out.println(sb.length());
		System.out.println(sb);
		

	}

}
