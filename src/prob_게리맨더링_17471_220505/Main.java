package prob_게리맨더링_17471_220505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ans1,ans2;
	static int ans = Integer.MAX_VALUE;
	static int N; // 구역 수
	static int[] ar;// 각 구역 내 인구수
	static int[] tgt;
	static ArrayList<Integer> ar1;
	static ArrayList<Integer> ar2;
	static int[] visit;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 1; j < str.length; j++) {
				list[i].add(Integer.parseInt(str[j]));
				list[Integer.parseInt(str[j])].add(i);
			}
		}
		
		for (int i = 1; i < N; i++) {
			tgt = new int[i];
			comb(i,1,0); // 1/2구역 정하기 : 조합으로 이용
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}

	static void comb(int size,int srcIdx,int tgtIdx) {
		if(tgtIdx == size) { // 조합으로 정해진 장소가 구역 1. 나머지가 구역 2
			ans1 = 0;
			ans2 = 0;
			visit = new int[N+1];
			ar1 = new ArrayList<Integer>();
			ar2 = new ArrayList<Integer>();
			for (int i = 0; i < tgt.length; i++) {
				visit[tgt[i]] = 1;
			}
			for (int i = 1; i < visit.length; i++) {
				if(visit[i] == 1) {
					ar1.add(i);
				}
				else {
					ar2.add(i);
				}
			}
				bfs_1();
			return;
		}
		
		for (int i = srcIdx; i <= N; i++) {
			tgt[tgtIdx] = i;
			comb(size,i+1,tgtIdx+1);
		}
	}
	
	static void bfs_1() {
		if(ar1.size() == 1) {
			ans1 = ar[ar1.get(0)];
			bfs_2();
			return;
		}
		boolean[] visit_1 = new boolean[N+1];
		int num = 1;
		q.offer(ar1.get(0));
		visit_1[ar1.get(0)] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			for (int i = 0; i < list[n].size(); i++) {
				if(visit[list[n].get(i)] == visit[n]) {
					if(visit_1[list[n].get(i)]) continue;
					num++;
					visit_1[list[n].get(i)] = true;
					if(num == ar1.size()) { 
						q.clear();
						for (int j = 0; j < ar1.size(); j++) {
							ans1+= ar[ar1.get(j)];
						}
						bfs_2();
						return;
					}
					q.offer(list[n].get(i));
				}
			}
		}
	}
	static void bfs_2() {
		if(ar2.size() == 1) {
			ans2 = ar[ar2.get(0)];
			ans = Math.min(ans, Math.abs(ans1-ans2));
			q.clear();
			return;
		}
		
		boolean[] visit_2 = new boolean[N+1];
		int num = 1;
		q.offer(ar2.get(0));
		visit_2[ar2.get(0)] = true;
		while(!q.isEmpty()) {
			int n = q.poll();
			for (int i = 0; i < list[n].size(); i++) {
				if(visit[list[n].get(i)] == visit[n]) { 
					if(visit_2[list[n].get(i)]) continue; 
					num++;
					visit_2[list[n].get(i)] = true;
					if(num == ar2.size()) { 
						for (int j = 0; j < ar2.size(); j++) {
							ans2+= ar[ar2.get(j)];
						}
						ans = Math.min(ans, Math.abs(ans1-ans2));
						q.clear();
						return;
					}
					q.offer(list[n].get(i));
				}
			}
		}
	}
}
