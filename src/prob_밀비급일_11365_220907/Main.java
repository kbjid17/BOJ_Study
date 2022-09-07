package prob_밀비급일_11365_220907;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		while(!str.equals("END")) {
			String[] sb = str.split("");
			for (int i = sb.length-1; i >= 0 ; i--) {
				System.out.print(sb[i]);
			}
			System.out.println();
			str = br.readLine();
		}

	}

}
