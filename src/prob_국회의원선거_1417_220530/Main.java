package prob_국회의원선거_1417_220530;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static int N,me,ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 현재 내 예상 득표수가 얼마인지, 예상되는 최대 득표수가 얼마인지를 계산
		// 최대 득표자 수 == 내 예상 득표자 수면 끝.
		
		for (int i = 1; i <= N; i++) {
			if(i == 1) me= Integer.parseInt(br.readLine());
			else {
				pq.offer(Integer.parseInt(br.readLine()));
			}
		}
		if(N == 1) {
			ans = 0;
		}
		else {
			while(me <= pq.peek()) {
				me++;
				int sub = pq.poll()-1;
				if(sub < 0) sub = 0;
				pq.offer(sub);
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
