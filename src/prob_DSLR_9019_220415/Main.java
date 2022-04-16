package prob_DSLR_9019_220415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int A,B;
	static boolean[] visit;
	static Queue<Node> q = new LinkedList<Node>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		/*
		 D : n = n*2 % 10000
		 S : n-1 (if n-1 = 0 => n = 10000-1)
		 L : 각 자릿수를 왼편으로 회전 (ex. 1234 =(L)=> 2341
		 R : 각 자릿수를 오른편으로 회전(ex. 1234 =(R)=> 4123
		 */
		
		for (int t = 1; t <= T; t++) {
			visit = new boolean[10000];
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());
			
			// A를 B로 만들기 위해 필요한 명령 종류
			/*
			 A값을 queue로 넣어준 후, 배열 순회가 아닌 명령어 순회를 해야 한다.
			 명령어 순회
			 DSLR 명령어를 수행할 때마다 그 결괏값을 큐에 넣어서 다시 DSLR을 수행할 수 있게 만들어 주면 되지 않을까?
			 */
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
//		if(num.n >= 10) { // num.n이 10보다 작으면 한자리 수 ==> L을 해도 같은 값이 나옴
//			String[] a = Integer.toString(num.n).split("");
			int b = 0;
//			b = (num.n*10) % 10000 + num.n/1000; //=> 1234 ==> 12340 => 2340 + 1 == 2341 // 234 ==> 2340
			b = (num.n % 1000) * 10 + num.n/1000;
//			for (int i = a.length-1; i >=1 ; i--) {
//				b+= (Integer.parseInt(a[i]) * Math.pow(10,a.length-i));
//			}
			if(!visit[b]) {
				q.offer(new Node(b,num.s+"L"));
				visit[b] = true;
			}
			
//			System.out.println(num.n + "을 "+ b + "로!");
//		}
	}
	
	static void R(Node num) { // R : 각 자릿수를 오른편으로 회전(ex. 1234 =(R)=> 4123
//		if(num.n >= 10) { // num.n이 10보다 작으면 한x자리 수 ==> R을 해도 같은 값이 나옴
//			System.out.print(num.n + "에서 ");
//			String[] a = Integer.toString(num.n).split("");
			int b = 0;
//			b += Integer.parseInt(a[a.length-1])*Math.pow(10, a.length-1); // 오른쪽 맨 끝의 자릿수를 왼쪽 맨 끝으로 옮김
			b = (num.n / 10) + (num.n%10)*1000; //=> 1234 ==> 123 + (1234%10)*1000
//			for (int i = 0; i < a.length-1; i++) {
//				b+= (Integer.parseInt(a[i]) * Math.pow(10, a.length-2-i));
//			}
//			System.out.println(b + " R");
			if(!visit[b]) {
				q.offer(new Node(b,num.s+"R"));
				visit[b] = true;
			}
//			System.out.println(num.n + "을 "+ b + "로!");
//		}
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
