package prob_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int M,N,count;
	static int min = Integer.MAX_VALUE;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		visit = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(str[j]);
			}
		}
		bfs();
		if(min == Integer.MAX_VALUE) 
			System.out.println(-1);
		else System.out.println(min);
	}
	static void bfs() {
		visit[0][0][1] = 1;
		queue.offer(new int[] {0,0,1,1}); //y좌표,x좌표,현재 가중치 값,벽을 부술 수 있는지 여부
		while(!queue.isEmpty()) {
			int[] num = queue.poll();
			if(num[0] == N-1 && num[1] == M-1) {
				min = Math.min(min, num[2]);
//				System.out.println(min);
				return;
			}
			//(02:30)벽을 부수기 전의 배열과 벽을 부순 후의 배열을 따로 사용하면 되지 않을까?
			for (int i = 0; i < 4; i++) {
				int ny = num[0] + dy[i];
				int nx = num[1] + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(num[3] == 1) { //벽을 부술 수 있는 경우
					if(ar[ny][nx] == 1 && num[3] == 1) {
						visit[ny][nx][0] = visit[ny][nx][1]+1;
						queue.offer(new int[] {ny,nx,num[2]+1,0});
					}
					else if(ar[ny][nx] == 0 && visit[ny][nx][1] == 0) {
						visit[ny][nx][1] = visit[ny][nx][1]+1;
						queue.offer(new int[] {ny,nx,num[2]+1,1});
					}
				} else if(num[3] == 0) {
					if(ar[ny][nx] == 0 && visit[ny][nx][0] == 0) {
						visit[ny][nx][0] = visit[ny][nx][0]+1;
						queue.offer(new int[] {ny,nx,num[2]+1,0});
					}
				}
			}
		}
	}
}