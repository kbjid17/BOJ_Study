package prob_상어중학교_21609_220512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
		
		/*
		 문재 해결 고찰
		 1. 블록 그룹 찾기
		 - 블록 그룹 : 일반 블록이 적어도 하나 이상 존재해야 함, 검은 블록은 X, 무지개 블록은 상관 x, 블록 그룹의 크기는 2 이상, 인접한 칸으로 이동해 그룹 내 어디로든 이동 가능, 가장 위 & 왼쪽의 블록이 기준 블록
		 - 크기가 가장 큰 블록 그룹 -> 무지개 블록 수가 가장 많은 블록 그룹 -> 기준 블록의 행이 가장 큰 블록 그룹 -> 기준 블록의 열이 가장 큰 블록 그룹 순으로 탐색
		 - 블록 그룹이 없으면 게임을 진행할 수 없음
		 */
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// -1 : 검은색 블록, 0 : 무지개 블록, 1~M : 단색 블록 ++ -2 : 빈 공간
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		do {
			//1. 그룹 블록들 중 가장 큰 블록 그룹을 결정
			stage1();
		}
		while(group>0); // 적어도 1번은 돌리고, 이후 정의된 group이 아무것도 나오지 않으면 그만두기
		
		System.out.println(ans);
	}
	static void stage1() {
		group = 0;
		groupbox = new ArrayList<group>();
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(ar[i][j] > 0 && !visit[i][j]) { // 색깔 블록이다 -> 탐색 시작(++ 왼쪽 위~ 오른쪽 아래로 탐색하며 그룹을 만듦 -> 처음 발견한 블록이 기준 블록이 됨.
					bfs(i,j,ar[i][j]);
				}
			}
		} // 베열 전체를 돌면서 그룹 생성을 완료했다면, 게임을 진행할 블록을 찾음
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
		if(q.isEmpty()) return; // 근처에 블록이 없어 그룹이 될 수 없음
		else { // 그룹을 만들 수 있으면 그룹을 선언함.
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
		
	} // 그룹 생성 완료
	
	static void stage2() {
		//1. 크기가 가장 큰 블록을 찾음
		Collections.sort(groupbox,new Comparator<group>() {
			@Override
			public int compare(group o1, group o2) {
				if(o1.block.size() > o2.block.size()) {
					return 1;
				}
				else if(o1.block.size() < o2.block.size()) {
					return -1;
				}
				else { //블록의 크기가 같은 경우가 여러개인 경우 -> 
					
					if(o1.rainbow > o2.rainbow) {
						return 1;
					}
					else  if(o1.rainbow < o2.rainbow){
						return -1;
					}
					else { // 무지개 블록의 수가 같다면 -> 행(y)이 가장 큰 것을 
						
						if(o1.y > o2.y) {
							return 1;
						}
						else if(o1.y < o2.y) {
							return -1;
						}
						else { // 행이 같다면 -> 열(x)이 가장 큰 것을
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

		//2. 1 과정에서 찾은 블록 그룹의 모든 블록을 제거
		for (int[] is : groupbox.get(groupbox.size()-1).block) {
			ar[is[0]][is[1]] = -2;
		}
		//2-1. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B^2점을 얻음
		ans += Math.pow(groupbox.get(groupbox.size()-1).block.size(), 2);
		
		stage3(true);
	}
	
	static void stage3(boolean tostage4) {
		//격자에 중력 적용 -> -1 블록을 제외한 모든 블록을 맨 아래로 내림
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(ar[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
//		System.out.println();
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
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(ar[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		if(tostage4) {
			stage4();
		}
	}
	
	static void stage4() {
		// 배열을 반시계 90도 돌린 후 그 상태에서 stage3을 진행
		int[][] copyar = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyar[j][i]=ar[i][N-1-j];
			}
		}
//		System.out.println("배열");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(copyar[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ar[i][j] = copyar[i][j];
			}
		}
		
		stage3(false);
	}
	
	static class group {
		int y;
		int x; // 기준 블록의 y,x좌표
		int num; // 기준 블록의 번호
		int rainbow;
		ArrayList<int[]> block; // 블록들의 정보를 기록해놓는 배열(블록의 수 : block.size())
		
		public group(int y, int x, int num, int rainbow, ArrayList<int[]> block) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.rainbow = rainbow;
			this.block = block;
		}

		@Override
		public String toString() {
			
			
			return "group [y=" + y + ", x=" + x + ", num=" + num + ", rainbow=" + rainbow + ", block=" + block + ", blocksize : " + block.size() + "]";
		}
	}
}
