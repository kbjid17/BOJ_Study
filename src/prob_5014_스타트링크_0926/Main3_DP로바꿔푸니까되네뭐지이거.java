package prob_5014_스타트링크_0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3_DP로바꿔푸니까되네뭐지이거 {

	static int F,S,G,U,D,count;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visit = new boolean[F+1];
		while(true) {
			if(count > 0 && visit[S]) {
				System.out.println("use the stairs");
				break;
			}
			else {
				visit[S] = true;
				if(S == G) {
					System.out.println(count);
					break;
				}
				else if((S < G | S-D < 1) && S + U <= F) {
					count++;
					S += U;
				}
				else if((S > G | S + U > F) && S - D >= 1) {
					count++;
					S -= D;
				}
			}
		}
	}
}