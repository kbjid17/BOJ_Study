package prob_AC_5430_220123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static Deque<Integer> d;
	static StringBuilder sb = new StringBuilder();
	static int rev;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 R : 배열에 있는 수의 순서를 뒤집음
		 D : 첫번째 수를 버리는 함수(배열이 비어있는데 D를 사용하면 에러 발생)
		 */
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			rev = 0;
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"[,]"); //이게 되네
			d = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				d.offer(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < p.length; i++) {
				if(p[i] == 'R') {
					rev ^= 1;
				}
				else if(p[i] == 'D') {
					if(d.size() == 0) {
						sb.append("error").append("\n");
						break;
					} else {
						switch(rev) {
						case 0: //뒤집히지 않은 상태
							d.pollFirst();
							break;
						case 1: // 뒤집한 상태
							d.pollLast();
							break;
						}
					}
				}
				if(i == p.length-1) {
					if(d.size() == 0) {
						sb.append("[]").append("\n");
						break;
					}
					switch(rev) {
					case 0: // 뒤집히지 않은 상태
						sb.append("[").append(d.poll());
						while(!d.isEmpty()) {
							sb.append(",").append(d.poll());
						}
						
						break;
					case 1: // 뒤집힌 상태
						sb.append("[").append(d.pollLast());
						while(!d.isEmpty()) {
							sb.append(",").append(d.pollLast());
						}
						
						break;
					}
					sb.append("]").append("\n");
				}
			}
			
			
		}
		System.out.println(sb);
	}
}
