package prob_연구소2_17141_220704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] ar;
	static int N,M;
	static int ans = Integer.MAX_VALUE,area;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<int[]> input = new ArrayList<int[]>();
	static int[][] tgt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[N][N];
		tgt = new int[M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] != 1) {
					if(ar[i][j] == 2)	input.add(new int[] {i,j});
					area++;
				}
			}
		}
		comb(0,0);
		if(M == area) ans = 0;
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == M) {
			Queue<int[]> q = new LinkedList<int[]>();
			int[][] copy_ar = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(ar[i][j] == 0 || ar[i][j] == 2) {
						copy_ar[i][j] = -1; // 바이러스 시작점을 일단 빈칸 취급
					}
					else if(ar[i][j] == 1) {
						copy_ar[i][j] = -2;
					}
				}
			}
			int max = 0;
			int cnt = 0; // 만난 공간의 개수
			for (int i = 0; i < tgt.length; i++) {
				copy_ar[tgt[i][0]][tgt[i][1]] = 0;
				cnt++;
				q.offer(new int[] {tgt[i][0],tgt[i][1]});
			}
			
			while(!q.isEmpty()) {
				int[] n = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = n[0]+dy[d];
					int nx = n[1]+dx[d];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= N || copy_ar[ny][nx] != -1) continue; 
					// -1 : 빈 공간 혹은 비활성 바이러스 공간, -2 : 벽 , 0~ : 방문한 바이러스 공간
					copy_ar[ny][nx] = copy_ar[n[0]][n[1]]+1;
					max = Math.max(max, copy_ar[ny][nx]);
					cnt++;
					if(cnt == area) {
						ans = Math.min(ans, max);
						break;
					}
					q.offer(new int[] {ny,nx});
				}
			}
			return;
		}
		
		for (int i = srcIdx; i < input.size(); i++) {
			tgt[tgtIdx][0] = input.get(i)[0];
			tgt[tgtIdx][1] = input.get(i)[1];
			comb(i+1, tgtIdx+1);
		}
	}
}
