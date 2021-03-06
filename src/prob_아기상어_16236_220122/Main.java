package prob_아기상어_16236_220122;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt,time; // cnt : 먹을 수 있는 물고기의 마릿수 , time : 물고기를 먹는 데 걸리는 시간
	static int[][] ar;
	static ArrayList<fish> fishList = new ArrayList<fish>();
	static Shark shark;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 0 : 빈 공간
		 9 : 아기 상어의 위치
		 - 아기 상어의 초기 크기 : 2(처음엔 크기 1의 물고기만 먹을 수 있음)
		 1~6 : 물고기의 크기
		 - 아기상어 크기 > 물고기 크기 인 물고기만 먹을 수 있음
		 - 아기상어 크기 = 물고기 크기 인 물고기가 있는 칸은 지나갈 순 있지만 물고기를 먹을 순 없음
		 - 아기상어 크기 < 물고기 크기 인 물고기가 있는 위치는 지나갈 수 없음
		 - 먹을 수 있는 물고기가 있는 칸으로 이동하자마자 물고기를 섭취함
		 - 아기상어의 크기 만큼의 물고기를 먹으면 상어가 커짐(ex. 아기 상어의 크기가 5인 경우, 물고기 5마리를 먹으면 크기가 6으로 성장)
		 
		 
		 - 공간에 더이상 먹을 수 있는 물고기가 없으면 엄마를 부름
		 (아기 상어의 초기 크기는 2. => 공간에 물고기가 아예 없거나, 남은 모든 물고기가 아기 상어보다 클 경우 끝남)
		 - 공간에 먹을 수 있는 물고기가 여러마리일 경우 => 거리가 가장 가까운 물고기를 먹으러 감
		 - 가장 가까운 물고기가 여러마리일 경우 -> 가장 위에 있는 물고기
		 -- 가장 위에 있는 물고기가 여러마리일 경우 -> 가장 왼쪽에 있는 물고기
		 */
		
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
		} // 입력 끝
		
		System.out.println(game());
		
		
		
	
	}
	
	static int game() {
		while(true) {
			//1. 먹을 수 있는 물고기가 공간에 존재하는지 파악해야 함.
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if(ar[i][j] > 0 && ar[i][j] <= 6 && ar[i][j] < shark.level) {
//						fishList.add(new fish(i,j,0));
//					}
//				}
//			}
			// 현재 상어의 위치를 기준으로 bfs를 돌려서 먹을 수 있는 물고기들의 위치를 구하기!
			bfs();
//			System.out.println(fishList.size());
			for (int i = 0; i < fishList.size(); i++) {
//				System.out.println(fishList.get(i).y + " " + fishList.get(i).x);
			}
			//1-1. 먹을 수 있는 물고기가 없으면 게임 끝.
			
			if(fishList.size() == 0) break;
			
			// 2. 먹을 수 있는 물고기가 있을 경우
			// 2-1. 물고기가 1마리인 경우
			else if(fishList.size() == 1) {
				eat(0);
			}
			// 2-2. 물고기가 여러마리인 경우
			else if(fishList.size() >= 2) {
				// 먹을 때마다 거리 정보를 갱신해야 함 (최적의 위치에 있는 한마리를 먹으면, 그곳에서 또한번 최적의 위치에 있는 먹이를 찾아야 함.
					int min = Integer.MAX_VALUE; // 거리의 최솟값
					int mincount = 0;
						// 가장 가까운 녀석을 먹어야 함!
					for (fish f : fishList) {
//						f.dist = Math.abs(shark.y - f.y) + Math.abs(shark.x - f.x);
//						min = Math.min(min, f.dist);
						if(min > f.eatdist) {
							min = f.eatdist;
							mincount = 1;
						}
						else if(min == f.eatdist) mincount++;
					}
					//1. 가장 가까운 녀석
					// fish 에 있는 물고기와 상어의 거리를 잰다
					// 최솟값을 가지는 물고기가 한마리만 있으면 그 물고기를 먹고 다시 계산
					if(mincount == 1) { // 최소 거리를 가지는 물고기가 한마리만 있음
						for (int i = 0; i < fishList.size(); i++) { // 인덱싱이 필요하니 for문 사용
							if(fishList.get(i).eatdist == min) { // 최소 거리 물고기를 찾았다면
								eat(i); // 해당 물고기를 먹어치움
								break;
							}
						}
					}
					else if(mincount >= 2) {
						int upcnt = 0;
						int upmin = Integer.MAX_VALUE; // 2순위 : 가장 위에 있는 물고기
						int leftmin = Integer.MAX_VALUE; // 3순위 : 가장 왼쪽에 있는 물고기
						//2. 가장 위에 있는 녀석
						// 다 돌려서 최소 거리를 가지는 녀석들 중 가장 위에 있는 녀석을 찾아서 그녀석을 먹어치움
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
							//3. 가장 왼쪽에 있는 녀석
							// 마지막으로 다 돌려서 최소 거리를 가지고 가장 높이 있는 녀석들 중 가장 왼쪽에 있는 녀석을 찾아서 먹어치움
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
			
			// 먹을 수 있는 물고기를 다 먹은 후에는 fish arrayList가 비어있어야 함.
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
				if(ar[ny][nx] > 0 && ar[ny][nx] < shark.level) { //먹을 수 있는 물고기인 경우,이 물고기를 먹는 데 필요한 값 : 물고기 위치(y,x), 이 물고기를 먹는 데 이동해야 할 거리
//					System.out.println("물고기");
					fishList.add(new fish(ny,nx,0,a[2]+1));
				}
//				System.out.println(ny + " " + nx);
				visit[ny][nx] = true;
				queue.offer(new int[] {ny,nx,a[2]+1});
			}
		}
	}
	
	static void eat(int n) { //먹을 물고기가 있는 ArrayList 위치
		time += fishList.get(n).eatdist;
//		Math.abs(shark.y - fishList.get(n).y) + Math.abs(shark.x - fishList.get(n).x);
//		System.out.println(time);
		ar[shark.y][shark.x] = 0;
//		System.out.println(fishList.get(n).y + " " + fishList.get(n).x);
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
		int eatcount; // 이 물고기를 먹기 위해 이동해야 하는 거리
		
		public Shark(int y, int x, int level, int eatcount) {
			super();
			this.y = y;
			this.x = x;
			this.level = level;
			this.eatcount = eatcount;
		}
	}
	
 static class fish { //y,x 거리 정보를 가짐
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
