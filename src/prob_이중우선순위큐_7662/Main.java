package prob_이중우선순위큐_7662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Integer> q;
	static PriorityQueue<Integer> q2;
	static int T,N;
	static Map<Integer,Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			q = new PriorityQueue<Integer>(); //최소 힙
			q2 = new PriorityQueue<Integer>(Collections.reverseOrder()); // 최대 힙
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				if(a.equals("I")) {
					map.put(b, map.getOrDefault(b, 0)+1);
					q.offer(b);
					q2.offer(b);
				}
				else if(a.equals("D")) {
					if(map.size() == 0) continue;
					delete(b);
				}
			}
			if(map.isEmpty()) System.out.println("EMPTY");
			else {
				int flag = delete(1);
				System.out.print(flag + " ");
				if(map.size() > 0) flag = delete(-1);
				System.out.println(flag);
			}
		}
	}
	static int delete(int n) {
		int flag = 0;
		switch(n) {
		case 1: // 최댓값 제거
			while(true) {
				flag = q2.poll();
				
				int cnt = map.getOrDefault(flag, 0);
				if(cnt == 0) continue;
				
				if(cnt == 1) map.remove(flag);
				else map.put(flag, cnt -1);
				break;
			}
			break;
		case -1 :
			while(true) {
				flag = q.poll();
				
				int cnt = map.getOrDefault(flag, 0);
				if(cnt == 0) continue;
				
				if(cnt == 1) map.remove(flag);
				else map.put(flag, cnt -1);
				break;
			}
		}
		return flag;
	}
}