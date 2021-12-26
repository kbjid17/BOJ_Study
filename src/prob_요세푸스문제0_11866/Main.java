package prob_요세푸스문제0_11866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		sb.append("<");
		int cnt = 0;
		while(cnt < N) {
			int a = 0;
			for (int i = 0; i < K; i++) {
				a = queue.poll();
				if(i < K-1)
				queue.offer(a);
			}
			if(cnt == 0) {
				sb.append(a);
			}
			else if(cnt > 0) {
				sb.append(", ").append(a);
			}
			cnt++;
		}
		sb.append(">");
		System.out.println(sb);
	}

}
