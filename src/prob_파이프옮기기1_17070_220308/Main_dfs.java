package prob_파이프옮기기1_17070_220308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_dfs {
	static int N;
	static Stack<p> stack = new Stack<p>();
	static int[] dy = {0,1,1};
	static int[] dx = {1,1,0};
	static int[][] ar;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		stack.push(new p(1,2,0));
		if(ar[N][N] == 1) {
			System.out.println(0); // 너무 양아치 아니냐...
			return;
		}
		
		dfs();
		System.out.println(ans);

	}
	static void dfs() {
		while(!stack.isEmpty()) {
			p a = stack.pop();
//			System.out.println(a.y + " " + a.x);
			for (int i = 0; i < 3; i++) {
				int ny = a.y + dy[i];
				int nx = a.x + dx[i];
				if(ny <= 0 || ny > N || nx <= 0 || nx > N || ar[ny][nx] == 1) continue;
				if(a.d == 0) { //앞쪽 및 대각선만 이동 가능
					if(i == 2) continue;
				}
				else if(a.d == 2) { // 세로일 때 : 아랫쪽및 대각선만 이동 가능
					if(i == 0) continue;
				}
				
				if(i == 1) {
					if(ar[a.y][nx] == 1 || ar[ny][a.x] == 1 || ar[ny][nx] == 1) continue;
				}

				if(ny == N && nx == N) {
					ans++;
				}
				else {
					stack.push(new p(ny,nx,i));
				}
			}
		}
	}
	
	static class p {
		int y;
		int x;
		int d;
		public p(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
		
	}
}
