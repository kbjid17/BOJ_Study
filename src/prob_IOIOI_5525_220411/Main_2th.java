package prob_IOIOI_5525_220411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2th {
	static int n,m,ans;
	

	static String[] str;
	static String c = ""; //d는 c에 맞춰야 함
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		str = br.readLine().split("");
		
		for (int i = 0; i < str.length-(n*2); i++) {
			if(str[i].equals("O")) continue;

			int cnt = 1;
			for (int j = i; j < i+(n*2); j+=2) {
				if(!(str[j+1]+str[j+2]).equals("OI")) {
					cnt = 0;
					break;
				}
			}
			ans += cnt;
		}
		
		System.out.println(ans);
	}

}
