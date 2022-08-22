package prob_뜨거운붕어빵_11945_220822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		for (int i = 0; i < a; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = c.length-1; j >=0  ; j--) {
				System.out.print(c[j]);
			}
			System.out.println();
		}

	}

}
