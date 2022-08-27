package prob_10부제_10797_220827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int day = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a == day) ++ans;
		}

		System.out.println(ans);
	}

}
