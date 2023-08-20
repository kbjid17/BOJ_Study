package prob_2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_20230816 {

	static ArrayList<int[]> list = new ArrayList<int[]>();
	static boolean clear;
	static int[][] ar = new int[10][10];
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 1; i <= 9; i++) {
			char[] str = br.readLine().toCharArray();
			
			for (int j = 1; j <= 9; j++) {
				ar[i][j] = str[j-1]-'0';
				if(ar[i][j] == 0) {
					list.add(new int[] {i,j});
				}
			}
		}

			sdoku(list.get(0)[0], list.get(0)[1], 1, 0);
		
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 8; j++) {
				System.out.print(ar[i][j]);
			}
			System.out.println(ar[i][9]);
		}
		
	}
	
	static void sdoku(int y, int x,int num, int count) {
		if(num > 9) {
			ar[y][x] = 0;
			sdoku(list.get(count-1)[0], list.get(count-1)[1], ar[list.get(count-1)[0]][list.get(count-1)[1]]+1,count-1);
			return;
		}
		ar[y][x] = num;
		
		 	// 1. 가로줄 일치
		for (int j = 1; j <= 9; j++) {
			if(j == x) continue;
			if(ar[y][j] == num) {
//				System.out.println(y + " " + j + "에서 "+ num + "을 만남");
				if(num == 9) {
					ar[y][x] = 0;
					sdoku(list.get(count-1)[0], list.get(count-1)[1], ar[list.get(count-1)[0]][list.get(count-1)[1]]+1,count-1);
				}
				else {
					sdoku(y,x,num+1,count);
				}
				return;
			}
		}
		 	// 2. 세로줄 일치
		for (int i = 1; i <= 9; i++) {
			if(i == y) continue;
			if(ar[i][x] == num) {
				
//				System.out.println(i + " " + x + "에서 "+ num + "을 만남");
				if(num == 9) {
					ar[y][x] = 0;
					sdoku(list.get(count-1)[0], list.get(count-1)[1], ar[list.get(count-1)[0]][list.get(count-1)[1]]+1,count-1);
				}
				else {
					sdoku(y,x,num+1,count);
				}
				return;
			}
		}
		
		 	// 3. 구역 내 일치
		int sy = (y <= 9 && y > 6) ? 7 : (y <= 6 && y > 3) ? 4 : 1;
		int sx = (x <= 9 && x > 6) ? 7 : (x <= 6 && x > 3) ? 4 : 1;
		
		for (int i = sy; i <= sy+2; i++) {
			for (int j = sx; j <= sx+2; j++) {
				if(i == y && j == x) continue;
				if(ar[i][j] == num) {
					
//					System.out.println(i + " " + j + "에서 "+ num + "을 만남");
					if(num == 9) {
						ar[y][x] = 0;
						sdoku(list.get(count-1)[0], list.get(count-1)[1], ar[list.get(count-1)[0]][list.get(count-1)[1]]+1,count-1);
					}
					else {
						sdoku(y,x,num+1,count);
					}
					return;
				}
			}
		}
		
		if(count == list.size()-1) {
			clear = true;
			return;
		}
		else {
			sdoku(list.get(count+1)[0], list.get(count+1)[1], 1,count+1);
		}
	}
}
