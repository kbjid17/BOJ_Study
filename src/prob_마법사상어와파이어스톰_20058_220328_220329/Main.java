package prob_마법사상어와파이어스톰_20058_220328_220329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,Q,s; // Q : 단계 수
	static int[] dy = {-1,1,0,0};
	static long ans = 0,amo;
	static Queue<Node> q = new LinkedList<Node>();
	static int[] dx = {0,0,-1,1};
	//격자의 크기 : 2의 N승(2~64)
	// 분할 정복이 생각나는 문제.
	static int[][] ar;
	static boolean[][] visited;
	static int[] stage;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		s = (int) Math.pow(2, N);
		ar = new int[s][s];
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < s; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			stage = new int[Q];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < Q; i++) {
//				stage[i] = Integer.parseInt(st.nextToken()); // 단계 시행 순서 정하기
				setMove(Integer.parseInt(st.nextToken()));
			}
		
		
		//이동이 끝난 후, BFS를 돌려서 
		/*
		 - 근처 얼음이 3개 이상 있지 않으면 해당 칸의 얼음 수는 1개 감소
		 - 가장 큰 덩어리를 찾는다.
		
		 */
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		
		visited = new boolean[s][s];
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				amo += ar[i][j];
				if(ar[i][j] > 0 && !visited[i][j]) bfs(i,j);
			}
		}
		System.out.println(amo);
		System.out.println(ans);
	}
	
	
	//N/(2**stage) 단위로 배열을 나눠서 시계 돌리기 진행
	static void setMove(int stage) {
		System.out.println(stage);
		System.out.println();
		if(stage >0) {
			for (int i = 0; i < s; i+=(int)Math.pow(2, stage)) {
				for (int j = 0; j < s; j+= (int)Math.pow(2, stage)) {
//					System.out.println(i + " " + j);
					getMove(i,j,stage); // [i][j] 위치에서 이동 진행	
				}
			}
		}
		
		
		
		//해당 회전이 끝난 후, 0을 찾아 감소시키는 역할 진행
		search_ice();
		
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void getMove(int r,int c,int stage) { //[2**stage][2**stage]크기의 배열 돌리기
		
		int d = (int) Math.pow(2, stage-1); // 배열을 나누는 기준
		int[][] map = new int[d][d]; // 배열 돌리기를 위한 배열 한개 저장하기
		
		for (int i = r; i < r+d; i++) { // 4사분면 배열을 복사한다
			for (int j = c; j < c+d; j++) {
				map[i-r][j-c] = ar[i][j];
			}
		}
		//4사분면 <- 3사분면
		for (int i = r; i < r+d; i++) {
			for (int j = c; j < c+d; j++) {
				ar[i][j] = ar[i+d][j];
			}
		}
		//3사분면 <- 2사분면
		for (int i = r+d; i < r+(2*d); i++) {
			for (int j = c; j < c+d; j++) {
				ar[i][j] = ar[i][j+d];
			}
		}
		//2사분면 <- 1사분면
		for (int i = r+d; i < r+(d*2); i++) {
			for (int j = c+d; j < c+(d*2); j++) {
				ar[i][j] = ar[i-d][j];
			}
		}
		//4사분면 -> 1사분면
		for (int i = r; i < r+d; i++) {
			for (int j = c+d; j < c+(2*d); j++) {
				ar[i][j] = map[i-r][j-c-d];
			}
		}
		
		
	}
	
	static void search_ice() {
		int[][] visit = new int[s][s]; //0 : 방문 x, visit[i][j] < 3이면 얼음 줄어듦
		
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				for (int d = 0; d < 4; d++) {
					int ny = i+dy[d];
					int nx = j+dx[d];
					if(ny < 0 || ny >= s || nx < 0 || nx >= s || ar[ny][nx] <= 0) continue;
						visit[i][j]+=1;
				}
			}
		}
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				if(visit[i][j] < 3) {
					ar[i][j] -=1;
				}
			}
		}
	}
	
	static void bfs(int r,int c) {
		int amount = 1;
		q.offer(new Node(r,c,0));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || ny >= s || nx < 0 || nx >= s || visited[ny][nx] || ar[ny][nx] == 0) continue;
				visited[ny][nx] = true;
				amount+=1;
				q.offer(new Node(ny,nx,amount));
			}
		}
		ans = Math.max(ans, amount);
	}
	
	static class Node {
		int y;
		int x;
		int size;

		public Node(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}
		
	}
}
