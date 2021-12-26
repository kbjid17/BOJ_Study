package prob_프린터큐_1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<numb> q = new LinkedList<numb>();
	static int T,N,M,ans;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			q.clear();
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ar = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				q.offer(new numb(i,ar[i+1]));
			}
			int count = 0;
			while(ans == 0) {
				int max = Integer.MIN_VALUE;
				for (numb n : q) {
					max = Math.max(max, n.priority);
				}
//				System.out.println(max);
				while(true) {
					numb b = q.poll();
					if(b.priority == max) {
						if(b.num == M) {
							ans = ++count;
							break;
						} else {
							count++;
							break;
						}
					} else {
						q.offer(new numb(b.num,b.priority));
					}
				}
			}
			
			
			System.out.println(ans);
		}
		
	}

	static class numb {
		int num;
		int priority;
		
		public numb(int num, int priority) {
			super();
			this.num = num;
			this.priority = priority;
		}
		
		
	}
}
