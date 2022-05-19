package prob_sitescore_20254_220519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 56*Integer.parseInt(st.nextToken());
		int b = 24*Integer.parseInt(st.nextToken());
		int c = 14*Integer.parseInt(st.nextToken());
		int d = 6*Integer.parseInt(st.nextToken());
		
		System.out.println(a + b + c + d);
	}

}
