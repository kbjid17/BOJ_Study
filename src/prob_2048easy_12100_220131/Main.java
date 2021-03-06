package prob_2048easy_12100_220131;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
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

		//이동 알고리즘 구현
		/*
		 1. 0이 아닌 수를 발견(block)
		 2. 그 블록의 y,x,val을 저장한 후 그자리는 0으로 만듦
		 3. 저장된 값을 stack에 삽입
		 4. dfs로 갈 수 있는 곳까지 가면서 ny,nx 값을 갱신해가며 이동
		 5. 종료 조건 : 배열 밖으로 넘어가거나, 이동할 곳에 블록이 위치해 있는 경우
		 5-1. 같은 값의 블록 : 그 위치의 블록을 2배로 늘린 후 stack 값을 빼버리는 것으로 종료
		 5-2. 다른 값의 블록 : 이동하기 전의 위치에서 멈추고 그 위치에 블록의 값을 집어넣는 것으로 종료
		 */
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
//						System.out.println(1);
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
//						System.out.println(copyar[i][j]);
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
