package prob_게리맨더링2_모르겠다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, selectCnt,x,y,d1,d2;
	static Queue<Node> queue = new LinkedList<Node>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static int[][] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 구역을 5개 선거구로 나눠야 함
		// 각 구역은 5개의 선거구 중 하나에 포함되어야만 함
		// 각 선거구는 최소 하나의 구역을 포함해야 함.
		// 한 선거구에 있는 구역은 모두 연결되어야 함(구역 A에서 인접한 구역을 통해 구역 B로 이동 가능 : A와 B는 연결)
		// 인접 구역은 0개 이상
		
		/*
		 기준점 (x,y)와 경계의 길이 (d1,d2)를 정함
		 */
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1][N+1];
		selected = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				//구역 (i,j)의 인구수눈 ar[i][j]
			}
		}
		
		/*
	 	N과 배열이 주어지고, 그 배열 안에서 모든 걸 구현해야 함
		 */
		// d1,d2,x,y가 정해진 후 그 안에서 영역표시 진행
		for (int d1 = 1; d1 <= N; d1++) {
			for (int d2 = 1; d2 <= N; d2++) { //d1,d2 경계선 결정
				
				for (int y = 1; y <= N; y++) { // y 기준점 정함
					if(y + d2 > N) continue;
					for (int x = 1; x <= N; x++) { //x 기준점 정함
						if(x + d1 + d2 > N) continue;
						for (int i = y-d1+1; i < y+d2; i++) { //i = y로 구분
							if(i <= 0 || i > N) break;
							for (int j = x; j < x + d1+d2; j++) { // j = x로 구분
								if(j <= 0 || j  > N) break;
								bfs(d1,d2,i,j);
								//1. (j, i), (j+1, i-1), ..., (j+d1, i-d1) (ar[i][j])
								
								//2. (j, i), (j+1, i+1), ..., (j+d2, i+d2)
								
								//3. (j+d1, i-d1), (j+d1+1, i-d1+1), ..., (j+d1+d2, i-d1+d2)
								
								//4. (j+d2, i+d2), (j+d2+1, i+d2-1), ..., (j+d2+d1, i+d2-d1)
								
							}
						}
					}
				}
				
				
				
			}
		}
		
		
	}

	static void bfs(int d1,int d2,int y,int x) {
		queue.offer(new Node(y,x));
		while(!queue.isEmpty()) {
			Node a = queue.poll();
			// 경계선 칠하기
			int r = a.x;
			int c = a.y;
			System.out.println("node 초기값 : " + r + " " + c);
			System.out.println("d값 : " + d1 + " " + d2);
//			(x, y), (x+1, y-1), ..., (x+d1, y-d1)
			while(r <= x+d1 && c >= y-d1) {
				System.out.println(r+ " " + c);
				selected[c][r] = 5;
				r++;
				c--;
			}
			r = a.x;
			c = a.y;
//			(x, y), (x+1, y+1), ..., (x+d2, y+d2)
			while(r <= x+d2 && c <= y+d2) {
				selected[c][r] = 5;
				r++;
				c++;
			}
			r = a.x+d1;
			c = a.y-d1;
//			(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
			while(r <= x+d1+d2 && c <= y-d1+d2) {
				System.out.println(r + " " + c);
				selected[c][r] = 5;
				r++;
				c++;
			}
			r = a.x+d2;
			c = a.y+d2;
//			(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
			while(r <= x+d2+d1 && c >= y+d2-d1) {
//				System.out.println(r + " " + c);
				selected[c][r] = 5;
				r++;
				c--;
			}
			
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(selected[i][j] + " ");
			}
			System.out.println();
		}
		selected = new int[N+1][N+1];
	}
	
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
}
