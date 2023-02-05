package prob_대표값2_2587_221218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] ar = new int[5];
		int avg = 0;
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(br.readLine());
			avg += ar[i];
		}
		Arrays.sort(ar);
		
		System.out.println(avg/5);
		System.out.println(ar[2]);
	}

}
