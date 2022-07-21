package prob_puyopuyo_11559_220721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visited;
	static ArrayList<int[]> puyo = new ArrayList<int[]>();
	static Queue<int[]> pos = new LinkedList<int[]>();
	static char[][] ar = new char[12][6];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 12; i++) {
			ar[i] = br.readLine().toCharArray();
		}
		
		while(true) {
			visited = new boolean[12][6];
			int cnt = 0;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(ar[i][j] != '.' && !visited[i][j]) {
						cnt += bfs(i,j,ar[i][j]);
					}
				}
			}
			if(cnt == 0) {
				System.out.println(ans);
				return;
			}
			else {
				ans++;
				for (int i = 10; i >= 0; i--) {
					for (int j = 0; j < 6; j++) {
						if(ar[i][j] != '.') {
							int dis = 1;
							char ch = ar[i][j];
							while(i + dis <= 11 && ar[i+dis][j] == '.') {
								ar[i+dis][j] = ch;
								ar[i+dis-1][j] = '.';
								dis++;
							}
						}
					}
				}
			}
		}
	}
	static int bfs(int y, int x,char c) {
		pos.offer(new int[] {y,x});
		ArrayList<int[]> delete_puyo = new ArrayList<int[]>();
		delete_puyo.add(new int[] {y,x});
		visited[y][x] = true;
		while(!pos.isEmpty()) {
			int[] n = pos.poll();
			for (int d = 0; d < 4; d++) {
				int ny = n[0] + dy[d];
				int nx = n[1] + dx[d];
				if(ny < 0 || ny >= 12 || nx < 0 || nx >= 6 || visited[ny][nx] || ar[ny][nx] != c) continue;
				visited[ny][nx] = true;
				pos.offer(new int[] {ny,nx});
				delete_puyo.add(new int[] {ny,nx});
			}
		}
			if(delete_puyo.size() >= 4) {
				for (int i = 0; i < delete_puyo.size(); i++) {
					int del_y = delete_puyo.get(i)[0];
					int del_x = delete_puyo.get(i)[1];
					ar[del_y][del_x] = '.';
				}
				return 1;
			}
		return 0;
	}

}
