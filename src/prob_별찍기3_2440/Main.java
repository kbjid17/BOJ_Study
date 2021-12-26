package prob_별찍기3_2440;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n-i; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i; j++) {
				sb.append('*');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
//202
	//kbjid17@naver.com
}