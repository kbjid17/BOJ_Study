package prob_에디터_1406_220614;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, idx;
	static LinkedList<String> list = new LinkedList<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}
		idx = str.length;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("L")) {
				if(idx > 0) idx--;
			}
			else if(cmd.equals("D")) {
				if(idx < list.size()) idx++;
			}
			else if(cmd.equals("B")) {
				if(idx > 0) {
					list.remove(--idx);
				}
			}
			else if(cmd.equals("P")) {
				String word = st.nextToken();
				
				list.add(idx++,word);
				
				
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

}
