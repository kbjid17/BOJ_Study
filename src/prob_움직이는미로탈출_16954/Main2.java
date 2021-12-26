package prob_움직이는미로탈출_16954;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	static Queue<point> queue = new LinkedList<point>();
	static boolean[][] visit;
	static int[] dy = {0,-1,1,0,0,-1,1,1,-1};
	static int[] dx = {0,0,0,-1,1,1,1,-1,-1};
	static char[][][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ar = new char[9][8][8];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				Arrays.fill(ar[i][j], '.');
			}
		}
		visit = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
				ar[0][i] = str.toCharArray();
				for (int j = 1; j < 8; j++) {
					if(i+j >= 8) break;
					ar[j][i+j] = ar[0][i];
				}
		}
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 8; j++) {
//				for (int j2 = 0; j2 < 8; j2++) {
//					System.out.print(ar[i][j][j2]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		

		bfs();
	}
	static void bfs() {
		queue.offer(new point(7,0,0));
		while(!queue.isEmpty()) {
			point num = queue.poll();
//			System.out.println(num.d);
			if(ar[num.d][num.y][num.x] == '#') continue;
			for (int i = 0; i < 9; i++) {
				int ny = num.y + dy[i];
				int nx = num.x + dx[i];
				if(ny < 0 || ny >= 8 || nx < 0 || nx  >= 8 || visit[ny][nx] || ar[num.d][ny][nx] == '#') continue;
				
				if(ny == 0 && nx == 7) {
					System.out.println(1);
					return;
				}
				if(num.d < 8) 
					{
						queue.offer(new point(ny,nx,num.d+1));
					}
				else if(num.d >= 8) 
					{
						visit[ny][nx] = true;
						queue.offer(new point(ny,nx,8));
					}
				
			}
		}
		System.out.println(0);
	}
	
	static class point {
		int y;
		int x;
		int d;
		public point(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}
