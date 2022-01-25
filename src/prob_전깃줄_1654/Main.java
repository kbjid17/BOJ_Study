package prob_전깃줄_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,ans;
	static ArrayList<point> p = new ArrayList<point>();
	static int[][] ar;
	static int[] lis;
	static int[] visit,visitcopy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		
		lis = new int[N+1];
		//(풀이 기준) 왼쪽 전봇대를 오름차순으로 정렬하고, 오른쪽 전봇대 위치를 연결된 왼쪽 전봇대와 1:1 매치를 시킬 경우, 어질러지게 됨.
		//이때 일부 전선을 없애서 가장 긴 lis를 출력할 수 있게 만들어 주면 됨.
		
		
	
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p.add(new point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(p);
		
		for (int i = 0; i < N; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if(p.get(i).p2 > p.get(j).p2)
				lis[i] = Math.max(lis[i], lis[j]+1);
			}
			ans = Math.max(ans, lis[i]);
		}
		
//		int start = 0;
//		int end = N-1;
//		while(start <= end) { 
//			int mid = (start + end)/2;
//			lis[mid] = 1;
//			for (int i = 0; i < mid; i++) {
//				if(p.get(mid).p2 > p.get(i).p2) {
//					lis[mid] = Math.max(lis[mid], lis[i]+1);
//				}
//			}
//			ans = Math.max(ans, lis[mid]);
//			if()
//		}
		
		
		System.out.println(N-ans);
	}
	static class point implements Comparable<point> {
		int p1;
		int p2;
		
		
		public point(int p1, int p2) {
			super();
			this.p1 = p1;
			this.p2 = p2;
		}


		@Override
		public int compareTo(point o) {
			if(this.p1 > o.p1) {
				return 1;
			}
			else return -1;
		}
	}
}