package prob_미네랄_2933_220614_220615_221017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2 {
	static int R,C,N;
	static int[] straws;
	static char[][] ar;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ar = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			ar[i] = str.toCharArray();
		}
		N = Integer.parseInt(br.readLine());
		straws = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			straws[i] = Integer.parseInt(st.nextToken());
			
//			System.out.println((i+1) + "번째 ::: " + straws[i]);
			visited = new boolean[R][C];
			if(i %2 == 0) {
				game(1,R-straws[i]);
			}
			else {
				game(-1,R-straws[i]);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
	}
	static void game(int dir, int h) { // dir : 방향  (1 : 왼쪽-> 오른쪽 , -1 : 오른쪽 -> 왼쪽)
		switch(dir) {
		case 1:
			// 1. h높이의 가장 왼쪽의 미네랄을 부숨
			for (int i = 0; i < C; i++) {
				if(ar[h][i] == 'x') {
					ar[h][i] = '.';
					break;
				}
			}
			break;
		case -1:
			// 1. h높이의 가장 오른쪽의 미네랄을 부숨
			for (int i = C-1; i >=0 ; i--) {
				if(ar[h][i] == 'x') {
					ar[h][i] = '.';
					break;
				}
			}
			break;
		}
		// 2. 부순 후, 해당 구역에서 어떤 미네랄 덩이가 내려올 수 있는지 탐색
		/*
		 -떨어질 조건
		 해당 덩이의 가장 아랫쪽 미네랄이 땅(높이 R-1)에서 떨어져 있어야 함
		 떨어지는 건 가장 아랫쪽 미네랄이 다른 미네랄 혹은 땅에 닿을 때까지 떨어짐
		 
		 - 떨어질 미네랄 찾기
		 bfs로 탐색 후 모음을 특정 -> 가장 아랫쪽 미네랄의 세로 위치가 R-1인지 아닌지 판별. 아니면 떨어뜨림
		 
		 - 떨어뜨리는 법
		 덩이 내 모든 미네랄을 보면서 각 미네랄이 떨어질 수 있는 최대 깊이를 갱신시킴
		 그렇게 계속해서 갱신된 최솟값이 내려갈 수 있는 깊이+
		 */
		
		
		for (int i = R-1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if(ar[i][j] == 'x' && !visited[i][j]) {
//					System.out.println(i + " " + j + "에서 bfs 시작~!");
					bfs(i,j);
				}
			}
			
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(ar[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	static void bfs(int r,int c) {
//		System.out.println("---------------------- bfs 시작 -------------------------");
		boolean[][] selected = new boolean[R][C]; // 미네랄 덩이를 구별하기 위한 방문 배열
		int dist = Integer.MAX_VALUE; // 얼마나 내려갈 수 있는지 측정
		ArrayList<int[]> list = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r,c});
		list.add(new int[] {r,c});
		selected[r][c] = true;
		while(!q.isEmpty()) {
			int[] n = q.poll();
//			System.out.println(n[0] + " " + n[1]);
			for (int d = 0; d < 4; d++) {
				int ny = n[0]  + dy[d];
				int nx = n[1]  + dx[d];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C || selected[ny][nx] || ar[ny][nx]=='.') continue;
				
				list.add(new int[] {ny,nx});
				q.offer(new int[] {ny,nx});
				selected[ny][nx] = true;
			}
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(Arrays.toString(list.get(i)));
////			visited[list.get(i)[0]][list.get(i)[1]] = true;
//		}
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(Arrays.toString(list.get(i)) + " 를 가짐");
			if(list.get(i)[0] == R-1) {
				dist = 0;
				break;
			}
			if(list.get(i)[0] < R-1 && ar[list.get(i)[0]+1][list.get(i)[1]] == '.') {
//				System.out.println("내려갈 수 있음");
				int distance = 0;
				for (int j = list.get(i)[0]+1; j < R; j++) {
					
					distance +=1;
					if(ar[j][list.get(i)[1]] == 'x' && !selected[j][list.get(i)[1]]) {
						distance -=1;
						break;
					}
					if(j == R-1) {
						break;
					}
					
				}
				dist = Math.min(distance, dist);
			}
		}
		if(dist == 0 || dist == Integer.MAX_VALUE) { // 이동할 수 없으므로
			for (int i = 0; i < list.size(); i++) {
//				System.out.println(Arrays.toString(list.get(i)));
				visited[list.get(i)[0]][list.get(i)[1]] = true;
			}
			return;
		}
		// 미네랄 덩이가 dist만큼 내려올 수 있음.
		/*
		 1. list 안에 있는 x들을 모두 .으로 만듬
		 2. list 안에 있는 모든 위치 정보들의 y값에 dist를 더함
		 3. 값이 조정된 list 값에 맞춰 배열에 새로 x 처리
		 4. x처리된 위치는 visited true 처리(다음 덩어리 탐색 중 재탐색하게 되는 상황 방지)
		 */
//		System.out.println("dist 값은 "+dist);
		for (int i = 0; i < list.size(); i++) {
			ar[list.get(i)[0]][list.get(i)[1]] = '.';
			list.get(i)[0] += dist;
		}
		for (int i = 0; i < list.size(); i++) {
			ar[list.get(i)[0]][list.get(i)[1]] = 'x';
			visited[list.get(i)[0]][list.get(i)[1]] = true;
		}
		
	}
}
