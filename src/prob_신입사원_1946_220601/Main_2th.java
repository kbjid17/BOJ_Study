package prob_신입사원_1946_220601;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2th {
	static int T,N,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			ans = 1;
			N = Integer.parseInt(br.readLine());
			
			int[][] ar = new int[N][2];
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				ar[j] = new int[] {paper,interview};
			}
			
			if(N == 1) {
				System.out.println(1);
				continue;
			}
			Arrays.sort(ar, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] >o2[0]) return 1;
					else return -1;
				}
			});
			int min_paper = ar[0][0];
			int min_interview = ar[0][1];
			for (int j = 1; j < N; j++) { // for문을 1번으로 줄임 => 해결
				if(min_paper > ar[j][0] || min_interview > ar[j][1]) {
					min_paper = ar[j][0];
					min_interview = ar[j][1];
//					System.out.println(min_paper + " " + min_interview);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

}
