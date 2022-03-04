package prob_스타트택시_19238_220304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<taxi> queue = new LinkedList<taxi>();
	static int[] dy = {-1,0,0,1};
	static int[] dx = {0,-1,1,0};
	static int N,M,F; // N : 배열 크기(N*N 배열) , M : 승객 수, F : 기름 양
	static int r,c; // 택시의 위치 [r][c]
	static int ans;
	static int[][][] ar;
	static boolean[][][] selected;
	static int[] cs = new int[4];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 // 같은 거리...
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		ar = new int[M+2][N+1][N+1];
		selected = new boolean[M+2][N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[0][i][j] = Integer.parseInt(st.nextToken());
				if(ar[0][i][j] == 1) {
					for (int k = 2; k < M+2; k++) {
						ar[k][i][j] = ar[0][i][j];
					}	
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		
		for (int i = 2; i < M+2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				cs[j] = Integer.parseInt(st.nextToken());
			}
			ar[0][cs[0]][cs[1]] = i; // 손님의 위치
			ar[i][cs[2]][cs[3]] = i; // 손님이 가고 싶은 목적지
		}
		queue.offer(new taxi(r,c,F,ar[0][r][c],0));
		if(ar[0][r][c] != 0) ar[0][r][c] = 0;
		bfs(M);
		System.out.println(ans);
	}
	
	static void bfs(int cnt) {
		while(!queue.isEmpty() && cnt > 0) {
			taxi t = queue.poll();
			if(t.f == 0) break;
			
			for (int i = 0; i < 4; i++) {
				int ny = t.y + dy[i];
				int nx = t.x + dx[i];
				if(ny <= 0 || ny > N || nx <= 0 || nx > N || ar[0][ny][nx] == 1) continue;
				if(t.c == 0) { //손님을 태우고 있지 않을 경우
					if(selected[0][ny][nx]) continue;
					if(ar[0][ny][nx] != 0) {
						// 같은 거리의 손님이 있을 경우 가장 번호가 낮은 손님부터 골라야 함..
						int n = Integer.MAX_VALUE;
//						System.out.println("택시 위치 : " + t.y + " " + t.x);
						for (int j = 0; j < 4; j++) {
							int yy = t.y + dy[j];
							int xx = t.x + dx[j];
							if(yy <= 0 || yy > N || xx <= 0 || xx > N || ar[0][yy][xx] == 1) continue;
							if(ar[0][yy][xx] > 1) {
//								System.out.println("확인하는 값 : " + ar[0][yy][xx]);
								n = Math.min(n, ar[0][yy][xx]);
							}
						}
//						System.out.println("만난 손님 : "+ n);
//						System.out.println(t.f-1 + " " + ny + " " + nx);
						queue.clear();
						
						queue.offer(new taxi(ny,nx,t.f-1,n,0));
						ar[0][ny][nx] = 0;
						break;
					}
					selected[0][ny][nx] = true;
					queue.offer(new taxi(ny,nx,t.f-1,0,0));
				}
				else { // 손님을 태우고 있을 경우
					if(ar[t.c][ny][nx] == 1) continue;
					if(selected[t.c][ny][nx]) continue;
					if(ar[t.c][ny][nx] == t.c) {
						cnt--;
//						System.out.println(ny + " " + nx);
//						System.out.println(cnt);
						queue.clear();
						queue.offer(new taxi(ny,nx,t.f-1+((t.d+1)*2),ar[0][ny][nx],0));
						if(ar[0][ny][nx] != 0) ar[0][ny][nx] = 0;
//						System.out.println(t.f-1 + " + " + (t.d+1)*2);
//						System.out.println(queue.peek());
						
						if(cnt == 0) {
							ans = queue.poll().f;
							return;
						}
						selected = new boolean[M+2][N+1][N+1];
						break;
					}
//					System.out.println(ny + " " + nx);
					selected[t.c][ny][nx] = true;
					queue.offer(new taxi(ny,nx,t.f-1,t.c,t.d+1));
				}
			}
		}
		ans = -1;
		return;
	}
	
	static class taxi {
		int y;
		int x;
		int f; // 연료
		int c; // 손님을 태웠는지. 태웠으면 목적지를 찾고, 안태웠으면 손님을 찾음
		int d; // 손님을 태운 후 이동한 거리
		public taxi(int y, int x, int f, int c, int d) {
			super();
			this.y = y;
			this.x = x;
			this.f = f;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "taxi [y=" + y + ", x=" + x + ", f=" + f + ", c=" + c + ", d=" + d + "]";
		}
	}
}
