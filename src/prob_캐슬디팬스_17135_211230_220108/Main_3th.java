package prob_캐슬디팬스_17135_211230_220108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3th {
	static int N,M,D;
	static Stack<archer> stack = new Stack<>();
	static int[] dy = {0,-1,0};
	static int[] dx = {-1,0,1};
	static int[] tgt;
	static int[][] ar;
	static int[][] copyar;
	static int enemy,ans;
	/*
	 N+1행/ 각기 다른 열에 3명의 궁수가 배치됨
	 한 궁수 => 처음 이동시엔 윗칸으로만 이동 => 적이 있으면 2로 만듬 , 끝 => 적이 없으면 다음 이동을 진행 => 왼쪽-위-오른쪽 순으로 탐색 가능 => 적이 발견될 시 끝
	 모든 궁수에 대한 관측이 끝나면, 스택을 비운 후 한칸 행은 한칸 올리고(--) 열은 같게 하여 궁수 입력
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		ar = new int[N+2][M+1];
		tgt = new int[3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		comb(0,1);
		System.out.println(ans);
	}
	static void comb(int tgtIdx,int srcIdx) {
		if(tgtIdx == 3) {
			copyar = new int[N+2][M+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					copyar[i][j] = ar[i][j];
				}
			}
			
			dfs();
			return;
		}
		
		for (int i = srcIdx; i <= M; i++) {
			tgt[tgtIdx] = i;
			comb(tgtIdx+1,i+1);
		}
	}
	
	static void dfs() {
		
		enemy = 0;
		for (int d = N+1; d > 0; d--) {
			stack.clear();
			for (int i = 0; i < tgt.length; i++) {
				stack.push(new archer(d,tgt[i],0));
				while(!stack.isEmpty()) {
					archer a = stack.pop();
					
					if(a.d == 0) {
						int ny = a.y + dy[1];
						int nx = a.x + dx[1];
						if(ny <= 0 || ny > N || nx <= 0 || nx > M) continue;
						if(copyar[ny][nx] != 0) {
							copyar[ny][nx] = 2;
							stack.clear();
							break;
						}
						if(a.d+1 < D) {
							stack.push(new archer(ny,nx,a.d+1));
						}
					}
					else {
						for (int j = 0; j < 3; j++) {
							int ny = a.y + dy[j];
							int nx = a.x + dx[j];
							if(ny <= 0 || ny > N || nx <= 0 || nx > M) continue; // 밖으로 나가면 잘못된것 -> 다른 방향으로 이동
							if(copyar[ny][nx] !=0) {
								copyar[ny][nx] = 2;
								//적을 노리는 데 성공했으면, 이 궁수는 다른 곳을 볼 필요가 없어짐. => 이동 종료
								stack.clear();
								break;
							}
							if(a.d+1 < D) {
								stack.push(new archer(ny,nx,a.d+1));
							}
						}
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(copyar[i][j] == 2) {
						copyar[i][j] = 0;
						enemy++;
					}
				}
			}
			for (int i = 1; i <= M; i++) {
				copyar[d][i] = 0;
			}
		}
		ans = Math.max(enemy, ans);
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