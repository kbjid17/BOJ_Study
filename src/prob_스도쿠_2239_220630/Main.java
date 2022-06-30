package prob_스도쿠_2239_220630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int[][] ar = new int[9][9];
	static int flag = 0;
	static ArrayList<int[]> list = new ArrayList<int[]>(); 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				ar[i][j] = c[j]-'0';
				if(ar[i][j] == 0) list.add(new int[] {i,j});
			}
		}
		
		game(0);
		
		
	}

	static void game(int idx) {
		if(flag == 1) return;
		if(idx == list.size()) {
			flag = 1;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(ar[i][j]);
				}
				System.out.println();
			}
			
		}
		if(flag == 1) return;
		boolean[] unable = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if(!unable[ar[i][list.get(idx)[1]]]) unable[ar[i][list.get(idx)[1]]] = true;
			if(!unable[ar[list.get(idx)[0]][i]]) unable[ar[list.get(idx)[0]][i]] = true;
		}
		
		for (int i = (list.get(idx)[0]/3) *3; i < (list.get(idx)[0]/3) *3 +3; i++) {
			for (int j = (list.get(idx)[1]/3) *3; j < (list.get(idx)[1]/3) *3 +3; j++) {
				if(!unable[ar[i][j]]) unable[ar[i][j]] = true;
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if(unable[i]) {
//				System.out.println(idx + " " + i + "는 안됨");
				continue;
			}
			
			ar[list.get(idx)[0]][list.get(idx)[1]] = i;
//			System.out.println(idx + " " + i);
			game(idx+1);
			ar[list.get(idx)[0]][list.get(idx)[1]] = 0;
		}
	}
}
