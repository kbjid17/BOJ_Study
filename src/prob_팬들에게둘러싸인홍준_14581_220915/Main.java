package prob_팬들에게둘러싸인홍준_14581_220915;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[][] ar = new String[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ar[i][j] = ":fan:";
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ar[1][1] = ":" + br.readLine() + ":";
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
	}

}
