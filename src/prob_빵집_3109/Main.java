package prob_빵집_3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int R,C,count;
	static char[][] ar;
	static ArrayList<Node> list = new ArrayList<Node>(); // 루트를 구하기 위해 선언
	static Stack<Node> stack = new Stack<Node>();
	static boolean[][] visit;
	static int[] dy = {1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ar = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			ar[i] = str;
		}
		for (int i = 0; i < R; i++) {
			dfs(i,0);
		}
		System.out.println(count);
	}
	static void dfs(int y,int x) {
		visit[y][x] = true;
		stack.push(new Node(y,x,y,-1)); // 현 위치의 y,x값 , 이전 위치의 y,x값(초기값 : y,-1)
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			list.add(node);
//			System.out.println(node.y + " " + node.x);
			for (int i = 0; i < 3; i++) {
				int ny = node.y + dy[i];
				int nx = node.x+1;
				if(ny < 0 || ny >= R || ar[ny][nx] == 'x' || nx >= C || visit[ny][nx]) continue;
//				visit[ny][nx] = true;
				stack.push(new Node(ny,nx,node.y,node.x));
				if(nx == C-1) { // 도착했을 경우
//					System.out.println("도착");
					node = stack.pop();
					for (int j = 0; j < 5; j++) {
						visit[node.y][node.x]= true; //도착한 위치를 true 처리
//						System.out.println(node.y + " " + node.x);
						//cy cx 위치로 이동해서 visit 처리를 해야함.
						if(node.x == 0) break;
						int beforey = node.cy;
						int beforex = node.cx;
						while(beforey !=  node.y || beforex != node.x) {
							if(list.isEmpty()) 
								break;
							node = list.get(list.size()-1);
							list.remove(list.size()-1);
						}
						//찾았으면 다음 해당 노드 기준으로 다음 반복 진행
					}
					stack.clear();
					list.clear();
					count++;
					return;
					//맨 위로 향하는 방향으로 도착했기에 최적 루트.
					//나머지 루트로 이동한 경우는 모두 지워야 함.(파이프 연결한 부분은 다른 파이프를 설치할 수 없기 때문
					// 깊이 우선 탐색이기 때문에 깊이 이동된 곳에서 쭈욱 나아가기 때문에 다른 방향으로 나가기 전에 스택을 초기화시켜버림!
				}
			}
		}
	}

	static class Node {
		int y;
		int x;
		int cy;
		int cx;
		public Node(int y,int x,int cy,int cx) {
			this.y = y;
			this.x = x;
			this.cy = cy;
			this.cx = cx;
		}

	}
}
