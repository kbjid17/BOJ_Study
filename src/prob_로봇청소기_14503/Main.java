package prob_로봇청소기_14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {

	static int N,M,r,c,dir,count;
	static int[] dy = {-1,0,1,0}; // 0 : 북쪽, 1: 동쪽 , 2: 남쪽 , 3: 서쪽
	static int[] dx = {0,1,0,-1}; //요구되는 방향 : 북(0) -> 서(3) -> 남(2) -> 동(1)
	static int[][] ar;
	static Stack<robot> stack = new Stack<robot>();
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(r,c,dir);
		System.out.println(count);
	}

	static void dfs(int r,int c,int dir) {
		step1_clean(r,c);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(ar[i][j] + " ");
//			}
//			System.out.println();
//		}
		stack.push(new robot(r,c,dir));
		while(!stack.isEmpty()) {
			robot rob = stack.pop();
//			System.out.println(rob.toString());
			for (int i = 0; i < 4; i++) {
				int nd = (rob.dir+3-i)%4; //이동 방향 정의
				int ny = rob.y+dy[nd]; // 방향 기준 이동할 위치 정의
				int nx = rob.x+dx[nd]; // 방향 기준 이동할 위치 정의
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || ar[ny][nx] == 1 || ar[ny][nx] == 2) 
					{
						if(i == 3) {
							//1칸 후진
							int nd_rev = (rob.dir+2)%4; // 후진(현재 돌의 방향과 반대 방향)
							int ny_rev = rob.y + dy[nd_rev]; // 후진으로 이동할 위치
							int nx_rev = rob.x + dx[nd_rev]; // 후진으로 이동할 위치
							if(ar[ny_rev][nx_rev] == 1) return; //후진 안되면 끝
							stack.push(new robot(ny_rev,nx_rev,rob.dir)); //방향은 유지
							break;
						}
						else {
							continue; //벽 밖으로 나가거나 ++ 벽이거나 ++ 청소한 곳이면 continue;
						}
					}
				if(ar[ny][nx] == 0) {
					step1_clean(ny,nx);
					stack.push(new robot(ny,nx,nd));
					break; // 바로 이곳으로 이동을 하기 떄문에 현재 위치에서 더 돌 필요가 없어짐!
				}
			}
		}
	}
	static void step1_clean(int y, int x) {
		if(ar[y][x] == 0) {
			ar[y][x] = 2;
		}
		count++;
	}
	
	static class robot {
		int y;
		int x;
		int dir;
		public robot(int y,int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}
