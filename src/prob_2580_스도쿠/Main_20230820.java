package prob_2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_20230820 {

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

			sdoku(0);
		
		

		
	}
	
	static void sdoku(int depth) {
		if(clear) return;
		else {
			if(depth == list.size()) {
				clear = true;
				for (int i = 1; i <= 9; i++) {
					for (int j = 1; j <= 8; j++) {
						System.out.print(ar[i][j]);
					}
					System.out.println(ar[i][9]);
				}
				return;
			}
		}
		
		boolean[] number = new boolean[10];
		
		for (int i = 1; i <= 9; i++) {
			if(!number[ar[i][list.get(depth)[1]]]) number[ar[i][list.get(depth)[1]]] = true;
		}
		for (int i = 1; i <= 9; i++) {
			if(!number[ar[list.get(depth)[0]][i]]) number[ar[list.get(depth)[0]][i]] = true;
		}
		
		int sy = list.get(depth)[0] >= 7 && list.get(depth)[0] <= 9 ? 7 : 
				 list.get(depth)[0] >= 4 && list.get(depth)[0] <= 6 ? 4 : 1;
		int sx = list.get(depth)[1] >= 7 && list.get(depth)[1] <= 9 ? 7 : 
			 	 list.get(depth)[1] >= 4 && list.get(depth)[1] <= 6 ? 4 : 1;
			 	 
	 	 for (int i = sy; i <= sy+2; i++) {
	 		 for (int j = sx; j <= sx+2; j++) {
				if(!number[ar[i][j]]) number[ar[i][j]] = true;
			}
		 }
	 	 
	 	 for (int i = 1; i < number.length; i++) {
			if(number[i]) continue;
			
			ar[list.get(depth)[0]][list.get(depth)[1]] = i;
			sdoku(depth+1);
			ar[list.get(depth)[0]][list.get(depth)[1]] = 0;
		}
		
	}
}
