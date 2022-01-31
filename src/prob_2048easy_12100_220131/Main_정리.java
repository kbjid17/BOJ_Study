package prob_2048easy_12100_220131;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,max = Integer.MIN_VALUE;
	static int[][] ar;
	static Stack<block> stack = new Stack<>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			ar = new int[N][N];
			boolean[][] merge = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move(5,0,ar);
			move(5,1,ar);
			move(5,2,ar);
			move(5,3,ar);
			System.out.println(max);
	}
	private static void move(int count,int dir,int[][] ars) {
		int[][] copyar = new int[N][N];
		boolean[][] merge= new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyar[i][j] = ars[i][j];
			}
		}
		switch(dir) {
		case 0: //상
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(copyar[i][j] != 0) {
						int ny = i;
						int nx = j;
						int sc = copyar[ny][nx];
						copyar[ny][nx] = 0;
						stack.push(new block(ny,nx,sc));
						while(!stack.isEmpty()) {
							block b = stack.pop();
							ny = b.y + dy[dir];
							nx = b.x + dx[dir];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N || merge[ny][nx]) {
								copyar[b.y][b.x] = b.val;
								break;
							}
							if(copyar[ny][nx] != 0) {
								if(copyar[ny][nx] == sc && !merge[ny][nx]) { //같은 값의 블록을 만남
									copyar[ny][nx] *= 2;
									merge[ny][nx] = true;
									break;
								}
								else if(copyar[ny][nx] != sc) { //다른 값의 블록을 만남
									copyar[b.y][b.x]= b.val;
									break;
								}
							}
							stack.push(new block(ny,nx,b.val));
						}
					}
				}
			}
			break;
		case 1: //하
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-1; j >= 0; j--) {
					if(copyar[i][j] != 0) {
						int ny = i;
						int nx = j;
						int sc = copyar[ny][nx];
						copyar[ny][nx] = 0;
						stack.push(new block(ny,nx,sc));
						while(!stack.isEmpty()) {
							block b = stack.pop();
							ny = b.y + dy[dir];
							nx = b.x + dx[dir];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N || merge[ny][nx]) {
								copyar[b.y][b.x] = b.val;
								break;
							}
							if(copyar[ny][nx] != 0) {
								if(copyar[ny][nx] == sc && !merge[ny][nx]) { //같은 값의 블록을 만남
									copyar[ny][nx] *= 2;
									merge[ny][nx] = true;
									break;
								}
								else if(copyar[ny][nx] != sc) { //다른 값의 블록을 만남
									copyar[b.y][b.x]= b.val;
									break;
								}
							}
							stack.push(new block(ny,nx,b.val));
						}
					}
				}
			}
			break;
		case 2: //좌
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(copyar[i][j] != 0) {
						int ny = i;
						int nx = j;
						int sc = copyar[ny][nx];
						copyar[ny][nx] = 0;
						stack.push(new block(ny,nx,sc));
						while(!stack.isEmpty()) {
							block b = stack.pop();
							ny = b.y + dy[dir];
							nx = b.x + dx[dir];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N || merge[ny][nx]) {
								copyar[b.y][b.x] = b.val;
								break;
							}
							if(copyar[ny][nx] != 0) {
								if(copyar[ny][nx] == sc && !merge[ny][nx]) { //같은 값의 블록을 만남
									copyar[ny][nx] *= 2;
									merge[ny][nx] = true;
									break;
								}
								else if(copyar[ny][nx] != sc) { //다른 값의 블록을 만남
									copyar[b.y][b.x]= b.val;
									break;
								}
							}
							stack.push(new block(ny,nx,b.val));
						}
					}
				}
			}
			break;
		case 3: //우
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-1; j >= 0; j--) {
					if(copyar[i][j] != 0) {
						int ny = i;
						int nx = j;
						int sc = copyar[ny][nx];
						copyar[ny][nx] = 0;
						stack.push(new block(ny,nx,sc));
						while(!stack.isEmpty()) {
							block b = stack.pop();
							ny = b.y + dy[dir];
							nx = b.x + dx[dir];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N || merge[ny][nx]) {
								copyar[b.y][b.x] = b.val;
								break;
							}
							if(copyar[ny][nx] != 0) {
								if(copyar[ny][nx] == sc && !merge[ny][nx]) { //같은 값의 블록을 만남
									copyar[ny][nx] *= 2;
									merge[ny][nx] = true;
									break;
								}
								else if(copyar[ny][nx] != sc) { //다른 값의 블록을 만남
									copyar[b.y][b.x]= b.val;
									break;
								}
							}
							stack.push(new block(ny,nx,b.val));
						}
					}
				}
			}
			break;
		}
		if(count > 1) { // 5회 이동
			move(count-1,0,copyar);
			move(count-1,1,copyar);
			move(count-1,2,copyar);
			move(count-1,3,copyar);
		}
		else if(count == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, copyar[i][j]);
				}
			}
		}
	}
	private static class block {
		int y;
		int x;
		int val;
		public block(int y,int x,int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
		@Override
		public String toString() {
			return "block [y=" + y + ", x=" + x + ", val=" + val + "]";
		}
		
	}
}
