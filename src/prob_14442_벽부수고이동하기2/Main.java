package prob_14442_벽부수고이동하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,K,count;
	static int min = Integer.MAX_VALUE;
	static Queue<point> queue = new LinkedList<point>();
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		visit = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(str[j]);
			}
		}
		bfs();
		if(min == Integer.MAX_VALUE) 
			System.out.println(-1);
		else System.out.println(min);
	}
	static void bfs() {
		visit[0][0][K] = true;
		queue.offer(new point(0,0,1,K)); //y좌표,x좌표,현재 가중치 값,벽을 부술 수 있는지 여부
		while(!queue.isEmpty()) {
			point num = queue.poll();
			if(num.y == N-1 && num.x == M-1) {
				min = Math.min(min, num.d);
//				System.out.println(min);
				return;
			}
			//(02:30)벽을 부수기 전의 배열과 벽을 부순 후의 배열을 따로 사용하면 되지 않을까?
			for (int i = 0; i < 4; i++) {
				int ny = num.y + dy[i];
				int nx = num.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(num.k > 0) { //벽을 부술 수 있는 경우
					if(ar[ny][nx] == 1 && !visit[ny][nx][num.k-1]) {
						visit[ny][nx][num.k-1] = true;
						queue.offer(new point(ny,nx,num.d+1,num.k-1));
					}
					else if(ar[ny][nx] == 0 && !visit[ny][nx][num.k]) {
						visit[ny][nx][num.k] = true;
						queue.offer(new point(ny,nx,num.d+1,num.k));
					}
				} else if(num.k == 0) {
					if(ar[ny][nx] == 0 && !visit[ny][nx][0]) {
						visit[ny][nx][0] = true;
						queue.offer(new point(ny,nx,num.d+1,0));
						
					}
				}
			}
		}
	}	
	static class point {
		int y;
		int x;
		int d;
		int k;
		public point(int y, int x, int d, int k) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.k = k;
		}
		
		
	}
}