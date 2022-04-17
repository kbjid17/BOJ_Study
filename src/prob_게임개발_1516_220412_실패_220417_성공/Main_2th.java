package prob_게임개발_1516_220412_실패_220417_성공;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2th {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] in = new int[T+1];
		int[] time = new int[T+1];
		int[] time_after = new int[T+1];
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer>[] list = new ArrayList[T+1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int a=  Integer.parseInt(st.nextToken());
				if(a == -1) break;
				list[a].add(i);
				in[i]++;
			}
			
		}
		for (int i = 1; i < in.length; i++) {
			if(in[i] == 0) {
				q.offer(i);
			}
		}
		
		for (int i = 1; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int next : list[now]) {
				
				time_after[next] = Math.max(time_after[next], time_after[now] + time[now]);
				in[next]--;
				if(in[next] == 0) q.offer(next);
			}
		}
		for (int i = 1; i <= T; i++) {
			System.out.println(time[i] + time_after[i]);
		}
		/*
		 list size가 0인 것부터 queue에 삽입.
		 q 안에 있는 정점을 가지고 있는 다른 정점에 q 안에 있는 정점의 시간을 더함
		 더할 때, q 안에 있는 정점이 거쳐온 정점 값을 
		 */
}

}
