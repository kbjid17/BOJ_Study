package prob_연구소3_17142_220703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {
	static ArrayList<int[]> input = new ArrayList<int[]>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M;
	static int[][] ar;
	static int[][] tgt;
	static int area;
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
			int ans = 0;
			int cnt = 0;
			int[][] copy_ar = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copy_ar[i][j] = ar[i][j];
					if(copy_ar[i][j] == 0) copy_ar[i][j] = -1;
					else if(copy_ar[i][j] == 1) copy_ar[i][j] = -2;
					else if(copy_ar[i][j] == 2) copy_ar[i][j] = -3;
				}
			}
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
					if(cnt >= area) break;
					q.offer(new int[] {ny,nx});
				}
			}
			if(cnt >= area) {
				sec = Math.min(sec, ans);
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
