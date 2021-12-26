package prob_구슬탈출1_13459;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,min = Integer.MAX_VALUE,nomovecount,movecount,bluecount;
	static char[][] ar;
	static Balls balls = new Balls();
	static Queue<Balls> queue = new LinkedList<Balls>();
	static boolean redMove,blueMove,redarrive,bluearrive;
	static boolean [][][][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][N][M];
		ar = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			ar[i] = str;
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 'R') {
					balls.red_y = i;
					balls.red_x = j;
				} else if(ar[i][j] == 'B') {
					balls.blue_y = i;
					balls.blue_x = j;
				}
			}
		}
		bfs(balls);
		
		//1. 판을 돌리는 방향을 정함(0 : 위, 1 : 왼쪽, 2: 아래 , 3 : 오른쪽)
		//2. 판을 돌릴 떄마다 배열의 모양은 변함.
		//3. 돌리다가 파란 공이 들어가면 x , 빨간 구슬이 들어가면 끝(이후 이동 횟수 출력), 동시에 빠져도 실패
		//4. 더이상 구슬이 움직이지 않으면 그만둠.(4가지 방향으로 이동을 시도했을 때, 배열의 변화가 없으면 해당 방법은 X)
	}
	
	static void bfs(Balls ball) { 
		//bfs가 저장해야 할 정보 : red의 초기 위치, blue의 초기 위치,생성된 tgt(이는 tgt가 완성될 때마다 새로 돌리기 때문에 parameter로 저장할 필요는 없음)
		//기울이는 과정 중 어느 구슬도 움직이지 않으면 해당 배열로의 배열 돌리기는 과감하게 생략 가능.
		//구슬은 동시에 굴러가야 함! ==> 기울인 방향으로만 움직이고 끝이므로, 이동한 결과를 저장하는 큐를 생성해보자.
		
		//1. 바로 앞에 다른 구슬이 있는 경우(앞의 구슬부터 먼저 이동시키고 이동)
		//2. 굴리다가 앞에 다른 구슬을 맞닥뜨리는 경우 (앞의 구슬부터 먼저 이동시키고 이동)
		//둘 다 끝까지 굴렀는데, 둘 다 구른 결과 구멍에 들어가서도 안된다.
		// 끝까지 둘 다 구른 끝에 파란 구슬은 나와있고 빨간 구슬이 들어가 있으면 가능.
		
		//(11.07) 
		//1회 이동에 네 방향으로 쭉 이동할 때, 빨간 구슬이 들어가고 파란 구슬이 안들어간 부분이 한번이라도 있으면 끝(1)
		//4번의 방향을 모두 돌렸을 때 파란 구슬이 들어가는 경우만 있고 빨간 구슬 혼자 들어가는 경우가 없으면 continue.
		//4번의 이동이 끝난 후 수행된 모든 이동에서 파란 구슬이 들어가는 이동만 있으면 0 출력
		queue.offer(ball);
		while(!queue.isEmpty()) {
			Balls balls = queue.poll();
			
			nomovecount = 0; // 아무데도 이동하지 못한 경우 카운트 지정
			movecount = 0; // 이동이 진행된 경우의 카운트 지정
			bluecount = 0; // 블루가 들어간 경우 카운트 지정
			for (int i = 0; i < 4; i++) {
				
				int red_ny = balls.red_y + dy[i];
				int red_nx = balls.red_x + dx[i];
				int blue_ny = balls.blue_y + dy[i];
				int blue_nx = balls.blue_x + dx[i];
				
//				System.out.println(balls.red_y + " " + balls.red_x + " " + balls.blue_y + " " + balls.blue_x);
				if(red_ny < 0 || red_ny >= N || red_nx < 0 || red_nx >= M) continue;// 최소한의 이동이 가능한지 체크
				if(blue_ny < 0 || blue_ny >= N || blue_nx < 0 || blue_nx >= M) continue;
				movecount++;
				if(balls.depth < 10 && ar[red_ny][red_nx] == 'O') {
					System.out.println(1);
					return;
				} else if(balls.depth < 10 && ar[blue_ny][blue_nx] == 'O') { // 파란 공이 먼저 들어가면 안됨
					bluecount++;
					continue;
				}
				redMove = false;
				blueMove = false;
				
				if(ar[red_ny][red_nx] != '#') { //벽이 없으면
					if(ar[red_ny][red_nx] == 'B') {//바로 앞에 blue가 있으면
						if(ar[blue_ny][blue_nx] != '#') {
							blueMove = true;
							
							ar[balls.blue_y][balls.blue_x] = '.';
							while(ar[blue_ny][blue_nx] != '#') {
								blue_ny = blue_ny + dy[i];
								blue_nx = blue_nx + dx[i];
								if(balls.depth < 10 && ar[blue_ny][blue_nx] == 'O') { // 파란 공이 먼저 들어가면 안됨
									bluearrive = true;
									bluecount++;
									break;
								}
							}
							if(bluearrive) {
								bluearrive = false;
								continue;
							}
							blue_ny = blue_ny-dy[i];
							blue_nx = blue_nx-dx[i];
							ar[blue_ny][blue_nx] = 'B';
						}
					}
					else if(ar[red_ny][red_nx] != 'B') { //벽이 없고(위에서 조건 제시) 바로 앞에 푸른 구슬이 없으면
						redMove = true;
						ar[balls.red_y][balls.red_x] = '.';
						while(true) { //이동하다가 벽을 만나거나 푸른 구슬을 만날 경우 종료
							if(ar[red_ny][red_nx] == '#' || ar[red_ny][red_nx] == 'B') {
								red_ny = red_ny-dy[i];
								red_nx = red_nx-dx[i];
								ar[red_ny][red_nx] = 'R';
								break;
							}
								
							red_ny = red_ny + dy[i];
							red_nx = red_nx + dx[i];
//							System.out.println();
//							System.out.println(red_ny + " " + red_nx);
							if(balls.depth < 10 && ar[red_ny][red_nx] == 'O') {
								redarrive = true;
								break;
							}
							if(ar[red_ny][red_nx] == 'B') { // 빨간 구슬이 이동 중에 파란 구슬을 만난 경우
								if(ar[blue_ny][blue_nx] != '#' && !blueMove) { // 푸른 구슬이 아직 이동 가능한 경우
									blueMove = true;
									ar[balls.blue_y][balls.blue_x] = '.';
									while(ar[blue_ny][blue_nx] != '#') {
										blue_ny = blue_ny + dy[i];
										blue_nx = blue_nx + dx[i];
										if(balls.depth < 10 && ar[blue_ny][blue_nx] == 'O') { // 파란 공이 먼저 들어가면 안됨
											bluearrive = true;
											bluecount++;
											break;
										}
									}
									if(bluearrive) {
										bluearrive = false;
										continue;
									}
									blue_ny = blue_ny-dy[i];
									blue_nx = blue_nx-dx[i];
									ar[blue_ny][blue_nx] = 'B';
								}
							}
						}
					}
				}
				if(!blueMove) {
					if(ar[blue_ny][blue_nx] != '#') {
						blueMove = true;
						ar[balls.blue_y][balls.blue_x] = '.';
						while(ar[blue_ny][blue_nx] != '#' && ar[blue_ny][blue_nx] != 'R') {
							blue_ny = blue_ny + dy[i];
							blue_nx = blue_nx + dx[i];
							if(balls.depth < 10 && ar[blue_ny][blue_nx] == 'O') { // 파란 공이 먼저 들어가면 안됨
								bluearrive = true;
								bluecount++;
								break;
							}
						}
						if(bluearrive) {
							bluearrive = false;
							continue;
						}
						blue_ny = blue_ny-dy[i];
						blue_nx = blue_nx-dx[i];
						ar[blue_ny][blue_nx] = 'B';
					}
				}
				if(visited[red_ny][red_nx][blue_ny][blue_nx]) continue;
				visited[red_ny][red_nx][blue_ny][blue_nx] = true;
				
				if(movecount == bluecount) {
					System.out.println(0);
					return;
				}
				//해당 이동이 다 끝났으면
				if(redarrive && !bluearrive) {
					System.out.println(1);
					return;
				}
				if(balls.depth < 10) {
					if(!blueMove && !redMove) { // 두 공 모두 이동하지 못한 경우
						queue.offer(new Balls(balls.red_y,balls.red_x,balls.blue_y,balls.blue_x,balls.depth+1));
						nomovecount++;
						if(nomovecount == 4) { // 네 방향 모두 어디로도 이동하지 못한 경우라면
							System.out.println(0);
							return;
						}
					} else {
						if(blueMove && !redMove) { // 빨간 공 이동 x, 파란 공 이동 O
							queue.offer(new Balls(balls.red_y,balls.red_x,blue_ny,blue_nx, balls.depth+1));
						} 
						else if(!blueMove && redMove) { // 빨간 공 이동 O, 파란 공 이동 x
							queue.offer(new Balls(red_ny,red_nx,balls.blue_y,balls.blue_x, balls.depth+1));
						}
						else if(blueMove && redMove) { // 두 공 모두 이동
							queue.offer(new Balls(red_ny,red_nx,blue_ny,blue_nx, balls.depth+1));
						}
					}
				}
				movecount++;
			}
		}
		System.out.println(0);
	}
	static class Balls { //두 공의 위치 정보를 가지는 클래스(두 공이 동시에 이동해야 하기 때문에) 
		int red_y;
		int red_x;
		int blue_y;
		int blue_x;
		int depth;
		
		public Balls() {}
		public Balls(int red_y,int red_x, int blue_y,int blue_x,int depth) {
			this.red_y = red_y;
			this.red_x = red_x;
			this.blue_y = blue_y;
			this.blue_x = blue_x;
			this.depth = depth;
		}
	}
}