package prob_전자레인지_10162_220324;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int A,B,C,T,ans = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		A = T/300;
		B = (T-(A*300))/60;
		C = (T-(A*300) -(B*60))/10;
		if(T - (A*300+B*60+C*10) > 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(A + " "  + B+ " " + C);
		}
		

	}

}
