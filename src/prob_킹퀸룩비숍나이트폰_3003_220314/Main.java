package prob_킹퀸룩비숍나이트폰_3003_220314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		int[] ar = new int[6];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] c = new int[6];
		c[0] = 1;
		c[1] = 1;
		c[2] = 2;
		c[3] = 2;
		c[4] = 2;
		c[5] = 8;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			sb.append(c[i]-ar[i]).append(" ");
		}
		System.out.println(sb);
	}

}
