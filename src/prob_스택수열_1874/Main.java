package prob_스택수열_1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> stack_b = new Stack<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int num = 0;
		stack_b.push(0);
		for (int i = 0; i < N; i++) {
			int a = stack.push(Integer.parseInt(br.readLine()));
				if(a < stack_b.peek()) {
					System.out.println("NO");
					return;
				}
				while(a>num) {
					stack_b.push(++num);
					sb.append("+").append("\n");
				}	
			if(a == stack_b.peek()) {
				stack_b.pop();
				sb.append("-").append("\n");
				continue;
			}
		}
		System.out.println(sb);
		//스택 A에 값을 넣은 후 
		//4가 들어왔다면 1부터 4까지 넣은 후(+ 4번) 4를 뺌(- 한번)
		//처음 push된 값이 4면 => 다른 스택에 push를 4번 진행하고(1,2,3,4) pop 연산을 진행
		// pop 연산이 진행됐으면 스택 A에 다음 수를 넣음
		// 3이 들어왔네. B스택은 1부터 순서대로 값이 들어오므로 A스택에 나온 다음 수가 B스택의 루트보다 같으면 바로 pop, 크면 push 후 pop, 작으면 NO 출력하고 끝내기
		// ex. A 값이 2인데, B의 pop될 값이 3 => 불가능
		
	}

}
