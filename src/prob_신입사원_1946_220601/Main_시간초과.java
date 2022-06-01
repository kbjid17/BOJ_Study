package prob_신입사원_1946_220601;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_시간초과 {
	static int T,N,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			int[][] ar = new int[N][2];
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				ar[j] = new int[] {paper,interview};
			}
			Arrays.sort(ar, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] >o2[0]) return 1;
					else return -1;
				}
			});
			
			for (int j = 0; j < N; j++) {
				int score_p = ar[j][0];
				int score_i = ar[j][1]; // 이 두 성적을 기준으로
				boolean pass = true;
				for (int k = 0; k < j; k++) {
					int other_p = ar[k][0];
					int other_i = ar[k][1];
					if(score_p > other_p && score_i > other_i) pass = false;
				}
				if(pass) {
					System.out.println(score_p + " " + score_i);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

}
