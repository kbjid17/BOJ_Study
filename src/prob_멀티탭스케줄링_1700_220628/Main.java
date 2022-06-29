package prob_멀티탭스케줄링_1700_220628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] ar;
	static boolean[] select;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 멀티탭 캡 갯수
		K = Integer.parseInt(st.nextToken()); // 플러그 개수
		
		ar = new int[K];
		select = new boolean[K];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		// 콘센트를 꽂을 여유가 충분히 있으면 pass
		// 콘센트를 꽂을 여유가 없을 경우
		/*
		 꽂혀있는 콘센트를 하나씩 훑어보면서
		 이 콘센트가 차후에 다시 사용할 일이 없으면 -> 이 콘센트를 빼고 들어올 콘센트를 끼움
		 이 콘센트가 차후에 다시 사용할 일이 있으면 -> 뒤로 미룸
		 모든 콘센트가 차후에 다시 쓰여야 한다면 -> 나중에 쓰일 콘센트를 먼저 교체
		 */
		
		for (int i = 0; i < K; i++) {
			if(list.contains(ar[i])) continue; // 이미 콘센트가 꽂혀있으면 pass
			if(list.size() < N) {
				list.add(ar[i]);
			}
			else {
//					꽂혀있는 콘센트를 하나씩 훑어보면서
//					 이 콘센트가 차후에 다시 사용할 일이 없으면 -> 이 콘센트를 빼고 들어올 콘센트를 끼움
//					 이 콘센트가 차후에 다시 사용할 일이 있으면 -> 뒤로 미룸
//					 모든 콘센트가 차후에 다시 쓰여야 한다면 -> 나중에 쓰일 콘센트를 먼저 교체
					for (int j = 0; j < list.size(); j++) { // 콘센트를 하나씩 훑어본다
						boolean use = false;
						for (int k = i+1; k < ar.length; k++) { // 현재 사용할 콘센트의 다음 경우부터 끝까지 for문
							if(ar[k] == list.get(j)) { // 사용한다면
								use = true;
								break;
							}
						}
						if(!use) { // 끝까지 봤는데 사용하지 않는다면
							list.remove(list.indexOf(list.get(j)));
							list.add(ar[i]);
							cnt++;
							break;
						}
						
						if(j == list.size()-1 && use) { //  모든 콘센트가 차후에 다시 쓰여야 한다면
							// 맨 나중에 다시 쓰일 콘센트를 먼저 찾아야 함 => 그 콘센트를 빼고 새로운 콘센트를 끼워넣어야함
							int latest = 0; int idx = 0; // 가장 늦게 사용되는 콘센트와 그 위치
							for (int k = 0; k < list.size(); k++) {
								for (int l = i+1; l < ar.length; l++) {
									if(list.get(k) == ar[l]) {
										if(idx < l) { // 가장 늦는 인덱스를 갱신
											idx = l;
											latest = ar[l];
										}
										break;
									}
								}
							} // 현재 꽂혀있는 콘센트 중 가장 늦게 갱신되는 콘센트를 발견
							// 이 콘센트를 빼고 ar[i]를 넣어줘야 함
							list.remove(list.indexOf(latest));
							list.add(ar[i]);
							cnt++;
						}
					}
				
			}
		}
		System.out.println(cnt);
	}
}

// K = 2
//1 2 3 4 1 2 => 1 1 2 2 3 4 (ans : 3) ( 1(1) 12(2) 13(2->3) 14(3->4) 14(1) 12(4->2) 1 21
/*
 1 2 3 4 1 2 (1 => 2 , 2 => 2, 3 => 1, 4 => 1)
 
 2 3 4 1 2 (1 => 1 , 2 => 2, 3 => 1, 4 => 1)
 
 3 4 1 2 (1 => 1 , 2 => 1, 3 => 1, 4 => 1)
 
 4 1 2 (
 1(1 => 2 -> 1)(1)
 2(2 => 2 -> 1)(12)
 3(3 => 1 -> 0)(1 뺴고 
 
 */

//1 2 3 4 1 3 => 1 1 2 3 3 4 (ans : 3)

// 2 3 2 3 1 2 7 => 1 2 2 2 3 3 7 (ans : 2) ( 2(2) 23(3) 23(2) 23(3) 21(3->1) 21(2) 71(2-> 7) ) 2 23 232 2323 12323 712323

// 1 2 3 4 5 (ans : 3) ( 1(1) 12(
