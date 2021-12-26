package prob_체스판다시칠하기_1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,num_1,num_2,min = Integer.MAX_VALUE;
	static char[][] ar,chess;
	public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new char[N][M];
		chess = new char[8][8];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			ar[i] = str.toCharArray();
		}
		for (int a = 0; a < N-7; a++) {
			for (int b = 0; b < M-7; b++) {
//				System.out.println(a + " " + b);
				//체스판 선언
				
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						chess[i][j] = ar[a+i][b+j];
					}
				}
				
//				for (int i = 0; i < 8; i++) {
//					for (int j = 0; j < 8; j++) {
//						System.out.print(chess[i][j]);
//					}
//					System.out.println();
//				}
				
				// 1. 0번 원소가 W인 경우를 가정 
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if(i%2 != 0) {
							switch(j % 2) {
							case 0:
								if(chess[i][j] != 'B') num_1++;
								break;
							case 1:
								if(chess[i][j] != 'W') num_1++;
								break;
							}
						}
						else if(i%2 == 0) { // 0,2,4,6,8
							switch(j % 2) {
							case 0:
								if(chess[i][j] != 'W') num_1++;
								break;
							case 1:
								if(chess[i][j] != 'B') num_1++;
								break;
							}
						}
						
					}
				}
//				System.out.println("num_1 은 : "+num_1 + " ");
				
				// 2. 0번 원소가 B인 경우를 가정
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if(i%2 != 0) {
							switch(j % 2) {
							case 0:
								if(chess[i][j] != 'W') num_2++;
								break;
							case 1:
								if(chess[i][j] != 'B') num_2++;
								break;
							}
						}
						else if(i%2 == 0) {
							switch(j % 2) {
							case 0:
								if(chess[i][j] != 'B') num_2++;
								break;
							case 1:
								if(chess[i][j] != 'W') num_2++;
								break;
							}
						}
						
					}
				}
//				System.out.println("num_2는 : "+num_2);
				
				
				min = Math.min(min,Math.min(num_1, num_2));
				num_1 = 0;
				num_2 = 0;
			}
			
		}
		

		System.out.println(min);
		
	}

}
