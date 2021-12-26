package prob_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
	static int[][] map;
	static boolean[] visited;
	static int N,M,V,start,end;
	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			for(int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
				map[end][start] = 1; //bfs 전용
				
			}
			dfs(V);
			visited = new boolean[N+1];
			System.out.println();
			bfs(V);
			
	}
	
	static void dfs(int point) {
		Stack<Integer> stack = new Stack<>();
		stack.push(point);
		visited[point] = true;
		System.out.print(point + " ");
		
		while(!stack.isEmpty()) {
			for(int i = 1; i  <= N; i++) {
				if(map[point][i] == 1 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
					dfs(i);
				}
			}
			stack.pop();
		}
	}
	static void bfs(int point) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(point);
		visited[point] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			
			for(int i = 1; i <= N; i++) {
				if(map[x][i] ==1 && visited[i] == false) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}