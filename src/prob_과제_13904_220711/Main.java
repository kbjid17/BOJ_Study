package prob_과제_13904_220711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<lecture> list = new LinkedList<lecture>();
		int score = 0;
		int term = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); // 과제 마감일까지 남은 일수
			int w = Integer.parseInt(st.nextToken()); // 과제의 점수
			list.add(new lecture(d,w,false));
			term = Math.max(term, d);
			
		}
		Collections.sort(list, new Comparator<lecture>() {

			@Override
			public int compare(lecture o1, lecture o2) {
				if(o1.d > o2.d) {
					return -1;
				}
				else if(o1.d == o2.d) {
					if(o1.w > o2.w) {
						return -1;
					}
				}
				return 0;
			}
		});
//		System.out.println(list.toString());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		while(term > 0) {
			
//			System.out.println("term : " + term);
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).d != term) continue;
				pq.offer(list.get(i).w);
			}
//			System.out.println(pq.toString());
			if(pq.size() > 0) {
				score += pq.poll();
			}
			--term;
		}
		// pq 선언
		// 
		System.out.println(score);
	}

	static class lecture {
		int d;
		int w;
		boolean l; // learned
		public lecture(int d, int w, boolean l) {
			super();
			this.d = d;
			this.w = w;
			this.l = l;
		}
		@Override
		public String toString() {
			return "lecture [d=" + d + ", w=" + w + ", l=" + l + "]";
		}
		
		
	}
}


// 30(5) 50(4) 40(2) 60(1) 5(7)

// 60 50 30 40 5
// 