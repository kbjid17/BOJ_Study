package prob_2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int cnt1,cnt2,cnt3; //cnt1 : 가로 , cnt2 : 세로 , cnt3 : 구역
	static int sum1,sum2,sum3; //sum1 : 가로 , sum2 : 세로 , sum3 : 구역
	static int totalcnt;
	static int[][] ar = new int[9][9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sdoku();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	static void sdoku() {
		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				if(ar[a][b] == 0) {
					//백트래킹 시작
			int y = a;
			int x = b;
		cnt1 = cnt2 = cnt3 = 0;
		sum1 = sum2 = sum3 = 0;
		int areay = y;
		int areax = x;
		
		while(areay % 3 != 0)
			areay -=1;
		while(areax % 3 != 0)
			areax -=1;
		
		// 1) 가로 2) 세로
		for (int i = 0; i < 9; i++) {
			sum1 += ar[y][i];
			if(ar[y][i] != 0)
				cnt1 +=1;
		}
		for (int i = 0; i < 9; i++) {
			sum2 += ar[i][x];
			if(ar[i][x] != 0)
				cnt2 +=1;
		}
		// 3) 구역
		for(int i = areay; i < areay+3; i++) {
			for (int j = areax; j < areax+3; j++) {
				sum3 += ar[i][j];
				if(ar[i][j] != 0)
					cnt3 +=1;
			}
		}
		if(cnt1 ==8) {
//			System.out.println(sum1);
			ar[y][x] = 45-sum1;
			totalcnt +=1;
		}
		else if(cnt2 ==8) {
//			System.out.println(sum2);
			ar[y][x] = 45-sum2;
			totalcnt +=1;
		}
		else if(cnt3 ==8) {
//			System.out.println(sum3);
			ar[y][x] = 45-sum3;
			totalcnt +=1;
					}
		else {
			//셋 다 아닐 경우(이때를 어떻게 해야 하는가..)(백트래킹 포인트!) 1씩 넣어가면서 해보는게 좋을까
			
		}
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(ar[i][j] != 0)
					totalcnt +=1;
			}
		}
		if(totalcnt <81)
			sdoku();
	}
}