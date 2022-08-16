package prob_FootballScoring_24736_220816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] ar = new int[2][5];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
			ans = ar[i][0]*6 + ar[i][1]*3 + ar[i][2]*2 + ar[i][3]*1 + ar[i][4]*2;
			sb.append(ans).append(" ");
		}
		
		System.out.println(sb);
	}

}
