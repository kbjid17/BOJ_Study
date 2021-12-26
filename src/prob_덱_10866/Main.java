package prob_덱_10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> d = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "push_back" :
				d.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "push_front" :
				d.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				if(d.isEmpty()) sb.append(-1).append("\n");
				else {
					sb.append(d.pollFirst()).append("\n");
				}
				break;
			case "pop_back" :
				if(d.isEmpty()) sb.append(-1).append("\n");
				else {
					sb.append(d.pollLast()).append("\n");
				}
				break;
			case "size" :
				sb.append(d.size()).append("\n");
				break;
			case "empty" :
				if(d.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front" :
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.peekFirst()).append("\n");
				break;
			case "back" :
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.peekLast()).append("\n");
				
			}
			
		}
		System.out.println(sb);
	}

}
