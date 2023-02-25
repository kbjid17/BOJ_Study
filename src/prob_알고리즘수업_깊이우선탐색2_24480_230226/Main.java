package prob_알고리즘수업_깊이우선탐색2_24480_230226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R, cnt;
	static ArrayList<Integer>[] lists;
	static boolean[] visited;
	static int[] order;
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N+1];
		order = new int[N+1];
		for (int i = 1; i <= N; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lists[a].add(b);
			lists[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(lists[i]);
		}
		
		stack.push(R);
		while(!stack.isEmpty()) {
			int n = stack.pop();
			if(order[n] != 0) continue;
			order[n] = ++cnt;
			visited[n] = true;
			
			for (int i = 0; i < lists[n].size(); i++) {
				if(visited[lists[n].get(i)]) continue;
				stack.push(lists[n].get(i));
			}
		}
		for (int i = 1; i < order.length; i++) {
			System.out.println(order[i]);
		}
		
	}

}
