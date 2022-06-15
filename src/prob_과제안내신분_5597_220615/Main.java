package prob_과제안내신분_5597_220615;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[] ar = new boolean[31];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 28; i++) {
			int a = Integer.parseInt(br.readLine());
			ar[a] = true;
		}
		
		for (int i = 1; i <= 30; i++) {
			if(!ar[i])
				System.out.println(i);
		}
	}

}
