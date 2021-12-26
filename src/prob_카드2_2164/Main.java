package prob_카드2_2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while(queue.size() > 1) {
			queue.poll();
			int a = queue.poll();
			queue.offer(a);
		}
		System.out.println(queue.poll());
	}

}
