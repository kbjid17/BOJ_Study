package prob_강의실배정_11000_220625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] ar = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar[i][0] = Integer.parseInt(st.nextToken());
			ar[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ar,(o1,o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
		// 시간 순 정렬 완료("회의실 배정" 문제 참고)
		// 완탐 : for문을 돌려 시간이 되는 강의들을 모두 방문 처리해주고, 모든 강의를 들을 때까지 전 과정을 반복해줌.(200000 * 200000)(O(n^2)) ==> 억이 넘어갈 수 있으므로 불가능.
		/*
		 강의들별로 그룹을 지정해줌.
		 ex. 1 3 // 2 4 // 3 5 ==> 1 3과 3 5는 1그룹 // 2 4는 2그룹
		 그룹 수를 출력해주면 끝.
		 
		 그렇다면 그룹을 어떻게 잡아줘야 할까?
		 완탐은 X.
		 
		 ==> 우선순위 큐를 선언
		 1) ar[0][0] (시작시간이 가장 빠른 강의의 종료시간)을 pq에 넣음
		 
		 2) 등록되지 않은 강의들을 for문으로 보면서, pq.peek()(pq 안의 강의들 가장 빠른 종료시간) <= i번 강의의 시작시간일 경우, 
		 새로운 그룹이 필요하다는 의미가 됨 => pq.poll() 처리 후
		 else 생략
		 위의 검사과정 진행 후, pq에 ar[i][1]을 삽입
		 (최소힙 pq 특성상 항상 최소시간이며, 
		 */
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(ar[i][0] + " " + ar[i][1]);
//		}
		
		int cnt = 0;
		pq.offer(ar[0][1]);
		
		for (int i = 1; i < n; i++) {
			if(pq.peek() <= ar[i][0]) {
				pq.poll();
			}
			pq.offer(ar[i][1]);
		}
		
		System.out.println(pq.size());
	}
}