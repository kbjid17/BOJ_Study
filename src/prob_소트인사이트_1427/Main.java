package prob_소트인사이트_1427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		int[] ar= new int[num.length()];
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = num.charAt(i)-'0';
		}
		Arrays.sort(ar);
		for (int i = ar.length-1; i >= 0; i--) {
			System.out.print(ar[i]);
		}
		
	}

}
