package prob_게임개발_1516_220412_실패_220417_성공;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static ArrayList<Node>[] list;
	static long[] time;
	static int[] val;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		time = new long[N+1];
		val = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) break;
				list[i].add(new Node(a,false));
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (Node a : list[i]) {
				val[i]++;
			}
		}
		
		
		for (int i = 1; i <= N; i++) {
//			System.out.println(list[i]);
			if(val[i] == 0) {
				d.offer(i);
			}
		}
//		System.out.println(d.toString());
//		System.out.println(Arrays.toString(val));
//		System.out.println(Arrays.toString(time));
		
		/*
		 각 정점으로 항햐는 intense 정점을 list에 넣어줌(val 값도 더해줌)
		 다 더해줬으면 val 값이 0인 요소만 d에 넣음
		 d 값도 다 넣은 후, 앞에서부터 하나씩 꺼내면서 
		 */
//		System.out.println(Integer.MAX_VALUE);
		
		
		while(!d.isEmpty()) {
			int a = d.poll();
//			System.out.println(a+"에는");
			if(val[a] == 0) { // 현재 노드의 가중치가 0이면
				for (int i = 1; i <= N; i++) { // 모든 노드를 보면서(본인 제외)
//					System.out.println("현재" + i + "번 list : " + list[i]);
					for (Node n : list[i]) { 
						if(n.n == a) { // i번 노드의 자식 노드로써 a번 노드가 있다면
//							System.out.println(n.n + " 이(가) 있음");
//							System.out.println(i); 자식노드 중 이미 true인 값이 있다면 더하지 않음
							time[i] += time[a];
							
							val[i]--;
							if(val[i] == 0) {
								for (Node no : list[i]) {
									if(no.visit) {
										time[i] -= time[no.n];
									}
								}
								d.offer(i);
							}
							n.visit = true;
							
						}
					}
					
					
				}
			}
		}
		
		
//		while(!d.isEmpty()) {
//			int a = d.poll();
//			for (Node b : list[a]) {
//				val[b.n]--;
//				time[b.n] += time[a];
//				if(val[b.n] == 0) {
//					b.visit = true;
//					System.out.println(b.n + "에서");
//					System.out.println(list[b.n]);
//					
//					System.out.println(b.n + " 에 " + a + "를 더함");
//					System.out.println(list[a]);
//					
//					for (Node c : list[a]) {
//						if(c.n == b.n & c.visit) {
//							time[b.n] -= time[a]; 
//						}
//					}
//					d.offer(b.n);
//				}
//			}
//		}
	
		for (int i = 1; i <= N; i++) {
			System.out.println(time[i]);
		}
	}

	static class Node {
		int n;
		boolean visit;
		public Node(int n, boolean visit) {
			super();
			this.n = n;
			this.visit = visit;
		}
		@Override
		public String toString() {
			return "Node [n=" + n + ", visit=" + visit + "]";
		}
		
		
	}
}
