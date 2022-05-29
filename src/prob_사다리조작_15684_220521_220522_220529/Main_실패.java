package prob_사다리조작_15684_220521_220522_220529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_실패 {
	static int N,M,H; // 세로선 수, 가로선 수, 세로선마다 가로선을 놓을 수 있는 위치의 개수
	static boolean[][][] ladder;
	static boolean[][][] visited;
	static Stack<node> s = new Stack<node>();
	static int[] dy = {0,0,1};
	static int[] dx = {-1,1,0}; // ↓ ← →
	static ArrayList<int[]> input = new ArrayList<int[]>();
	static ArrayList<int[]> tgt;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로선 수
		M = Integer.parseInt(st.nextToken()); // 가로선 수
		H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수
		
		ladder = new boolean[N+1][N+1][H+1]; //[세로선][연결된 선][연결된 가로선의 위치]
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= H; j++) {
				ladder[i][i][j] = true; 
				// i번 세로줄은 다른 세로줄과 [j] 위치에 번 세로줄은 서로 연결되어있음(이곳에선 다른 세로줄과 연결하는 게 아님 -> 자기 자신과 연결 처리([i][i][j] = true;)
			}
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // a 번 점선 위치에서
			int b = Integer.parseInt(st.nextToken()); // b번 세로선과 b+1번 세로선을 연결함
			ladder[b][b+1][a] = true; // b번 세로선과 b+1번 세로선을 a 위치에서 연결
			ladder[b+1][b][a] = true; // b+1번 세로선과 b번 세로선을 a 위치에서 연결
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= H; j++) {
				if(!ladder[i][i+1][j]) input.add(new int[] {i,i+1,j}); // 연결되지 않은 가로선을 가짐
			}
		}

		System.out.println(game());
	}
	static int game() { // num 만큼 가로선을 연결한 후 진행
		//게임 도중 i-> i 가 성립되지 않으면 다음 조합으로 진행
		int cnt = 0; // 넣어야 하는 가로선 개수
		
		while(cnt <= 3) {
			tgt = new ArrayList<int[]>();
			for (int i = 0; i < cnt; i++) {
				tgt.add(null); // 조합을 통해 내부 값을 바꿔가면서 진행해야 하기에 빈 값을 넣어놔야 함
			}
				if(comb(0,0,cnt)) {
					return cnt;
				}
			cnt++; 
		}
		
		
		//num 개의 가로선을 연결한 후 게임 진행 (조합으로 연결 -> 게임 진행 -> 실패하면 다시 진행)

		return -1;
	}
	
	static boolean comb(int tgtIdx,int srcIdx, int cnt) {
		if(tgtIdx == cnt) {
//			System.out.println();
			// 가로을 다 정했다면 사다리게임을 진행
			for (int i = 0; i < cnt; i++) {
				System.out.println(Arrays.toString(tgt.get(i)));
			}
//			System.out.println();
			boolean[][][] copyladder = new boolean[N+1][N+1][H+1];
			
			// 배열 복사 -> 가로선 더하기 -> 게임 진행 -(실패)-> 새로 더한 가로선을 지우고 다시 가로선을 만들어서 게임 진행[여기서][여기로][이 곳에서 가로로 연결]
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= H; k++) {
						copyladder[i][j][k] = ladder[i][j][k];
					}
				}
			}
			
			for (int i = 0; i < tgt.size(); i++) {
				int[] a = tgt.get(i);
				copyladder[a[0]][a[1]][a[2]] = true;
				copyladder[a[1]][a[0]][a[2]] = true;
			} // 가로선 연결 완료 => copyladder로 사다리 게임 진행
			
			for (int i = 1; i <= N; i++) { // i번 위치로 dfs로 진행(가로선 우선 -> 세로로 이동)
				
				visited = new boolean[N+1][N+1][H+1];
				s.push(new node(i,1));
				visited[i][i][0] = true;
				while(!s.isEmpty()) {
					node n = s.pop();
//					System.out.println();
					System.out.println(n.x +" "+ n.y + " 에서 시작");
//					System.out.println();
					for (int d = 0; d < 3; d++) {
						int nx = n.x + dx[d];
						int ny = n.y + dy[d];
						if(ny <= 0 || ny > H || nx <= 0 || nx > N 
								|| !copyladder[n.x][nx][ny] || !copyladder[nx][n.x][ny] 
										|| visited[n.x][nx][ny] || visited[nx][n.x][ny]) continue;
//						System.out.println(nx + " " + ny);
						if(ny == H) { // 맨 밑으로 왔을 경우
							if(nx == i) { // 자기 자신에게 왔을 경우 -> 다음 세로줄로 게임을 진행해야 함.
								s.clear();
								break;
							}
							else { // 자기 자신에게 오는 데 실패했을 경우 -> 해당 조합을 더 쓸 필요가 없음
								System.out.println(i + " 로 가야 하는데");
								System.out.println(nx + "(으)로 옴");
//								s.clear();
								return false;
							}
						}
						// 배열 밖으로 나가거나 ny 위치에서 n.x -> nx로 가는 게 false면 이동 불가능
						// !copyladder[n.x][nx][ny] dy가 변하지 않을 때만 dx가 값이 있음(세로로 가거나 양옆으로 가는 것.)
						
						visited[n.x][nx][ny] = true;
						visited[nx][n.x][ny] = true;
						s.push(new node(nx,ny));
					}
				}
			}
			
			return true;
		}
			
			for (int i = srcIdx; i < input.size(); i++) {

				tgt.set(tgtIdx, input.get(i));
				comb(tgtIdx+1,i+1,cnt);
			}
			return false;
	}
	
	static class node { // 위치와 만든 가로선의 개수를 가지는 클래스
		int x; // 현재 위치한 세로선
		int y; // 현재 위치한 가로선
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
}

/*

*/