package prob_2606_바이러스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N; //컴퓨터 개수
	static int C,cnt; //연결 개수 , 감염되는 컴퓨터 횟수
	static boolean[][] graph;
	static Stack<Integer> stk = new Stack<>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new boolean[N+1][N+1]; //상호 연결되었음을 확인하기 위한 그래프
		C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from][to] = true;
			graph[to][from] = true;
		}
		dfs(1);
		System.out.println(cnt);
	}
	//graph 구현
	//1차원 배열 구현 1,2,3,4,5,6,7,8... 번 컴퓨터
	//for문을 돌리면서 if(graph[start][j]) true면 start(1)과 해당 녀석이 연결되었다는 의미이기 때문에
	//to를 감염시키고 to에서 다시 순회 하면 가능하지 않을까?
	static void dfs(int start) {
		graph[start][0] = true;
		for (int i = 1; i <= N; i++) {
			if(graph[start][i] && !graph[i][0]) {
				cnt++;
				dfs(i);
			}
		}
		
	}
}
