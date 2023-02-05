package prob_한수_1065_221212;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			String[] str = Integer.toString(i).split("");
			if(str.length < 3) cnt++;
			else {
				
				int num = 0;
				for (int j = 0; j < str.length-1; j++) {
					if(j > 0) {
						if(Integer.parseInt(str[j+1]) - Integer.parseInt(str[j]) != num) break;
					}
					if(j == str.length-2) cnt++;
					num = Integer.parseInt(str[j+1]) - Integer.parseInt(str[j]);
				}
			}
		}
		System.out.println(cnt);

	}

}
