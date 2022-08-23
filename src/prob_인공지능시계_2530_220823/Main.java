package prob_인공지능시계_2530_220823;

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
		int time = Integer.parseInt(br.readLine());
		
		c += time;
		while(c >= 60) {
			c -= 60;
			b += 1;
		}
		while(b >= 60) {
			b -= 60;
			a +=1;
		}
		while(a >= 24) {
			a -= 24;
		}
		
		System.out.println(a + " " + b + " " + c);
		
		
		
	}

}
