package prob_DSLR_9019_220415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int T;
	static int A,B;
	static boolean[] visit;
	static Queue<Node> q = new LinkedList<Node>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			visit = new boolean[10000];
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());

			q.offer(new Node(A,""));
			bfs();
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.n == B) {
				q.clear();
				sb.append(n.s).append("\n");
				return;
			}
			D(n);
			S(n);
			L(n);
			R(n);
		}
	}

	static void D(Node num) { // D : n = n*2 % 10000
		if(!visit[num.n*2 %10000]) {
			q.offer(new Node((num.n*2)%10000,num.s+"D"));
			visit[num.n*2 %10000] = true;
		}	
	}
	
	static void S(Node num) { // S : n-1 (if n = 0 => n = 10000-1)
		if(num.n == 0) {
			if(!visit[9999]) {
				q.offer(new Node(9999,num.s+"S"));
				visit[9999] = true;
			}
		}
		else {
			if(!visit[num.n-1]) {
				q.offer(new Node(num.n-1,num.s+"S"));
				visit[num.n-1] = true;
			}
		}
	}
	static void L(Node num) { // L : 각 자릿수를 왼편으로 회전 (ex. 1234 =(L)=> 2341 // 1000 =(L)-> 0001(==1)
			int b = (num.n % 1000) * 10 + num.n/1000;

			if(!visit[b]) {
				q.offer(new Node(b,num.s+"L"));
				visit[b] = true;
			}
	}
	
	static void R(Node num) { // R : 각 자릿수를 오른편으로 회전(ex. 1234 =(R)=> 4123
			int b = (num.n / 10) + (num.n%10)*1000;
			if(!visit[b]) {
				q.offer(new Node(b,num.s+"R"));
				visit[b] = true;
			}
	}
	
	static class Node {
		int n;
		String s;
		public Node(int n, String s) {
			super();
			this.n = n;
			this.s = s;
		}
		
	}
}
