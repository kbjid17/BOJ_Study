package prob_1755_숫자놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	static String[] ar;
	static int M,N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //M부터 N까지의 수를 탐샘
		ar = new String[N-M+1];
	}

}
