package prob_쇠막대기_10799_220607;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Character> s = new Stack<Character>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		char[] ar = br.readLine().toCharArray();
		int d = -1;
		int open = 0;
		
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] =='(') {
				s.push('(');
			}
			else if(ar[i] == ')') {
				if(ar[i-1] == '(') {
					s.pop();
					ans += s.size();
				}
				else if(ar[i-1] == ')') {
					ans +=1;
					s.pop();
				}
			}
		}
		System.out.println(ans);
	}

}
