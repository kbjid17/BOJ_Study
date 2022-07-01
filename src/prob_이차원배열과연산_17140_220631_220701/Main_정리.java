package prob_이차원배열과연산_17140_220631_220701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int R,C,K;
	static int[][] ar = new int[3][3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		R-=1;
		C-=1;
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(R <3 && C < 3) {
			if(ar[R][C] == K) {
				System.out.println(0);
				return;
			}
		}
		
		int y = 3; 
		int x = 3;
		for (int t = 1; t <= 100; t++) {
			if(y < x) { 
				y*=2;
				int maxSize_y = 0;
				int[][] new_ar = new int[y][x];
				for (int i = 0; i < x; i++) {
					int[] ar_y = new int[ar.length];
					for (int j = 0; j < ar_y.length; j++) {
						ar_y[j] = ar[j][i];
					}
					Arrays.sort(ar_y);
					ArrayList<Integer> list_num = new ArrayList<Integer>();
					ArrayList<Integer> list_cnt = new ArrayList<Integer>();
					for (int j = 0; j < ar_y.length; j++) {
						if(ar_y[j] == 0) continue; // 0은 볼필요 없음
						if(!list_num.contains(ar_y[j])) { // ar[j]를 처음 발견했다면
							list_num.add(ar_y[j]); // ar[j],1의 배열값을 집어넣음
							list_cnt.add(1);
						}
						else { //이미 존재한다면 
							list_cnt.set(list_cnt.size()-1, list_cnt.get(list_cnt.size()-1)+1); // ar[j]의 발견 갯수를 추가시킴
						}
					}
					maxSize_y = Math.max(maxSize_y, list_num.size());
					PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) ->{
						if(o1[1] > o2[1]) {
							return 1;
						}
						else if(o1[1] == o2[1]) {
							return o1[0] < o2[0] ? -1 : 1;
						}
						else {
							return -1;
						}
					});
					for (int j = 0; j < list_num.size(); j++) {
						pq.offer(new int[] {list_num.get(j),list_cnt.get(j)});
					}
					
					int idx = 0;
					while(!pq.isEmpty()) {
						int[] value = pq.poll();
						new_ar[idx][i] = value[0];
						new_ar[idx+1][i] = value[1];
						idx +=2;
					}
					
				}
				y = maxSize_y*2;
				ar = new int[y][x];
				for (int j = 0; j < x; j++) {
					for (int k = 0; k < y; k++) {
						ar[k][j] = new_ar[k][j];
					}
				}
				
				if(y > R && x > C) {
					if(ar[R][C] == K) {
						System.out.println(t);
						return;
					}
				}
			}
			else {
				x*=2;
				int maxSize_x = 0;
				int[][] new_ar = new int[y][x];
				for (int i = 0; i < ar.length; i++) {
					int[] ar_x = ar[i];
					Arrays.sort(ar_x);
					ArrayList<Integer> list_num = new ArrayList<Integer>();
					ArrayList<Integer> list_cnt = new ArrayList<Integer>();
					for (int j = 0; j < ar_x.length; j++) {
						if(ar_x[j] == 0) continue;
						if(!list_num.contains(ar_x[j])) { 
							list_num.add(ar_x[j]);
							list_cnt.add(1);
						}
						else {
							list_cnt.set(list_cnt.size()-1, list_cnt.get(list_cnt.size()-1)+1); // ar[j]의 발견 갯수를 추가시킴
						}
					}
					maxSize_x = Math.max(maxSize_x, list_num.size());
					PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) ->{
						if(o1[1] > o2[1]) {
							return 1;
						}
						else if(o1[1] == o2[1]) {
							return o1[0] < o2[0] ? -1 : 1;
						}
						else {
							return -1;
						}
					});
					for (int j = 0; j < list_num.size(); j++) {
						pq.offer(new int[] {list_num.get(j),list_cnt.get(j)});
					}
					int idx = 0;
					while(!pq.isEmpty()) {
						int[] value = pq.poll();
						new_ar[i][idx] = value[0];
						new_ar[i][idx+1] = value[1];
						idx+=2;
					}
				}
				x = maxSize_x *2;
				ar = new int[y][x];
				for (int j = 0; j < y; j++) {
					for (int k = 0; k < x; k++) {
						ar[j][k] = new_ar[j][k];
					}
				}
				if(y > R && x > C) {
					if(ar[R][C] == K) {
						System.out.println(t);
						return;
					}
				}
			}
			if(t == 100) {
				System.out.println(-1);
				return;
			}
		}
	}
}
