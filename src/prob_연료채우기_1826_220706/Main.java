package prob_연료채우기_1826_220706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[][] ar;
	static ArrayList<gas> list = new ArrayList<gas>();
	static ArrayList<Integer> visited = new ArrayList<Integer>();
	static int ans;
	static int dest, fuel; // destination : 목적지
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
//		ar = new int[n][2];
//		
//		for (int i = 0; i < n; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 2; j++) {
//				ar[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		Arrays.sort(ar,new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if(o1[1] > o2[1]) {
//					return -1;
//				}
//				else if(o1[1] == o2[1]) {
//					if(o1[0] < o2[0]) {
//						return -1;
//					}
//				}
//				return 1;
//			}
//			
//		});
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dist = Integer.parseInt(st.nextToken());
			int fuel = Integer.parseInt(st.nextToken());
			list.add(new gas(dist, fuel));
		}
		
		Collections.sort(list, new Comparator<gas>() {

			@Override
			public int compare(gas o1, gas o2) {
				if(o1.f > o2.f) {
					return -1;
				}
				else if(o1.f == o2.f) {
					if(o1.d < o2.d) {
						return -1;
					}
				}
				return 1;
			}
			
		});
//		for (gas g : list) {
//			System.out.println(g.d + " " + g.f);
//		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dest = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		if(dest <= fuel) {
			System.out.println(0);
			return;
		}
		
		while(dest > fuel) {
			if(list.size() == 0) {
				System.out.println(-1);
				return;
			}
			for (int i = 0; i < list.size(); i++) {
				if(fuel >= list.get(i).d) {
					visited.add(i); // 이 주유소를 방문
					fuel += list.get(i).f;
					list.remove(i);
					break;
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(ar[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(visited.size());
		// 주유소를 최소 횟수로 방문해야함.
		// 현재 갈 수 있는 주유소들 중, 가장 멀리 갈 수 있는 주유소를 찾아야 함.
		// (이 때, 해당 주유소에서 기름을 채웠다 하더라도 다음 주유소로 도착할 수 있어야 함.)
		// 현재 남은 연료를 기준으로 가장 멀리 갈 수 있는 우선순위를 
	}
	static class gas {
		int d;
		int f;
		public gas(int d, int f) {
			super();
			this.d = d;
			this.f = f;
		}
		
		
	}
}
