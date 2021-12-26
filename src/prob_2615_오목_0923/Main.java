package prob_2615_오목_0923;

import java.util.Scanner;

public class Main {

	static int win,winx,winy;
	static int[][] ar = new int[19][19];
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		// 구현하세요.

		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		omok();
		
		System.out.println(win);
		System.out.println((winy) + " " + (winx));
		
		
		
		
		
	}
	static void omok() {
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j <19; j++) {
					if(ar[i][j] == 1) { //흑돌
//						System.out.println(ar[i][j]);
					if(j+4 < 19 && ar[i][j+1] + ar[i][j+2]+ 
							ar[i][j+3]+ ar[i][j+4] ==5) {
						win = 1;
						winx = j;
						winy = i;
						return;
					}
					else if(i+4 < 19 && j+4 < 19 && ar[i+1][j+1] + ar[i+2][j+2]+ 
							ar[i+3][j+3]+ ar[i+4][j+4] ==5) {
						win = 1;
						winx = j;
						winy = i;
						return;
						
					}
					else if(i-4 >=0 && j+4 < 19 && (ar[i-1][j+1] + ar[i-2][j+2]+ 
							ar[i-3][j+3]+ ar[i-4][j+4] ==5) ) {
						win = 1;
						winx = j;
						winy = i;
						return;
						
					}
					else if(i+4 < 19 && ar[i+1][j] + ar[i+2][j]+ 
							ar[i+3][j]+ ar[i+4][j] ==5) {
						win = 1;
						winx = j;
						winy = i;
						return;
						
					}
				}
				else if(ar[i][j] == 2) { // 백돌
//					System.out.println(ar[i][j]);
					if(j+4 < 19 && ar[i][j+1] + ar[i][j+2]+ 
							ar[i][j+3]+ ar[i][j+4] ==10) {
						win = 2;
						winx = j;
						winy = i;
						return;
						
					}
					else if(i+4 < 19 && j+4 < 19 && ar[i+1][j+1] + ar[i+2][j+2]+ 
							ar[i+3][j+3]+ ar[i+4][j+4] ==10) {
						win = 2;
						winx = j;
						winy = i;
						return;
						
					}
					else if(i-4 >= 0 && j+4 < 19 && (ar[i-1][j+1] + ar[i-2][j+2]+ 
							ar[i-3][j+3]+ ar[i-4][j+4] ==10)) {
						win = 2;
						winx = j;
						winy = i;
						return;	
					}
					else if(i+4 < 19 && ar[i+1][j] + ar[i+2][j]+ 
							ar[i+3][j]+ ar[i+4][j] ==10) {
						win = 2;
						winx = j;
						winy = i;
						return;	
					}
				}
			}
		}
	}
}
