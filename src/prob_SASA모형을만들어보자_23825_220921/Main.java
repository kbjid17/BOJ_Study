package prob_SASA모형을만들어보자_23825_220921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(a <= b ? a/2 : b/2);

	}

}
