package prob_스타트택시_19238_220304_아직못품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2트 {
	static int N,M,F,r,c,ans = -1;
	static Queue<taxi> queue = new LinkedList<taxi>();
	static int[] dy = {-1,0,0,1};
	static int[] dx = {0,-1,1,0};
	static int[][][] ar;
	static int[] client;
	static boolean[][][] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		ar = new int[M+2][N+1][N+1];
		selected = new boolean[M+2][N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[0][i][j] = Integer.parseInt(st.nextToken());
				if(ar[0][i][j] ==1) {
					for (int d = 1; d < M+1; d++) {
						ar[d][i][j] = 1;
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		client = new int[4];
		for (int i = 2; i < M+2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				client[j] = Integer.parseInt(st.nextToken());
			}
			ar[0][client[0]][client[1]] = i;
			ar[i][client[2]][client[3]] = i;
		}
		
		
		bfs(M);
		System.out.println(ans);
	}
	
	static void bfs(int cnt) {
		queue.offer(new taxi(r,c,ar[0][r][c],F,0));
		selected[0][r][c] = true;
		ar[0][r][c] = 0;
		while(!queue.isEmpty()) {
			taxi t = queue.poll();
			System.out.println(t);
			if(t.f <= 0) break;
			for (int d = 0; d < 4; d++) {
				int ny = t.y + dy[d];
				int nx = t.x + dx[d];
				if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
				if(t.c == 0) {
					if(ar[0][ny][nx] == 1 || selected[0][ny][nx]) continue;
					if(ar[0][ny][nx] > 1) {
						queue.clear();
						queue.offer(new taxi(ny,nx,ar[0][ny][nx],t.f-1,0));
						ar[0][ny][nx] = 0;
						for (int i = 1; i <= N; i++) {
							for (int j = 1; j <= N; j++) {
								selected[0][i][j] = false;
							}
						}
						break;
					}
					selected[0][ny][nx] = true; 
					queue.offer(new taxi(ny,nx,ar[0][ny][nx],t.f-1,0));
				}
				else if(t.c > 1) {
					if(ar[t.c][ny][nx] == 1 || selected[t.c][ny][nx]) continue;
					if(ar[t.c][ny][nx] == t.c) {
						cnt-=1;
						queue.clear();
						queue.offer(new taxi(ny,nx,0,(t.f-1)+((t.dist+1)*2),0));
						System.out.println(queue.peek());
						break;
					}
					selected[t.c][ny][nx] = true;
					queue.offer(new taxi(ny,nx,t.c,t.f-1,t.dist+1));
				}
			}
			if(cnt == 0) {
				ans = queue.poll().f;
				return;
			}
		}
	}
	static class taxi {
		int y; // y좌표
		int x; // x좌표
		int c; // 태운 고객
		int f; // 기름 양
		int dist; // 손님을 태운 채 이동한 거리
		public taxi(int y, int x, int c, int f, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.f = f;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "taxi [y=" + y + ", x=" + x + ", c=" + c + ", f=" + f + ", dist=" + dist + "]";
		}
		
		
	}
}
