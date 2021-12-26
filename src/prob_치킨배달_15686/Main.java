package prob_치킨배달_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int sum,ans = Integer.MAX_VALUE;
	static Queue<int[]> queue;
	static int[] dy = {-1,1,0,0}; 
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static ArrayList<int[]> chicken = new ArrayList<int[]>();
	static int[][] combarray;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N+1][N+1];
		combarray = new int[M][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 2) {
					chicken.add(new int[] {i,j});
					ar[i][j] = 0;
				}
			}
		}
		comb(0,0);
		System.out.println(ans);
	}
	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				ar[combarray[i][0]][combarray[i][1]] = 2;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(ar[i][j] == 1) {
						bfs(i,j);
					}
				}
			}
			for (int i = 0; i < M; i++) {
				ar[combarray[i][0]][combarray[i][1]] = 0;
			}
			ans = Math.min(ans, sum);
			sum = 0;
			return;
		}
		for (int i = srcIdx; i < chicken.size(); i++) {
			combarray[tgtIdx][0] = chicken.get(i)[0];
			combarray[tgtIdx][1] = chicken.get(i)[1];
			comb(i+1,tgtIdx+1);
		}
	}
	static void bfs(int y,int x) {
		int min = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[N+1][N+1];
		visit[y][x] = true;
		queue = new LinkedList<int[]>();
		queue.offer(new int[] {y,x});
		while(!queue.isEmpty()) {
			int[] num = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = num[0] + dy[i];
				int nx = num[1] + dx[i];
				if(ny <= 0 || ny > N || nx <= 0 || nx > N || visit[ny][nx]) continue;
				visit[ny][nx] = true;
				if(ar[ny][nx] == 2) {
					int dist = Math.abs(ny-y) + Math.abs(nx -x);
					min = Math.min(min, dist);
				}
				queue.offer(new int[] {ny,nx});
			}
		}
		sum+= min;
	}
}
