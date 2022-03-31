package prob_1로만들기2_12852_220327;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BFS {
	static int n;
	static long ans;
	static Node[] ar;
	static Queue<Node> q = new LinkedList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
//		ar = new Node[n+1];
//		for (int i = 0; i <= n; i++) {
//			ar[i] = new Node(0,1,"");
//		}
		
//		ar[1].n = 1;
//		ar[1].str = Integer.toString(ar[1].n);
		bfs();
	}
	
	static void bfs() {
		q.offer(new Node(1,1,"1"));
		while(!q.isEmpty()) {
			Node a = q.poll();
			if(a.n == n) {
				System.out.println(a.cnt);
				System.out.println(a.str);
				return;
			}
			if(a.n+1 <= n) {
				q.offer(new Node(a.n+1,a.cnt+1,Integer.toString(a.n+1)+ " " + a.str));
			}
			if(a.n * 2 <= n) {
				q.offer(new Node(a.n*2,a.cnt+1,Integer.toString(a.n*2)+ " " + a.str));
			}
			if(a.n * 3 <= n) {
				q.offer(new Node(a.n*3,a.cnt+1,Integer.toString(a.n*3)+ " " + a.str));
			}
		}
	}

	static class Node {
		int n;
		int cnt;
		String str;
		public Node(int n, int cnt, String str) {
			super();
			this.n = n;
			this.cnt = cnt;
			this.str = str;
		}
		
	}
}
