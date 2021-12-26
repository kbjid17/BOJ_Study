package prob_가운데를말해요_1655_미룸;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int N;

	static PriorityQueue<Integer> queue_min = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			queue_min.offer(a);
			System.out.println(queue_min.toString());
			
//			가운뎃 값이 1순위가 되어야 함!
		}
		
	}
}