package prob_14052_연구소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,y,x,wallcount,tgtidx,safe;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<>();
	static int max = Integer.MIN_VALUE;
	static int[][] ar;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] wall; //조합론으로 접근해보자
	static int [][] tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		tgt = new int[3][2]; // 벽이 세워질 좌표를 저장
		ar = new int[y][x]; // 연구소 지정
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 0) {
					wallcount++;
				}
			}
		}
		wall = new int[wallcount][2]; //벽을 세울 수 있는 공간의 좌표를 저장.(wall : 세울 수 있는 // tgt : wall의 좌표들을 기준으로 벽이 세워질 수 있는)(wall을 input 또는 src 로 생각하면 됨)
		wallcount = 0; //배열 크기를 선언했으니 벽이 세워질 수 있는 자리를 정해주기 위해서 값을 초기화
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(ar[i][j] == 0) {
					wall[wallcount][0] = i;
					wall[wallcount][1] = j;
					wallcount++;
				}
			}
		}
		comb(0,0); // 세 곳에 벽을 놓고 bfs를 돌려야함.
		
		System.out.println(max);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 3) {
			visit = new boolean[y][x];
			for (int i = 0; i < 3; i++) {
				//벽 세우기
				ar[tgt[i][0]][tgt[i][1]] = 1;
			}
			bfs(); //벽을 세우고 바이러스를 퍼뜨리기
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if(ar[i][j] == 0 && !visit[i][j]) //바이러스가 될 조건 : 값이 2거나(or) visit값이 true인 경우 ==> 바이러스가 아닐 조건 : 벽이 아니고, ar값이 0이며, 방문하지 않은 경우
						safe++;
				}
			}
			max = Math.max(max, safe);
			safe = 0;
			for (int i = 0; i < 3; i++) {
				ar[tgt[i][0]][tgt[i][1]] = 0;
				//세웠던 벽 다시 허물기
			}
			return;
		}
		for (int i = srcIdx; i < wall.length; i++) {
			tgt[tgtIdx][0] = wall[i][0];
			tgt[tgtIdx][1] = wall[i][1]; // 벽을 세울 세 곳을 고름
			comb(i+1,tgtIdx+1);
		}
		
		
	}
	static void bfs() { // 바이러스 퍼뜨리기
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				//해당 위치에 바이러스가 있고, 주변에 퍼져나갈 구역이 있는 경우 bfs 시작
				if(ar[i][j] == 2) { //해당 구역에 바이러스가 위치해 있을 경우
					for (int k = 0; k < 4; k++) {
						if(i+dy[k] >= 0 && i + dy[k] < y && j +dx[k] >= 0 && j + dx[k] < x) { //벗어나면 안됨.
							if(ar[i+dy[k]][j+dx[k]] == 0) { //'퍼질 곳이 있으면' 본격적 bfs start
								
								q.offer(new int[] {i,j});
								visit[i][j] = true; // 해당 장소는 바이러스
								while(!q.isEmpty()) {
									int[] num = q.poll();
									for (int l = 0; l < 4; l++) {
										int ny = num[0]+dy[l];
										int nx = num[1]+dx[l];
										if(ny >= 0 && ny < y && nx >= 0 && nx < x) {
											if(ar[ny][nx] != 1 && !visit[ny][nx]) { 
												// 벽으로 가로막혀 있지 않고 나아갈 수 있으면
												visit[ny][nx] = true; //해당 장소는 바이러스가 퍼짐 ==> true 처리(바이러스가 되는 조건 : visit가 true이거나 ar값이 2일 때 바이러스가 됨.)
												q.offer(new int[] {ny,nx});
											}
										}
									}
								} //해당 조건 내에서 바이러스가 퍼지는 게 끝남.
								
							}
						}
					}
				}
			}
		}
	}
}
