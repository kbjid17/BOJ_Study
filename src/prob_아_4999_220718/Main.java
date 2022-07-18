package prob_아_4999_220718;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String c = br.readLine();
		String d = br.readLine();
		
		if(c.length() >= d.length()) System.out.println("go");
		else System.out.println("no");
	}

}
