package prob_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_완탐_시간초과 {
	static int M,N,count;
	static int min = Integer.MAX_VALUE;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(str[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 1) {
					ar[i][j] = 0;
					visit = new boolean[N][M];
					bfs();
					ar[i][j] = 1;
				}
			}
		}
		if(min == Integer.MAX_VALUE) 
			System.out.println(-1);
		else System.out.println(min);
	}
	static void bfs() {
		visit[0][0] = true;
		queue.offer(new int[] {0,0,1});
		while(!queue.isEmpty()) {
			int[] num = queue.poll();
			if(num[0] == N-1 && num[1] == M-1) {
				min = Math.min(min, num[2]);
//				System.out.println(min);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = num[0] + dy[i];
				int nx = num[1] + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || ar[ny][nx] == 1) continue;
				if(!visit[ny][nx]) {
					visit[ny][nx] = true;
					queue.offer(new int[] {ny,nx,num[2]+1});
				}
			}
		}
	}
}