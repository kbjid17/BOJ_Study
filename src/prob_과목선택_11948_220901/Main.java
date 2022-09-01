package prob_과목선택_11948_220901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ar_1 = new int[4];
		int[] ar_2 = new int[2];
		
		for (int i = 0; i < ar_1.length; i++) {
			ar_1[i] = Integer.parseInt(br.readLine());
		}
			
		for (int i = 0; i < ar_2.length; i++) {
			ar_2[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ar_1);
		Arrays.sort(ar_2);
		System.out.println(ar_1[3] + ar_1[2] + ar_1[1] + ar_2[1]);

	}

}
