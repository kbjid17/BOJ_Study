package prob_연구소3_17142_220703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> input = new ArrayList<int[]>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M; // N*N 배열, M개의 바이러스 활성화
	static int[][] ar;
	static int[][] tgt;
	static int area; // 벽 갯수
	static int sec = Integer.MAX_VALUE;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 2) {
					input.add(new int[] {i,j});
				}
				if(ar[i][j] == 0) area++;
			}
		}
		if(area == 0) {
			System.out.println(0);
			return;
		}
		tgt = new int[M][2];
		comb(0,0);
		if(sec == Integer.MAX_VALUE) sec = -1;
		System.out.println(sec);
	}

	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx == M) {
			
//			for (int i = 0; i < M; i++) {
//				System.out.println(tgt[i][0] + " " + tgt[i][1]);
//			}
//			System.out.println();
			int ans = 0; // 이동 최댓값
			int cnt = 0; // 방문한 칸의 갯수
			int[][] copy_ar = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copy_ar[i][j] = ar[i][j];
					if(copy_ar[i][j] == 0) copy_ar[i][j] = -1; // 빈 공간을 0에서 -1로 변경(활성 바이러스를 0으로 표기하기 위함.)
					else if(copy_ar[i][j] == 1) copy_ar[i][j] = -2; // 벽을 1에서 -2로 변경
					else if(copy_ar[i][j] == 2) copy_ar[i][j] = -3; // 기존 바이러스 공간 : 2 -> -3
				}
			}
			
			// 빈 공간 : 0 -> -1
			// 벽 : 1 -> -2
			// 바이러스 : 2 -> 0
			for (int i = 0; i < tgt.length; i++) {
				q.offer(new int[] {tgt[i][0],tgt[i][1]});
				copy_ar[tgt[i][0]][tgt[i][1]] = 0;
			}
			while(!q.isEmpty()) {
				int[] n = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int ny = n[0]+dy[d];
					int nx = n[1]+dx[d];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N || copy_ar[ny][nx] == -2 || copy_ar[ny][nx] >= 0) continue;
					if(copy_ar[ny][nx] == -1)	cnt++;
					copy_ar[ny][nx] = copy_ar[n[0]][n[1]]+1;
					if(ar[ny][nx] != 2)	ans = Math.max(ans, copy_ar[ny][nx]);
					// if(ar[ny][nx] != 2)	ans = Math.max(ans, copy_ar[ny][nx]); 사용 이유
					/*
					 case 1: 마지막 초에 방문하는곳이 바이러스인 경우
					 비활성 바이러스는 이미 바이러스이며, 이 바이러스 이전 칸을 마지막으로 모든 칸의 바이러스가 완성되었다면, 이 비활성 바이러스 칸은 방문할 필요가 없다.
					 case 2: 중간에 비활성 바이러스를 방문했을 경우,
					 결국 이 비활성 바이러스 또한 활성 바이러스가 방문을 해야 활성 바이러스가 되기 때문에 초로 취급을 해야 함.
					 또한, 이 바이러스를 방문하는 것이 끝이 아니며 다음 빈칸을 방문해야 끝이 날 수 있기 때문에 방문을 이어나가야 함.
					 */
					if(cnt >= area) break;
					q.offer(new int[] {ny,nx});
				}
			}
			if(cnt >= area) {
				sec = Math.min(sec, ans);
//				System.out.println(ans);
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						System.out.print(copy_ar[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			return;
		}
		
		for (int i = srcIdx; i < input.size(); i++) {
			tgt[tgtIdx][0] = input.get(i)[0];
			tgt[tgtIdx][1] = input.get(i)[1];
			comb(i+1,tgtIdx+1);
		}
	}
}
