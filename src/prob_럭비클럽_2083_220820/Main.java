package prob_럭비클럽_2083_220820;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("# 0 0")) return;
			String[] ar = str.split(" ");
			if(Integer.parseInt(ar[1]) > 17 || Integer.parseInt(ar[2]) >= 80) {
				System.out.println(ar[0] + " " + "Senior");
			}
			else {
				System.out.println(ar[0] + " " + "Junior");
			}
		}

	}

}
