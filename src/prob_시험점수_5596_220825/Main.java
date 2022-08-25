package prob_시험점수_5596_220825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ar = new int[2];
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				ar[i] += Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Math.max(ar[0], ar[1]));
	}

}
