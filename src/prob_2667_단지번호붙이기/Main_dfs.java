package prob_2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Main_dfs {
	static int N;
	static Stack<int[]> stack = new Stack<int[]>();
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int count = 0,countnum = 0;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				ar[i][j] = s.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(ar[i][j] == 1 && !visit[i][j]) {
					count +=1;
					dfs(i,j,count);
				}
			}
		}
		System.out.println(count);
		Collections.sort(list,new AscendingInteger());
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
		static void dfs(int y,int x,int count) {
			countnum = 1;
			stack.push(new int[] {y,x});
			visit[y][x] = true;
			ar[y][x] = count;
			while(!stack.isEmpty()) {
				int[] num = stack.pop();
				for (int i = 0; i < 4; i++) {
					int ny = num[0] + dy[i];
					int nx = num[1] + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					if(ar[ny][nx] == 1 && !visit[ny][nx]) {
						countnum++;
						ar[ny][nx] = count;
						visit[ny][nx] = true;
						stack.push(new int[] {ny,nx});
					}
				}
			}
			list.add(countnum);
		}
		
	static class AscendingInteger implements Comparator<Integer> {

		@Override
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
		
	}
}
