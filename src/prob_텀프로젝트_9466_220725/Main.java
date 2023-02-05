package prob_텀프로젝트_9466_220725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] ar;
	static int ans;
	static boolean[] visited;
	static boolean[] team;
	static Stack<Integer> s = new Stack<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			ans = n;
			ar = new int[n+1];
			team = new boolean[n+1];
			visited = new boolean[n+1];
			/*
			문제 해결의 조건 
			 팀원 수 제한 X(모든 학생들이 하나의 팀으로 구성될 수도 있음)
			 팀 구성을 위해, 모든 학생들은 프로젝트를 함께하고 싶은 1명의 팀원을 선택해야 한다!
			 (자기 자신을 그 1명의 팀원으로 선택하는 것도 가능)
			 */
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}
			/*
			 팀을 이룰 수 있는 조건
			 1~n번 팀원 중 팀이 없는 학생들을 시작점으로 DFS를 다룬다고 가정
			 1~7번까지 3,1,3,7,3,4,6 의 선호 학생을 각자 보유
			 1번 학생의 선호 학생 -> 3 -> 3인데, 3번 학생의 선호 학생은 본인==> 서로 간의 사이클이 생성되지 않기 때문에 팀이 될 수 없음(==> 1,3 팀 실패)
			 2번 학생으 선호 학생 -> 1, 1번 학생의 선호 학생은 3이며 위와 같은 상황이 나오게 되므로 팀이 될 수 없음(==> 1,2,3 팀 실패)
			 3번 학생의 선호 학생 -> 3 ==> DFS의 시작 학생이 자기 자신만 좋아한다면, 자기 혼자 팀이 될 수 있음(==> 3 팀 만들어짐)
			 4번 학생의 선호 학생 -> 7 ==> 7번 학생의 선호 학생 -> 6 => 6번 학생의 선호 학생 -> 4 ==> 시작 학생으로 돌아오는 사이클을 가질 수 있다면 팀이 될 수 있음!(==> 4,6,7 팀 생성)
			 5번 학생의 선호 학생 -> 3 ==> 이 경우 3번 학생이 자기 자신을 좋아하여 사이클이 생성될 수 없는것 && 3번 학생은 이미 팀이 구성되어있다는 점 등의 이유로 인해, 팀이 될 수 없음(==> 3,5 팀 실패)
			 6,7번 학생의 경우 이미 팀이 만들어졌기에 볼 필요가 없음
			 
			 (새로운 조건)
			 1번 학생의 선호 학생 -> ==> 3번 학생의 선호 학생 -> 2 ==> 2번 학생의 선호 학생 -> 3 ==> (2,3이 팀이 가능)
			 */
			for (int i = 1; i <= n; i++) {
				if(!team[i])	{
//					System.out.println(i+"번 학생의 dfs");
					visited = new boolean[n+1];
					dfs(i);
				}
			}
//			System.out.println();
			System.out.println(ans);
//			System.out.println();
		}

	}
		static void dfs(int start) {
			if(ar[start] == start) {
//				System.out.println(start + " " + ar[start]);
				team[start] = true;
				ans--;
				return;
			}
			visited[start] = true;
			s.push(start);
			while(true) {
				int num = s.peek();
//				System.out.println(num + "의 선호 학생 : " + ar[num]);
				if(team[num])	break; // 이미 팀이 만들어진 학생이면 break;
				
				if(s.contains(ar[num])) { // 사이클이 만들어졌을 때,
//					System.out.println(ar[num] + " 확인");
					if(ar[num] == start) { // start를 기점으로 사이클이 만들어졌다면
//						System.out.println("팀 가능" + s.toString());
						ans -= s.size();
						while(!s.isEmpty()) {
							team[s.pop()] = true;
						}
						break;
					}
					else { // start에서 시작했으나, start를 뺀 다른 사이클이 확인되었다
//						System.out.println("불가능");
						// 
						int b = ar[num];
//						System.out.println("여기" + b);
						while(!s.isEmpty()) {
//							(새로운 조건)
//							 1번 학생의 선호 학생 -> 3 ==> 3번 학생의 선호 학생 -> 2 ==> 2번 학생의 선호 학생 -> 3 ==> (2,3이 팀이 가능)
//							[0,3,3,2];
							int n = s.pop();
//							System.out.print(n + " ");
							team[n] = true;
							ans--;
							if(n == b) {
//								System.out.println();
								break;
							}
						}
						break;
					}
				}
				s.push(ar[num]);
			}
			s.clear();
		}
}