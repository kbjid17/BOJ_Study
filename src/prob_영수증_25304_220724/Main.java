package prob_영수증_25304_220724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int amount = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int quantity = Integer.parseInt(st.nextToken());
			
			amount -= (price * quantity);
			if(amount < 0) {
				System.out.println("No");
				return;
			}
		}
		if(amount != 0) {
			System.out.println("No");
		}
		else System.out.println("Yes");
	}

}
