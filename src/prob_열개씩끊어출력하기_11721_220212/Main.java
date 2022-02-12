package prob_열개씩끊어출력하기_11721_220212;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
//		System.out.println((int)Math.ceil((double)str.length()/10));
		String[] ar = new String[(int)Math.ceil((double)str.length()/10)];
		for (int i = 0; i < ar.length-1; i++) {
			ar[i] = str.substring(i*10, i*10+10);
		}
		ar[ar.length-1] = str.substring((ar.length-1)*10);
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
}
