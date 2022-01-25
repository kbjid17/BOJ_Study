package prob_다리놓기_1010_220125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			long ans = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 서쪽 지점
			int b = Integer.parseInt(st.nextToken()); // 동쪽 지점
			//bCa
			for (int j = b-a; j < b; j++) {
				ans *= (j+1);
				ans /= (j+a-b+1);
			}
			System.out.println(ans);
		}
	}
}