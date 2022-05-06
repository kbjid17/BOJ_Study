package prob_그림_1926_220506;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] ar;
	static int ansNum,ansSize; // 그림 갯수, 그림 최대 크기
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
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
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		System.out.println(ansNum);
		System.out.println(ansSize);
	}

	static void bfs(int y,int x) {
		ansNum++;
		q.offer(new int[] {y,x});
		int size = 1;
		while(!q.isEmpty()) {
			int[] n = q.poll();
			ar[n[0]][n[1]] = 2;
			for (int d = 0; d < 4; d++) {
				int ny = n[0] + dy[d];
				int nx = n[1] + dx[d];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || ar[ny][nx] != 1) continue;
				ar[ny][nx] = 2;
				size++;
				q.offer(new int[] {ny,nx});
			}
		}
		ansSize = Math.max(ansSize, size);
	}
}
