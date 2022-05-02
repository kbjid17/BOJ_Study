package prob_IOIOI_5525_220411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Bruteforce_30 {
	static int n,m,ans;
	
	static String[] str;
	static String c = ""; //d는 c에 맞춰야 함
	static StringBuilder d = new StringBuilder(); //검사할 문자열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		str = br.readLine().split("");
		int a = 1;// 문자열 변경 start
		
		
		for (int i = 0; i < (2*n+1); i++) {
			d.append(str[i]);
			if(i %2 == 0) {
				c += "I";
			}
			else if(i %2 != 0) {
				c += "O";
			}
		}
		if(d.toString().equals(c)) {
			ans++;
		}
		
		while(a <= m-(2*n+1)) {
//			d.char
//			for (int i = a; i < a+(2*n+1); i++) {
//				if((i-a) % 2 == 0) {
//					if(!str[i].equals("I")) {
//						ans--;
//						break;
//					}
//				}
//				else if((i-a) % 2 != 0) {
//					if(!str[i].equals("O")) {
//						ans--;
//						break;
//					}
//				}
//			} --> 50점
			
			d.deleteCharAt(0);
			d.append(str[a+2*n]);
			
			if(d.toString().equals(c))
			ans++;
			a++;
		}
		System.out.println(ans);
	}

}
