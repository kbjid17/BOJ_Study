package prob_연결요소의개수_11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans;
	static boolean[][] ar;
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a][b] = true;
			ar[b][a] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				bfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	static void bfs(int a) {
		visit[a] = true;
		q.offer(a);
		while(!q.isEmpty()) {
			int b = q.poll();
			for (int i = 1; i <= N; i++) {
				if(ar[b][i] && !visit[i]) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
