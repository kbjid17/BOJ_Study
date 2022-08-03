package prob_효율적인해킹_1325_220803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[][] visited = new boolean[10001][10001];
	static ArrayList<Integer>[] list;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static int[] max_list;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	static int N,M,max_size;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		boolean[][] ac = new boolean[10001][10001];
		max_list = new int[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}
		for (int i = 1; i < list.length; i++) {
			bfs(i);
		}
		for (int i = 0; i < list.length; i++) {
			if(max_list[i] == max_size) {
				pq.offer(i);
			}
		}
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}

		System.out.println(sb.toString());
	}
	static void bfs(int i) {
		q.offer(i);
		visited[i][i] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			for (int j = 0; j < list[n].size(); j++) {
				if(visited[i][list[n].get(j)] || list[n].get(j) == i) continue;
				visited[i][list[n].get(j)] = true;
				max_list[i]++;
				q.offer(list[n].get(j));
			}
		}
		max_size = Math.max(max_size, max_list[i]);
	}
}