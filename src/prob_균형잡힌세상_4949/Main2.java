package prob_균형잡힌세상_4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
	static Stack<Character> stack = new Stack<Character>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				return;
			}
			char[] ar = str.toCharArray();
			for (int i = 0; i < ar.length; i++) {
				if(ar[i] == ')') {
					if(stack.isEmpty() || stack.peek() == '[') {
						stack.push(ar[i]);
						break;
					}
					else if(stack.peek() == '(') {
						stack.pop();
						continue;
					}
				}
				else if(ar[i] == ']') {
					if(stack.isEmpty() || stack.peek() == '(') {
						stack.push(ar[i]);
						break;
					}
					else if(stack.peek() == '[') {
						stack.pop();
						continue;
					}
				}
				else if(ar[i] == '(') {
					stack.push(ar[i]);
				}
				else if(ar[i] == '[') {
					stack.push(ar[i]);
				}
			} 
			if(!stack.isEmpty()) {
				System.out.println("no");
			}
			else {
				System.out.println("yes");
			}
			stack.clear();
		}
	}
}