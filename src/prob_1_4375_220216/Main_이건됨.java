package prob_1_4375_220216;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_이건됨 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, a, len;
		
		String str = null;
		while( (str = br.readLine()) != null ) {
			n = Integer.parseInt( str );
			a = 1;
			len = 1;
			
			while( true ) {
				if( a%n == 0 ) break;
				len++;
				a = ((a * 10)+1) % n;
			}
			System.out.println(len);
		}
	}
}
