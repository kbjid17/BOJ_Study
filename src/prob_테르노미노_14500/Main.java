package prob_테르노미노_14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int[][] ar;
	static Stack<Node> stack = new Stack();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M,max = Integer.MIN_VALUE;
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
			}
		}
		dfs();
		
		System.out.println(max);
		// 서로 인접한 벽돌 4개를 먹는 경우 가장 큰 경우를 구하기
		// 인접한 4개를 볼 수 있는 모든 경우를 찾아야 함.
		// dfs로 4칸만큼 이동시키는 알고리즘 구축 가능하지 않을까?(X ==> T자가 안됨)
		// dfs로 4칸 이동이 아니라 dfs로 4곳을 방문한 경우를 봐야할듯
		// 저장할 정보 : xy좌표,직전xy좌표,이동 카운트,현재 합
		// 이전 경로를 방문하지 않게 해줘야함.
	}
	
	//t자를 어떻게 검사해야 하나..?
	
	private static void dfs() { //t자 / t자 외의 경우를 따로 해서 검사해야함!
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				checkT(i,j);
				stack.push(new Node(i,j,i,j,0,ar[i][j]));
				while(!stack.isEmpty()) {
					Node node = stack.pop();
					if(node.movecount == 3) {
						max = Math.max(max, node.sum);
						continue;
					}
					for (int k = 0; k < 4; k++) {
						int ny = node.y + dy[k];
						int nx = node.x + dx[k];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M || (ny == node.cy && nx == node.cx)) continue;
						stack.push(new Node(ny,nx,node.y,node.x,node.movecount+1,node.sum+ar[ny][nx]));
					}
				}
			}
		}
	}
	
	private static void checkT(int y,int x) {
		//1. ㅜ
		int sum = 0;
		if(y >= 0 && y < N-1 && x >= 0 && x < M-2) {
			for (int i = x; i < x+3; i++) {
				sum+= ar[y][i];
			}
			sum+= ar[y+1][x+1];
			max = Math.max(max, sum);
			sum = 0;
		}
		//2. ㅗ
		if(y >= 1 && y < N && x >= 0 && x < M-2) {
			for (int i = x; i < x+3; i++) {
				sum+= ar[y][i];
			}
			sum+= ar[y-1][x+1];
			max = Math.max(max, sum);
			sum = 0;
		}
		//3. ㅓ
		if(y >= 1 && y < N-1 && x >= 0 && x < M-1) {
			for (int i = y-1; i < y+2; i++) {
				sum+= ar[i][x+1];
			}
			sum+= ar[y][x];
			max = Math.max(max, sum);
			sum = 0;
		}
		//4. ㅏ
		if(y >= 0 && y < N-2 && x >= 0 && x < M-1) {
			for (int i = y; i < y+3; i++) {
				sum+= ar[i][x];
			}
			sum+= ar[y+1][x+1];
			max = Math.max(max, sum);
			sum = 0;
		}
	}

	private static class Node {
		int y;
		int x;
		int cy;
		int cx;
		int movecount;
		int sum;
		public Node(int y, int x,int cy,int cx, int movecount, int sum) {
			this.y = y;
			this.x = x;
			this.cy= cy;
			this.cx = cx;
			this.movecount = movecount;
			this.sum = sum;
		}
		
	}
}
