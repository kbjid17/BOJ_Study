package prob_이차원배열과연산_17140_220631_220701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_실패 {
	static int[][] ar = new int[3][3];
	static int R,C,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// ar[R][C] == K가 될때까지 진행
		R-=1;
		C-=1;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(ar[R][C] == K) {
			System.out.println(0);
			return;
		}
		int x_len = 3;
		int y_len = 3;
		for (int t = 1; t <= 100; t++) {
			if(t % 2 == 0) { // C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
				y_len+=3;
				int[][] new_ar = new int[y_len][x_len];
				for (int i = 0; i < x_len; i++) {
					int[] x_ar = new int[y_len-3];
					for (int j = 0; j < x_ar.length; j++) {
						x_ar[j] = ar[j][i];
					}
					Arrays.sort(x_ar);
					ArrayList<Integer> list_num = new ArrayList<Integer>();
					ArrayList<Integer> list_cnt = new ArrayList<Integer>();
					for (int j = 0; j < x_ar.length; j++) {
						if(x_ar[j] == 0 ) continue;
						if(!list_num.contains(x_ar[j])) {
							list_num.add(x_ar[j]);
							list_cnt.add(1);
						}
						else {
							list_cnt.set(list_cnt.size()-1, list_cnt.get(list_cnt.size()-1)+1);
						}
					}
					PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) ->{
						System.out.println("정렬 진행" + " " + Arrays.toString(o1) +  " " + Arrays.toString(o2));
						if(o1[1] > o2[1]) {
							System.out.println("o1[1] > o2[1]");
							return 1;
						}
						else if(o1[1] == o2[1]) {
							System.out.println("o1[1] == o2[1]");
							return o1[0] < o2[0] ? -1 : 1;
						}
						else {
							System.out.println("o1[1] < o2[1]");
							return -1;
						}
					});
					for (int j = 0; j < list_num.size(); j++) {
						pq.offer(new int[] {list_num.get(j),list_cnt.get(j)});
					}
					int idx = 0;
					while(!pq.isEmpty()) {
						int[] a = pq.poll();
						System.out.println("["+a[0]+","+a[1] + "]");
						new_ar[idx][i] = a[0];
						new_ar[idx+1][i] = a[1];
						idx+=2;
					}
				}
				ar = new int[y_len][x_len];
				for (int i = 0; i < y_len; i++) {
					for (int j = 0; j < x_len; j++) {
						ar[i][j] = new_ar[i][j];
					}
				}
				
				for (int i = 0; i < y_len; i++) {
					for (int j = 0; j < x_len; j++) {
						System.out.print(ar[i][j] +  " ");
					}
					System.out.println();
				}
			}
			else { //  R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다. 
				x_len+=3;
				int[][] new_ar = new int[y_len][x_len];
				for (int i = 0; i < y_len; i++) {
					int[] y_ar = ar[i];
					Arrays.sort(y_ar);
					ArrayList<Integer> list_num = new ArrayList<Integer>();
					ArrayList<Integer> list_cnt = new ArrayList<Integer>();
					for (int j = 0; j < y_ar.length; j++) {
						if(y_ar[j] == 0) continue;
						if(!list_num.contains(y_ar[j])) {
							System.out.println(j + " " +y_ar[j] + " 가 없음");
							list_num.add(y_ar[j]);
							list_cnt.add(1);
						}
						else {
							list_cnt.set(list_cnt.size()-1, list_cnt.get(list_cnt.size()-1)+1);
						}
					}
//					음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
					PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) ->{
						System.out.println("정렬 진행" + " " + Arrays.toString(o1) +  " " + Arrays.toString(o2));
						if(o1[1] > o2[1]) {
							System.out.println("o1[1] > o2[1]");
							return 1;
						}
						else if(o1[1] == o2[1]) {
							System.out.println("o1[1] == o2[1]");
							return o1[0] < o2[0] ? -1 : 1;
						}
						else {
							System.out.println("o1[1] < o2[1]");
							return -1;
						}
					});
					for (int j = 0; j < list_num.size(); j++) {
						pq.offer(new int[] {list_num.get(j),list_cnt.get(j)});
					}
					System.out.println();
					
					
					int idx = 0;
					while(!pq.isEmpty()) {
						int[] a = pq.poll();
						System.out.println("["+a[0]+","+a[1] + "]");
						new_ar[i][idx] = a[0];
						new_ar[i][idx+1] = a[1];
						idx +=2;
					}
//					for (int j = 0; j < list_num.size()*2; j++) {
//						if(j % 2 == 0) {
//							new_ar[i][j] = list_num.get(idx);
//						}
//						else {
//							new_ar[i][j] = list_cnt.get(idx);
//							idx++;
//						}
//					}
				}
				ar = new int[y_len][x_len];
				for (int i = 0; i < y_len; i++) {
					for (int j = 0; j < x_len; j++) {
						ar[i][j] = new_ar[i][j];
					}
				}
				for (int i = 0; i < y_len; i++) {
					for (int j = 0; j < x_len; j++) {
						System.out.print(ar[i][j] + " ");
					}
					System.out.println();
				}
			}
			System.out.println();
			if(ar[R][C] == K) {
				System.out.println(t);
				return;
			}
			else if(t == 100 && ar[R][C] != K) {
				System.out.println(-1);
				return;
			}
			
		}
	}

}
