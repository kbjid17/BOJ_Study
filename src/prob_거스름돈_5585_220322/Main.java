package prob_거스름돈_5585_220322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 1000 - Integer.parseInt(br.readLine());
		int[] ar = new int[6];
		ar[0] = 500;
		ar[1] = 100;
		ar[2] = 50;
		ar[3] = 10;
		ar[4] = 5;
		ar[5] = 1;
		int cnt = 0;
			for (int i = 0; i < ar.length; i++) {
				while(n >= ar[i]) {
					n-=ar[i];
					cnt++;
					if(n == 0) {
						System.out.println(cnt);
						return;
					}
				}
			}
		
	}

}
