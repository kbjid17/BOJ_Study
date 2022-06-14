package prob_에디터_1406_220614;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2th {
	static int N, idx;
	static StringBuilder sb = new StringBuilder();
	static Stack<String> s = new Stack<String>();
	static LinkedList<String> list = new LinkedList<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}
		int idx = str.length;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("L")) {
				if(idx > 0) {
					s.push(list.get(idx-1));
					list.remove(--idx);
				}
			}
			else if(cmd.equals("D")) {
				if(!s.isEmpty())
				list.add(idx++,s.pop());
			}
			else if(cmd.equals("B")) {
				if(idx > 0) {
					list.remove(--idx);
				}
			}
			else if(cmd.equals("P")) {
				list.add(idx++,st.nextToken());
			}
		}
		
		while(!s.isEmpty()) {
			list.add(idx++,s.pop());
		}
		
		for (String s : list) {
			sb.append(s);
		}
		System.out.println(sb.toString());
		
	}

}
