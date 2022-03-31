package prob_꼬마정민_11382_220330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long a,b,c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a=  Long.parseLong(st.nextToken());
		b=  Long.parseLong(st.nextToken());
		c=  Long.parseLong(st.nextToken());
		
		System.out.println(a + b + c);
	}

}
