package prob_색종이붙이기_17136_220718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정리 {
	static int ans = Integer.MAX_VALUE;
	static int area_cnt;
	static int[][] ar = new int[11][11];
	static boolean[][] visited = new boolean[11][11];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] start = new int[2];
		for (int i = 1; i <= 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 10; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 1) {
					if(start[0] == 0 && start[1] == 0) {
						start[0] = i;
						start[1] = j;
					}
					area_cnt++;
				}
			}
			
		}
		
		if(area_cnt == 0) {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; i <= 5; i++) {
			int[] paper = {0,5,5,5,5,5};
			game(i,paper,start[0],start[1],ar,area_cnt,0);
		}
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}
	
	static void game(int size, int[] paper, int y,int x, int[][] ar,int area_cnt,int paper_cnt) {
		if(paper[size] == 0) return;
		if(y+size > 11 || x + size > 11) return;
		int[][] copy_ar = new int[11][11]; // 배열 복사 선언
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				copy_ar[i][j] = ar[i][j];
			}
		}

		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
				if(copy_ar[i][j] == 0) return; 
				copy_ar[i][j] = 0;
				area_cnt--;
			}
		}
		paper_cnt++;
		paper[size]--;
		if(area_cnt == 0) {
			ans = Math.min(ans, paper_cnt);
			return;
		}
		int[] start = {0,0};
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if(copy_ar[i][j] == 1) {
					if(start[0] == 0 && start[1] == 0) {
						start[0] = i;
						start[1] = j;
						break;
					}
				}
			}
			if(start[0] != 0 && start[1] != 0) break;
		}
		for (int i = 1; i <= 5; i++) {
			int[] new_paper = paper.clone();
			game(i,new_paper,start[0],start[1],copy_ar,area_cnt,paper_cnt);
		}
	}
}