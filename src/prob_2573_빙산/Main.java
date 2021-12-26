package prob_2573_빙산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,mount,count,year;
	static int[][] ar;
	static boolean[][] visit;
	static Queue<Node> queue = new LinkedList<Node>();
	static int[] dy= {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<Node> list = new ArrayList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		visit = new boolean[N][M];
		//인접 리스트를 계속 갱신해나가면서 처음 검출된 빙산의 인접 리스트를 전부 조사했음에도 list의 전체를 본 게 아니게 되면 답이 됨.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] != 0) list.add(new Node(i,j,ar[i][j]));
			}
		}
		bfs();
	}
	/*
	 1. 첫 시작 시, 리스트의 처음 요소로 검사 시작.
	 2. bfs를 돌려서 인접한 모든 정점이 해당 상호작용이 진행
	 3. 상호작용이 끝났으면 상호작용이 일어난 정점의 개수를 카운트
	 3-1. 현재 리스트에 들어있는 모든 정점의 개수 == bfs로 진행된 정점의 개수면 아직 한 덩어리이므로 다시 bfs를 진행(다시 0번 리스트로 진행!
	 3-2. 현재 리스트에 들어있는 모든 정점의 개수 != bfs로 진행된 정점의 개수면 두 덩이로 나뉜 것이므로 종료
	 */
	static void bfs() {
		while(!list.isEmpty()) {
			year++;
			for (int i = 0; i < list.size(); i++) { // 모든 요소에 대해 상호작용 진행
				for (int j = 0; j < 4; j++) {
					int ny = list.get(i).y + dy[j];
					int nx = list.get(i).x + dx[j];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if(ar[ny][nx] == 0) {
						count++;
					}
				}
//				System.out.println(count);
				list.get(i).h -= count;
//				ar[list.get(i).y][list.get(i).x] -= count;
				count = 0;
			}
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).h <= 0) {
					ar[list.get(i).y][list.get(i).x] = 0;
					list.remove(i);
					i--;
					continue;
				}
				ar[list.get(i).y][list.get(i).x] = list.get(i).h;
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(ar[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			// 상호작용 종료
			//이제 bfs를 돌려서
			// 리스트의 0번 요소를 기준으로 인접한 모든 정점을 탐색
			// 모든 정점을 탐색했으면 처음부터 다시 반복
			// 그렇지 않다면 상호작용이 일어난 횟수를 출력하고 끝
			visit = new boolean[N][M];
			mount = 1; //상호작용 후 남아있는 빙산의 수
			queue.offer(list.get(0));
			visit[list.get(0).y][list.get(0).x] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = node.y + dy[i];
					int nx = node.x + dx[i];
					if(ny < 0 || ny >= N || nx < 0 || nx >= M || ar[ny][nx] == 0 || visit[ny][nx]) continue;
					visit[ny][nx] = true;
					queue.offer(new Node(ny,nx,ar[ny][nx]));
					mount++;
				}
			} // 0번 기준 탐색이 끝나면 모든 정점을 탐색헀는지 검사
			if(mount != list.size()) {
//				System.out.println(mount + " " + list.size());
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						System.out.print(ar[i][j]);
//					}
//					System.out.println();
//				}
				System.out.println(year);
				return;
			}
		}
		System.out.println(0);
	}
static class Node {
	int y;
	int x;
	int h;
	public Node(int y, int x, int h) {
		this.y = y;
		this.x = x;
		this.h = h;
	}
	
}
}
