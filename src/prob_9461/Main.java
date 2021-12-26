package prob_9461;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int a = s.nextInt();
			long[] ar = new long[a];
			for (int i = 0; i < a; i++) {
				if(i < 3 ) {
					ar[i] = 1;
				} else if(i  >=3) {
					ar[i] = ar[i-3] + ar[i-2];
				}
			}
			System.out.println(ar[a-1]);
			
		}

	}

}
