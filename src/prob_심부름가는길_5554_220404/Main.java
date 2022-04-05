package prob_심부름가는길_5554_220404;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a= Integer.parseInt(br.readLine());
		int b= Integer.parseInt(br.readLine());
		int c= Integer.parseInt(br.readLine());
		int d= Integer.parseInt(br.readLine());
		
		a += b+c+d;
		
		int e = a/60;
		int f = a-(e*60);
		System.out.println(e);
		System.out.println(f);
	}

}
