package prob_가운데를말해요_1655_220524;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;

	static PriorityQueue<Integer> queue_min = new PriorityQueue<Integer>();	// 최소힙
	static PriorityQueue<Integer> queue_max = new PriorityQueue<Integer>(Collections.reverseOrder()); // 최대힙
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(i == 0) queue_max.offer(a); // 처음엔 max에 값을 넣고 시작
			else {
				if(queue_max.size() == queue_min.size()) {
					// 두 우선순위큐의 사이즈가 같으면
					if(a > queue_min.peek()) {	// 새로 넣을 값(a)이 최소힙의 최솟값(b)보다 클 경우 => 최소힙에서 값을 뺴고(b) a를 넣은 후, 최대힙에 b를 넣음
						int b = queue_min.poll();
						queue_min.offer(a);
						queue_max.offer(b);
					}
					else { // 위 조건이 부합되지 않으면 => 최대힙에 값을 넣음
						queue_max.offer(a);
					}
					
				}
				else if(queue_max.size() != queue_min.size()) {
					// 두 우선순위 큐의 사이즈가 다르다면
					if(a < queue_max.peek()) { //새로 넣을 값(a)이 최대힙의 최댓값(b)보다 작을 경우 => 최대힙에서 값을 빼고(b) a를 넣은 후, 최소힙에 b를 넣음
						int b = queue_max.poll();
						queue_max.offer(a);
						queue_min.offer(b);
					} 
					else { // 위 조건이 부합되지 않으면 => 최대힙에 값을 넣음
						queue_min.offer(a);
					}
				}
			}
//			가운뎃 값이 1순위가 되어야 함!
			sb.append(queue_max.peek()).append("\n");
		}
		System.out.println(sb);
	}
}