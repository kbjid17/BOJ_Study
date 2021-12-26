package prob_괄호_9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static Stack<Character> stack;
	static int a,b;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			stack = new Stack<Character>();
			String[] str = br.readLine().split("");
			for (int j = 0; j < str.length; j++) {
				if(str[j].equals("(")) {
					stack.push('(');
				} 
				else if(str[j].equals(")")) {
					if(stack.isEmpty()) {
						System.out.println("NO");
						break;
					}
					stack.pop();
				}
				if(j == str.length-1) {
					if(stack.isEmpty()) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}
		}
			
	}

	}	
	}
