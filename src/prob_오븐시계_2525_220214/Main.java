package prob_오븐시계_2525_220214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		// a시 b분
		int c = Integer.parseInt(br.readLine());
		b += c;
		while(b >= 60) {
			a+=1;
			b -= 60;
			if(a >= 24) {
				a -= 24;
			}
		}
		System.out.println(a + " " + b);
	}
	
}
