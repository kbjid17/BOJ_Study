package prob_전자레인지_14470_220909;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		int ans = 0;
		
		if(a <= 0) {
			ans += ((0-a)*c) + d;
//			System.out.println((a*c)+d);
			a = 0;
		}
		ans += (b-a) * e;
//		System.out.println((b-a)*e);
		System.out.println(ans);

	}

}
