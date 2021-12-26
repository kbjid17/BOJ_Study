package prob_큐2_18258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int root = 0;
			switch(str) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				root = num;
				break;
			case "pop":
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
					root = queue.peek();
				}
				break;
			case "front" : 
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.peek());
				}
				break;
			case "back":
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(root);
				}
				break;
			case "size" :
				System.out.println(queue.size());
				break;
			case "empty" : 
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			}
		}
	}

}
