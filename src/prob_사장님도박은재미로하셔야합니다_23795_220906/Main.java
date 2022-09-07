package prob_사장님도박은재미로하셔야합니다_23795_220906;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long ans = 0;
		int num = Integer.parseInt(br.readLine());
		while(num != -1) {
			ans += num;
			num = Integer.parseInt(br.readLine());
		}
		System.out.println(ans);
	}

}
