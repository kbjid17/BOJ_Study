package prob_2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239 {

	static int[][] ar;
	static int count;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			ar = new int[9][9];
			for (int j = 0; j < 9; j++) {
				ar[i][j] = str.charAt(j)-'0';
				if(ar[i][j] == 0)	list.add(new int[] {i,j});
			}
		}
		sdoku(0);
	}
	
	static void sdoku(int depth) {
		if(count == 0) {
			boolean[] number = new boolean[10];
			if(depth == list.size()) {
				count++;
				complete();
				return;
			}
			number[0] = true;
			for (int i = 0; i < 9; i++) {
				if(!number[ar[list.get(depth)[0]][i]]) number[ar[list.get(depth)[0]][i]] = true;
			}
			for (int i = 0; i < 9; i++) {
				if(!number[ar[i][list.get(depth)[1]]]) number[ar[i][list.get(depth)[1]]] = true;
			}
			
			int y = list.get(depth)[0] /3*3;
			int x = list.get(depth)[1] /3*3;
			for (int i = y; i < y+3; i++) {
				for (int j = x; j < x+3; j++) {
					if(!number[ar[i][j]]) number[ar[i][j]] = true;
				}
			}
			
			for (int i = 1; i <= 9; i++) {
				if(number[i]) continue;
				
				ar[list.get(depth)[0]][list.get(depth)[1]] = i;
				sdoku(depth+1);
				ar[list.get(depth)[0]][list.get(depth)[1]] = 0;
			}
		}
	}
	
	static void complete() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
	}
}
