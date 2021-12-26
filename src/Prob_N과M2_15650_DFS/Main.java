package Prob_N과M2_15650_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ar;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		for (int i = 1; i < N; i++) {
			dfs(i,0);
		}
	}
	static void dfs(int start,int line) {
		visit[start][line] = true;
		System.out.print(start + " ");
		for (int i = start+1; i <= N; i++) {
			
		}
		
	}
}
