package Prob_17135_캐슬디팬스_아직못품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M,D,cnt,maxCnt = Integer.MIN_VALUE;
	static int[][] ar;
	static int[] tgt;
	static int[][] enemy;
	static int[] dy = {0,-1,0}; //궁수가 아랫쪽을 보는 전개는 존재하지 않음.
	static int[] dx = {-1,0,1};
	static Stack<archer> queue = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		ar = new int[N][M];
		tgt = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(maxCnt);
	}
 
	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx == 3) {
			// 궁수의 위치를 정하면 ar[-1] 쪽에 궁수가 위치해있다고 가정하고 모든 적이 내려올때까지 공격을 진행
			// 궁수로부터 D만큼의 거리 영역을 BFS로 탐색하며 적이 있으면(1) 사살(0으로 만듬)
//			System.out.println(Arrays.toString(tgt));
			bfs(tgt);
			return;
		}
		
		for (int i = srcIdx; i < M; i++) {
			tgt[tgtIdx] = i;
			comb(i+1,tgtIdx+1);
		}
	}
	
	static void bfs(int[] tgt) {
		cnt = 0;
		enemy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 1) enemy[i][j] = 1; // 0 : 아무것도 없음 , 1 : 적이 있음, 2 : 적이 있었는데 잡힘
			}
		}
		for (int t = N; t > 0 ; t--) { //적이 내려오는 방향은 배열 복사를 해야 하므로, 반대로 궁수가 검사하는 칸을 올라가는 방향으로 활용
			for (int i = 0; i < tgt.length; i++) {
				queue.push(new archer(t,tgt[i],0)); //궁사의 위치 : [t][tgt[i]]
			}
			
			
			while(!queue.isEmpty()) {
				archer a = queue.pop();
//				System.out.println(a.y + " " + a.x +" " + a.d);
				//한턴당 최대 3마리의 적을 잡을 수 있다 가정
				// 정해진 범위(D) 만큼만 이동
				if(a.d == D) continue; // 이동 다했으면 해당 궁수는 사용 끝
				if(a.d == 0) { // 처음 궁수를 조작할 땐 윗칸으로 올라가는 방향만 사용해야 함.
					int ny = a.y + dy[1];
					int nx = a.x + dx[1];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M ) continue;
					if(enemy[ny][nx] != 0) { // 적이 있으면(여러 궁수가 같은 적을 노릴 수 있음)
//						System.out.println(a.y + " " + a.x +" " + a.d);
//						System.out.println(ny + " " + nx);
						if(enemy[ny][nx] == 1) {
//							System.out.println("잡았다 " + ny + " " + nx);
							enemy[ny][nx] = 2; // 적이 있었는데 잡았다는 뜻
						}
						continue; // 적을 잡았으니 더이상 쓸 필요 없음.
					}
					queue.push(new archer(ny,nx,a.d+1)); // 궁수의 위치를 이동시킴
				}
				else if(a.d > 0) {
					for (int i = 0; i < 3; i++) {
						int ny = a.y + dy[i];
						int nx = a.x + dx[i];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M ) continue;
						if(enemy[ny][nx] != 0) {
							if(enemy[ny][nx] == 1) {
//								System.out.println("잡았다 " + ny + " " + nx);
								enemy[ny][nx] = 2; // 적이 있었는데 잡겠다는 뜻(여러 궁수가 같은 적을 노릴 수도 있음)
							}
							break; // 적을 잡았으니 더이상 쓸 필요 없음.
						}
						queue.push(new archer(ny,nx,a.d+1)); // 궁수의 위치를 이동시킴
					}
				}
			} 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(enemy[i][j] ==2) {
						enemy[i][j] = 0; // 목표로 지정된 적을 사살(적이 사라짐)
						cnt++;
					}
				}
			}
		} // 방어가 끝났으면 잡은 적 수를 출력
//		System.out.println(cnt);
		maxCnt = Math.max(maxCnt, cnt);
	}

	static class archer {
		int y;
		int x;
		int d;
		public archer(int y, int x, int d) {	
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

	}
}
