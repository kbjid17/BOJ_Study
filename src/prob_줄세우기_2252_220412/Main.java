package prob_줄세우기_2252_220412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int a,b;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static int[] ar;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ar = new int[n+1];
		list = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ar[b]++;
			list[a].add(b);
		}
		
		for (int i = 1; i <= n; i++) {
			if(ar[i] == 0) {
				d.offer(i);
			}
		}
		
		while(!d.isEmpty()) {
			int a = d.poll();
			sb.append(a).append(" ");
			
			for (int num : list[a]) {
				ar[num]--;
				if(ar[num] == 0) {
					d.offer(num);
				}
			}
		}
		System.out.println(sb);
	}
}
