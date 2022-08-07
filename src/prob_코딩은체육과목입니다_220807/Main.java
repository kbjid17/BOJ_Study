package prob_코딩은체육과목입니다_220807;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while(n > 0) {
			sb.append("long ");
			n-=4;
		}
		sb.append("int");
		System.out.println(sb);

	}

}
