package prob_상어중학교_21609_220512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,M;
	static int group = 5;
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;
	static boolean[][] visit;
	static ArrayList<group> groupbox;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		do {
			stage1();
		}
		while(group>0);
		
		System.out.println(ans);
	}
	static void stage1() {
		group = 0;
		groupbox = new ArrayList<group>();
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(ar[i][j] > 0 && !visit[i][j]) { 
					bfs(i,j,ar[i][j]);
				}
			}
		} 
		if(group == 0) return;
		 stage2();
	}
	
	static void bfs(int i, int j,int num) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		int[] n = new int[] {i,j};
		visit[n[0]][n[1]] = true;
		for (int d = 0; d < 4; d++) {
			int ny = n[0] + dy[d];
			int nx = n[1] + dx[d];
			if(ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || ar[ny][nx] <= -1 || (ar[ny][nx] > 0 && ar[ny][nx] != num)) continue;
			visit[ny][nx] = true;
			q.offer(new int[] {ny,nx});
		}
		if(q.isEmpty()) return; 
		else { 
			groupbox.add(new group(i,j,num,0,new ArrayList<int[]>()));
			groupbox.get(groupbox.size()-1).block.add(new int[] {i,j});
			group++;
		}
		
		while(!q.isEmpty()) {
			int[] node = q.poll();

			groupbox.get(groupbox.size()-1).block.add(new int[] {node[0],node[1]});
			if(ar[node[0]][node[1]] == 0) {
				groupbox.get(groupbox.size()-1).rainbow+=1;
			}
			for (int d = 0; d < 4; d++) {
				int ny = node[0] + dy[d];
				int nx = node[1] + dx[d];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || ar[ny][nx] <= -1 || (ar[ny][nx] > 0 && ar[ny][nx] != num)) continue;
				visit[ny][nx] = true;
				q.offer(new int[] {ny,nx});
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int d = 0; d < N; d++) {
				if(ar[k][d] == 0) {
					visit[k][d] = false;
				}
			}
		}
		
	} 
	
	static void stage2() {
		Collections.sort(groupbox,new Comparator<group>() {
			@Override
			public int compare(group o1, group o2) {
				if(o1.block.size() > o2.block.size()) {
					return 1;
				}
				else if(o1.block.size() < o2.block.size()) {
					return -1;
				}
				else {  
					if(o1.rainbow > o2.rainbow) {
						return 1;
					}
					else  if(o1.rainbow < o2.rainbow){
						return -1;
					}
					else { 
						if(o1.y > o2.y) {
							return 1;
						}
						else if(o1.y < o2.y) {
							return -1;
						}
						else { 
							if(o1.x > o2.x) {
								return 1;
							}
							else {
								return -1;
							}
						}
					}
				}
			}
			
		});

		for (int[] is : groupbox.get(groupbox.size()-1).block) {
			ar[is[0]][is[1]] = -2;
		}
		ans += Math.pow(groupbox.get(groupbox.size()-1).block.size(), 2);
		
		stage3(true);
	}
	
	static void stage3(boolean tostage4) {
		for (int i = N-2; i >=0; i--) {
			for (int j = 0; j < N; j++) {
				if(ar[i][j] >=0) {
					int ni = i+1;
					if(ni > N-1 || ar[ni][j] >= -1) continue;
					while(ar[ni][j] == -2) {
							ni++;
							if(ni > N-1 || ar[ni][j] >= -1) {
								ni--;
								break;
							}
					}
					ar[ni][j] = ar[i][j];
					ar[i][j] = -2;
				}
			}
		}
		
		if(tostage4) {
			stage4();
		}
	}
	
	static void stage4() {
		int[][] copyar = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyar[j][i]=ar[i][N-1-j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ar[i][j] = copyar[i][j];
			}
		}
		
		stage3(false);
	}
	
	static class group {
		int y;
		int x; 
		int num; 
		int rainbow;
		ArrayList<int[]> block; 
		
		public group(int y, int x, int num, int rainbow, ArrayList<int[]> block) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.rainbow = rainbow;
			this.block = block;
		}
	}
}
