package prob_문자열폭발_9935_220808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<String> s = new Stack<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		String[] sbss = str.split("");
		for (int i = 0; i < sbss.length; i++) {
			s.push(sbss[i]);
			if(s.size() >= bomb.length()) {
				int cnt = 0;
				for (int j = bomb.length(); j >= 1; j--) {
					if(s.get(s.size()-j).equals(bomb.substring(bomb.length()-j, bomb.length()-j+1))) {
//						System.out.println(bomb.subSequence(bomb.length()-j,bomb.length()-j+1));
						cnt++;
					}
					else {
						cnt = 0;
						break;
					}
				}
				if(cnt == bomb.length()) {
					while(cnt > 0) {
						s.pop();
						cnt--;
					}
				}
			}
		}
		if(s.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			while(!s.isEmpty()) {
				sb.append(s.pop());
			}
		}
		sb.reverse();
		System.out.println(sb.toString());
	}

}
