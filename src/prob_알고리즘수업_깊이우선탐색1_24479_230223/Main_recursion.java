package prob_알고리즘수업_깊이우선탐색1_24479_230223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_recursion {
	static int N,M,R, point;
	static ArrayList<Integer>[] lists;
	static int[] order;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		order = new int[N+1];
		lists = new ArrayList[N+1];
		for (int i = 1; i < lists.length; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists[a].add(b);
			lists[b].add(a);
			
		}
		for (int i = 1; i < lists.length; i++) {
			Collections.sort(lists[i]);
		}
		order[R] = ++point;
		dfs(R);
		for (int i = 1; i <= N; i++) {
			System.out.println(order[i]);
		}
	}

	static void dfs(int pnt) {
		for (int i = 0; i < lists[pnt].size(); i++) {
			if(order[lists[pnt].get(i)] != 0) continue;
			order[lists[pnt].get(i)] = ++point;
			dfs(lists[pnt].get(i));
		}
		
	}
}
