package prob_카드게임_5522_220219;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a;
		}
		System.out.println(sum);
	}

}
