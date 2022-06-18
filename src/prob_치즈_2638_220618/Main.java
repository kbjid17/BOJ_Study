package prob_치즈_2638_220618;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] ar;
	static int ans;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				ans+= ar[i][j];
			}
		}
		int cnt = 0;
		while(ans > 0) {
			cnt++;
			bfs();
		}
		System.out.println(cnt);
	}
	
	static void bfs() {
		q = new LinkedList<int[]>();
		boolean[][] selected = new boolean[N][M];
		
		q.offer(new int[] {0,0});
		ar[0][0] = 2;
		selected[0][0] = true;
		while(!q.isEmpty()) { // 치즈 바깥의 공기를 0->2로 바꾸는 과정
			int[] n = q.poll();

			
			for (int d = 0; d < 4; d++) {
				int ny = n[0] + dy[d];
				int nx = n[1] + dx[d];
				if(ny<0 || ny >= N || nx < 0 || nx >= M || selected[ny][nx]) continue;
					if(ar[ny][nx] == 0 || ar[ny][nx] == 2) {
						if(ar[ny][nx] == 0) {							
							ar[ny][nx] = 2;
						}
						q.offer(new int[] {ny,nx});
						selected[ny][nx] = true; // false -> true;
					}
					
			}
		}
		
		q.offer(new int[] {0,0});
		selected[0][0] = false; // true -> false
		while(!q.isEmpty()) { // 2로 바꾼 공기를 베이스로 치즈를 검사하는 과정
			int[] n = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = n[0] + dy[d];
				int nx = n[1] + dx[d];
				if(ny<0 || ny >= N || nx < 0 || nx >= M || (!selected[ny][nx] && ar[ny][nx] != 1)) continue; // ar[ny][nx] =1인 경우는 이전 bfs에 포함되지 않았으므로 false 상태.
				if(ar[ny][nx] == 2) {
					q.offer(new int[] {ny,nx});
					selected[ny][nx] = false;
				}
				else if(ar[ny][nx] == 1) {
					int cnt = 4;
					for (int k = 0; k < 4; k++) {
						int oy = ny + dy[k];
						int ox = nx + dx[k];
						if(oy < 0 || oy >= N || nx < 0 || nx >= M) continue;
						if(ar[oy][ox] != 2) cnt--;
					}
					if(cnt>= 2) {
						ar[ny][nx] = 3;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 3) {
					ar[i][j] = 2; // 가장 바깥에 있는 녀석이 사라짐 -> 2로 변경
					ans--;
				}
			}
		}
	}
}
