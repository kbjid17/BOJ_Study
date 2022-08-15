package prob_LCS2_9252_220813_실패_왜안됨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2 {
	static String[] c1;
	static String[] c2;
	static int[][] dp = new int[1001][1001];
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		c1 = br.readLine().split("");
		c2 = br.readLine().split("");
		
		String ans = solve();
		
		System.out.println(ans.length());
		if(ans.length() != 0) {
			System.out.print(ans);
		}

	}

	
	static String solve() {
		
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if(c1[i].equals(c2[j])) dp[i+1][j+1] = dp[i][j]+1;
				else dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}
		
//		for (int i = 0; i <= c1.length; i++) {
//			for (int j = 0; j <= c2.length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int y = c1.length;
		int x = c2.length;
		String str = "";
		Stack<String> s = new Stack<String>();
		while(y != 0 && x != 0) {
			if(c1[y-1].equals(c2[x-1])) {
//				str += c1[y-1];
				s.push(c1[y-1]);
			}
			
			if(dp[y-1][x] == dp[y][x]) {
				y -=1;
			}
			else if(dp[y][x-1] == dp[y][x]) {
				x -=1;
			}
			else {
				y -=1;
				x -=1;
			}
		}
		
		String ans = "";
//		for (int i = str.length()-1; i >= 0; i--) {
//			ans += str.charAt(i);
//		}
		while(!s.isEmpty()) {
			ans += s.pop();
		}
		
		return ans;
	}
}
