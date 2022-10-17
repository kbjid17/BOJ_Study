package prob_미네랄_2933_220614_220615_221017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int R,C,N;
	static int[] straws;
	static char[][] ar;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ar = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			ar[i] = str.toCharArray();
		}
		N = Integer.parseInt(br.readLine());
		straws = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			straws[i] = Integer.parseInt(st.nextToken());
			
			visited = new boolean[R][C];
			if(i %2 == 0) {
				game(1,R-straws[i]);
			}
			else {
				game(-1,R-straws[i]);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
	}
	static void game(int dir, int h) {
		switch(dir) {
		case 1:
			for (int i = 0; i < C; i++) {
				if(ar[h][i] == 'x') {
					ar[h][i] = '.';
					break;
				}
			}
			break;
		case -1:
			for (int i = C-1; i >=0 ; i--) {
				if(ar[h][i] == 'x') {
					ar[h][i] = '.';
					break;
				}
			}
			break;
		}
		
		for (int i = R-1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if(ar[i][j] == 'x' && !visited[i][j]) {
					bfs(i,j);
				}
			}
			
		}
	}
	
	static void bfs(int r,int c) {
		boolean[][] selected = new boolean[R][C];
		int dist = Integer.MAX_VALUE;
		ArrayList<int[]> list = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r,c});
		list.add(new int[] {r,c});
		selected[r][c] = true;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = n[0]  + dy[d];
				int nx = n[1]  + dx[d];
				if(ny < 0 || ny >= R || nx < 0 || nx >= C || selected[ny][nx] || ar[ny][nx]=='.') continue;
				list.add(new int[] {ny,nx});
				q.offer(new int[] {ny,nx});
				selected[ny][nx] = true;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)[0] == R-1) {
				dist = 0;
				break;
			}
			if(list.get(i)[0] < R-1 && ar[list.get(i)[0]+1][list.get(i)[1]] == '.') {
				int distance = 0;
				for (int j = list.get(i)[0]+1; j < R; j++) {
					
					distance +=1;
					if(ar[j][list.get(i)[1]] == 'x' && !selected[j][list.get(i)[1]]) {
						distance -=1;
						break;
					}
					if(j == R-1) {
						break;
					}
				}
				dist = Math.min(distance, dist);
			}
		}
		if(dist == 0 || dist == Integer.MAX_VALUE) { 
			for (int i = 0; i < list.size(); i++) {
				visited[list.get(i)[0]][list.get(i)[1]] = true;
			}
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			ar[list.get(i)[0]][list.get(i)[1]] = '.';
			list.get(i)[0] += dist;
		}
		for (int i = 0; i < list.size(); i++) {
			ar[list.get(i)[0]][list.get(i)[1]] = 'x';
			visited[list.get(i)[0]][list.get(i)[1]] = true;
		}
	}
}