package prob_체스판조각_3004_220220;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[101];
		
		int cnt = 1;
		for (int i = 1; i <= 100; i++) {
			if(i %2 != 0) {
				cnt++;
				ans[i] = cnt * (cnt-1);
			}
			else {
				ans[i] = cnt * cnt;
			}
		}
		
		System.out.println(ans[n]);
	}

}
