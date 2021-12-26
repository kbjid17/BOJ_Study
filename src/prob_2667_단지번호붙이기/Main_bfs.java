package prob_2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main_bfs {
	static int N;
	static Queue<int[]> q = new LinkedList<int[]>();
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
					bfs(i,j,count);
				}
			}
		}
		System.out.println(count);
//		System.out.println(sb); // 오름차순 출력 필요
		Collections.sort(list,new AscendingInteger());
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
		static void bfs(int y,int x,int count) {
			countnum = 1;
			q.offer(new int[] {y,x});
			visit[y][x] = true;
			ar[y][x] = count;
			while(!q.isEmpty()) {
				int[] num = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = num[0] + dy[i];
					int nx = num[1] + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					if(ar[ny][nx] == 1 && !visit[ny][nx]) {
						countnum++;
						ar[ny][nx] = count;
						visit[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
			sb.append(countnum).append("\n");
			list.add(countnum);
		}
		
	static class AscendingInteger implements Comparator<Integer> {

		@Override
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
		
	}
}
