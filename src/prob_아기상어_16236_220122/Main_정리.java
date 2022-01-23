package prob_아기상어_16236_220122;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,cnt,time;
	static int[][] ar;
	static ArrayList<fish> fishList = new ArrayList<fish>();
	static Shark shark;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 9) {
					shark = new Shark(i,j,2,0);
				}
			}
		}
		System.out.println(game());
	}
	
	static int game() {
		while(true) {
			bfs();
			if(fishList.size() == 0) break;
			else if(fishList.size() == 1) {
				eat(0);
			}
			else if(fishList.size() >= 2) {
					int min = Integer.MAX_VALUE;
					int mincount = 0;
					for (fish f : fishList) {
						if(min > f.eatdist) {
							min = f.eatdist;
							mincount = 1;
						}
						else if(min == f.eatdist) mincount++;
					}
					if(mincount == 1) {
						for (int i = 0; i < fishList.size(); i++) {
							if(fishList.get(i).eatdist == min) {
								eat(i);
								break;
							}
						}
					}
					else if(mincount >= 2) {
						int upcnt = 0;
						int upmin = Integer.MAX_VALUE;
						int leftmin = Integer.MAX_VALUE;
						for (int i = 0; i < fishList.size(); i++) {
							if(fishList.get(i).eatdist == min) {
								if(fishList.get(i).y == upmin) {
									upcnt++;
								}else if(fishList.get(i).y < upmin){
									upmin = fishList.get(i).y;
									upcnt = 1;
								}
							}
						}
						if(upcnt == 1) {
							for (int i = 0; i < fishList.size(); i++) {
								if(fishList.get(i).eatdist == min && fishList.get(i).y == upmin) {
									eat(i);
									break;
								}
							}
						}
						else if(upcnt >= 2) {
							for (int i = 0; i < fishList.size(); i++) {
								if(fishList.get(i).eatdist == min && fishList.get(i).y == upmin) {
									leftmin = Math.min(leftmin, fishList.get(i).x);
								}
							}
							for (int i = 0; i < fishList.size(); i++) {
								if(fishList.get(i).eatdist == min && fishList.get(i).y == upmin && fishList.get(i).x == leftmin) {
									eat(i);
									break;
								}
							}
						}
						
					}
			}
		}
		return time;
	}
	
	static void bfs() {
		visit = new boolean[N][N];
		visit[shark.y][shark.x] = true;
		queue.offer(new int[] {shark.y,shark.x,0});
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = a[0] + dy[i];
				int nx = a[1] + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || shark.level < ar[ny][nx]) continue;
				if(ar[ny][nx] > 0 && ar[ny][nx] < shark.level) {
					fishList.add(new fish(ny,nx,0,a[2]+1));
				}
				visit[ny][nx] = true;
				queue.offer(new int[] {ny,nx,a[2]+1});
			}
		}
	}
	
	static void eat(int n) {
		time += fishList.get(n).eatdist;
		ar[shark.y][shark.x] = 0;
		shark.y = fishList.get(n).y;
		shark.x = fishList.get(n).x;
		ar[shark.y][shark.x] = 9;
		fishList.remove(n);
		fishList.clear();
		shark.eatcount++;
		if(shark.eatcount == shark.level) {
			shark.level++;
			shark.eatcount = 0;
		}
	}
	static class Shark {
		int y;
		int x;
		int level;
		int eatcount;
		
		public Shark(int y, int x, int level, int eatcount) {
			super();
			this.y = y;
			this.x = x;
			this.level = level;
			this.eatcount = eatcount;
		}
	}
 static class fish {
	 int y;
	 int x;
	 int dist;
	 int eatdist;
	public fish(int y, int x, int dist,int eatdist) {
		super();
		this.y = y;
		this.x = x;
		this.dist = dist;
		this.eatdist = eatdist;
	}
 }
}