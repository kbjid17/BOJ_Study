package prob_캐슬디팬스_17135_아직못품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2th {
	static int N,M,D,cnt,maxCnt = Integer.MIN_VALUE;
	static int[] tgt; //궁수의 x 위치를 정함
	static int[] dy = {0,-1,0}; 
	static int[] dx = {-1,0,1}; // 적은 왼쪽에 있는 적부터 잡게 됨.
	//이동은 왼쪽,윗쪽,오른쪽으로 이동 가능하며, 왼쪽에 있는 적을 가장 우선적으로 잡음
	static int[][] ar;
	static Stack<archer> stack = new Stack<archer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tgt = new int[3];
		// 궁수의 위치가 될 수 있는 모든 경우를 구함
		comb(0,0);
		
		System.out.println(maxCnt);
	}
	static void comb(int tgtIdx,int srcIdx) {
		if(tgtIdx == 3) { // 궁수는 3명 고정이므로
			//궁수의 위치가 다 정해짐
			//문제에는 적이 내려온다는 전개가 되어 있지만, 그 경우 배열을 복사해야 함.(ex. 15*15 배열의 경우 15번 내려오므로 15*15 배열을 15개 만들어야 함.
			// 반대로 궁수가 올라가는 전개를 사용하면 검사에 큰 문제가 발생하지도 않을 뿐더러 배열을 복사할 필요도 없어진다.
			// 고로 궁수가 올라가는 전개를 사용한다.
			// 그리고 한 궁수가 끝까지 올라가서 적을 겨냥하는 전개가 필요하므로 dfs를 사용해서 어느 적을 잡을지 타겟팅을 진행한다.
//			System.out.println(Arrays.toString(tgt));
			dfs(tgt);
			return;
		}
		
		for (int i = srcIdx; i < M; i++) {
			tgt[tgtIdx] = i;
			comb(tgtIdx+1,i+1);
		}
	}
	
	static void dfs(int[] tgt) {
		cnt = 0;
		for (int t = N; t > 0; t--) {
			for (int i = 0; i < tgt.length; i++) {
				stack.push(new archer(t,tgt[i],0)); // 궁수의 처음 위치는 [N][tgt[i]]이고 이동 횟수는 0
			}
			
			while(!stack.isEmpty()) {
				archer a = stack.pop();
				
				if(a.d >= D) continue;
				if(a.d == 0) {
					int ny = a.y + dy[1];
					int nx = a.x + dx[1];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if(ar[ny][nx] != 0) {
						if(ar[ny][nx] == 1) {
							ar[ny][nx] = 2;
						}
						continue;
					}
					stack.push(new archer(ny,nx,a.d+1));
				}
				else if(a.d > 0) {
					for (int i = 0; i < 3; i++) {
						int ny = a.y + dy[i];
						int nx = a.x + dx[i];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(ar[ny][nx] != 0) {
							if(ar[ny][nx] == 1) {
								ar[ny][nx] = 2;
							}
							break;
						}
						stack.push(new archer(ny,nx,a.d+1));
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 2) {
					cnt++;
					ar[i][j] = 1;
				}
			}
		}
//		System.out.println(cnt);
		maxCnt = Math.max(maxCnt, cnt);
	}
	
	static class archer {
		int y; // 궁수의 y 위치
		int x; // 궁수의 x 위치
		int d; // 궁수의 이동 횟수( d < D )
		public archer(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
