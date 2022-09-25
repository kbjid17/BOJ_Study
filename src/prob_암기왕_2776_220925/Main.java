package prob_암기왕_2776_220925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Integer> s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			s = new HashSet<Integer>();
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				s.add(Integer.parseInt(st.nextToken()));
			}
			int m = Integer.parseInt(br.readLine());
			st =  new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(s.contains(num)) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
		}

	}

}
