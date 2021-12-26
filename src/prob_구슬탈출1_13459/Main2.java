package prob_구슬탈출1_13459;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int N,M;
	static char[][] ar;
	static Balls balls = new Balls();
	static Queue<Balls> queue = new LinkedList<Balls>();
	static boolean [][][][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][N][M];
		ar = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			ar[i] = str;
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 'R') {
					balls.red_y = i;
					balls.red_x = j;
				} else if(ar[i][j] == 'B') {
					balls.blue_y = i;
					balls.blue_x = j;
				}
			}
		}
		bfs(balls);
		
		//1. 판을 돌리는 방향을 정함(0 : 위, 1 : 왼쪽, 2: 아래 , 3 : 오른쪽)
		//2. 판을 돌릴 떄마다 배열의 모양은 변함.
		//3. 돌리다가 파란 공이 들어가면 x , 빨간 구슬이 들어가면 끝(이후 이동 횟수 출력), 동시에 빠져도 실패
		//4. 더이상 구슬이 움직이지 않으면 그만둠.(4가지 방향으로 이동을 시도했을 때, 배열의 변화가 없으면 해당 방법은 X)
	}
	
	static void bfs(Balls ball) { 
		queue.offer(ball);
		visited[balls.red_y][balls.red_x][balls.blue_y][balls.blue_x] = true;
		while(!queue.isEmpty()) {
			Balls balls = queue.poll();
			if(balls.depth > 10) {
				System.out.println(0);
				return;
			}
			if(ar[balls.red_y][balls.red_x] == 'O' && ar[balls.blue_y][balls.blue_x] != 'O') {
				System.out.println(1);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int red_ny = balls.red_y;
				int red_nx = balls.red_x;
				int blue_ny = balls.blue_y;
				int blue_nx = balls.blue_x;
				
				while(ar[red_ny][red_nx] != '#' && ar[red_ny][red_nx] != 'O') {
					red_ny += dy[i];
					red_nx += dx[i];
				}
				if(ar[red_ny][red_nx] == '#' )
				{
					red_ny -= dy[i];
					red_nx -= dx[i];
				}
				
				while(ar[blue_ny][blue_nx] != '#' && ar[blue_ny][blue_nx] != 'O') {
					blue_ny += dy[i];
					blue_nx += dx[i];
				}
				if(ar[blue_ny][blue_nx] == '#' )
				{
					blue_ny -= dy[i];
					blue_nx -= dx[i];
				}
				
				if(red_ny == blue_ny && red_nx == blue_nx) {
					if(ar[red_ny][red_nx] != 'O') {
						int red_dist = Math.abs(balls.red_y-red_ny) + Math.abs(balls.red_x - red_nx);
						int blue_dist = Math.abs(balls.blue_y-blue_ny) + Math.abs(balls.blue_x - blue_nx);
						if(red_dist > blue_dist) {
							red_ny -= dy[i];
							red_nx -= dx[i];
						} else if(red_dist < blue_dist) {
							blue_ny -= dy[i];
							blue_nx -= dx[i];
						}
					}
				}
				if(visited[red_ny][red_nx][blue_ny][blue_nx]) continue;
				visited[red_ny][red_nx][blue_ny][blue_nx] = true;
				queue.offer(new Balls(red_ny,red_nx,blue_ny,blue_nx,balls.depth+1));
			}
		}
		System.out.println(0);
	}
	static class Balls { //두 공의 위치 정보를 가지는 클래스(두 공이 동시에 이동해야 하기 때문에) 
		int red_y;
		int red_x;
		int blue_y;
		int blue_x;
		int depth;
		
		public Balls() {}
		public Balls(int red_y,int red_x, int blue_y,int blue_x,int depth) {
			this.red_y = red_y;
			this.red_x = red_x;
			this.blue_y = blue_y;
			this.blue_x = blue_x;
			this.depth = depth;
		}
	}
}