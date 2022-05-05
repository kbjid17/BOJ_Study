package prob_내리막길_1520_220504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static Stack<Node> stack = new Stack<Node>();
	static long ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ar = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		stack.push(new Node(0,0,ar[0][0]));
		System.out.println(dfs());
	}
	
	static long dfs() {
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			
			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny < 0 || ny >= M || nx < 0 || nx >= N || ar[ny][nx] >= n.v) continue;
				if(ny == M-1 && nx == N-1) {
					ans++;
					break;
				}
				stack.push(new Node(ny,nx,ar[ny][nx]));
			}
		}
		return ans;
	}

	static class Node {
		int y;
		int x; // (y,x)
		int v; // ar[y][x] 값
		
		public Node(int y, int x, int v) {
			super();
			this.y = y;
			this.x = x;
			this.v = v;
		}
	}
}
