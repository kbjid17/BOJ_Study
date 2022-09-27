package prob_카드뽑기_16204_220927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int b_x = a-b;
		int c_x = a-c;
		
		if(b == c) System.out.println(a);
		else if(b == 0 || c == 0) System.out.println(0);
		else {
			if(b > c) {
				System.out.println(c + b_x);
			}
			else if(b < c) {
				System.out.println(b + c_x);
			}
		}
	}

}
