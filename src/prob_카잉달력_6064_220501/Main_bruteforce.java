package prob_카잉달력_6064_220501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bruteforce {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int point = Math.abs(M-N);
			// <M:N>
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// <x:y>
			
			int n1 = 1;
			int n2 = 1;
			// 브루트포스로 진행( 시간초과
			int cnt = 0;
			while(true) {
				if(n1 < M) {
					n1++;
				}
				else {
					n1 = 1;
				}
				if(n2 < N) {
					n2++;
				}
				else {
					n2 = 1;
				}
				cnt++;
//				System.out.println(n1 + " " + n2);
				
				if(n1 == x && n2 == y) {
					break;
				}
				else if(n1 == M && n2 == N) {
					if(n1 != x && n2 != y) {
						cnt = -2;
					}
					break;
				}
			}
			System.out.println(cnt+1);
		}
		
	}
}


/*



 */
