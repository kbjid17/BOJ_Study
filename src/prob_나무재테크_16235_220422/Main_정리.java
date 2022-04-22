package prob_나무재테크_16235_220422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,M,K;
	static int[][] ar,area;
	static int ans;
	static int[] dy = {-1,-1,-1, 0,0, 1,1,1};
	static int[] dx = {-1,0,1, -1,1, -1,0,1};
	static ArrayList<tree>[][] tr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ar = new int[N+1][N+1]; // 매 겨울마다 더해질 양분값을 저장
		area = new int[N+1][N+1]; // 땅
		tr = new ArrayList[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken()); 
				area[i][j] = 5;
				tr[i][j] = new ArrayList<tree>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); 
			int z = Integer.parseInt(st.nextToken()); 
			tr[x][y].add(new tree(z,false));

		}
		
		for (int t = 0; t < K; t++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Collections.sort(tr[i][j]);

				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int d = 0; d < tr[i][j].size(); d++) {
						if(area[i][j] >= tr[i][j].get(d).age) {
							area[i][j] -= tr[i][j].get(d).age;
							tr[i][j].get(d).age +=1;
						}
						else {
							tr[i][j].get(d).dead = true;
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int d = 0; d < tr[i][j].size(); d++) {
						if(tr[i][j].get(d).dead) {
							area[i][j] += (tr[i][j].get(d).age/2);
							tr[i][j].remove(d);
							d--;
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int d = 0; d < tr[i][j].size(); d++) {
						if(tr[i][j].get(d).age % 5 == 0 && tr[i][j].get(d).age > 0) {
							for (int f = 0; f < 8; f++) {
								int ny = i+dy[f];
								int nx = j+dx[f];
								if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
								tr[ny][nx].add(new tree(1,false));
							}
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					area[i][j] += ar[i][j];
				}
			}
			
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += tr[i][j].size();
			}
		}
		System.out.println(ans);
	}

	static class tree  implements Comparable<tree>{
		int age;
		boolean dead;
		public tree(int age, boolean dead) {
			super();
			this.age = age;
			this.dead = dead;
		}
		
		@Override
		public int compareTo(tree t) {
			if(t.age < age) {
				return 1;
			}
			else if(t.age > age) {
				return -1;
			}
			return 0;
		}
	}
}