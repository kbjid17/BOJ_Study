package prob_결혼식_5567_220503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Integer>[] ar;
	static Queue<Integer> q =new LinkedList<Integer>();
	static boolean[] visit;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ar=  new ArrayList[n+1];
		visit = new boolean[n+1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a].add(b);
			ar[b].add(a);
		}
		
		bfs();
		
		for (int i = 2; i < visit.length; i++) {
			ans += visit[i] ? 1 : 0;
		}
		System.out.println(ans);
	}
	static void bfs() {
		q.offer(1);
		
		int n = q.poll();
		for (int i = 0; i < ar[n].size(); i++) {
			if(visit[ar[n].get(i)]) continue;
			q.offer(ar[n].get(i));
			visit[ar[n].get(i)] = true;
		}
		
		while(!q.isEmpty()) {
			int nn = q.poll();
			for (int i = 0; i < ar[nn].size(); i++) {
				if(visit[ar[nn].get(i)]) continue;
				visit[ar[nn].get(i)] = true;
			}
		}
	}
}
