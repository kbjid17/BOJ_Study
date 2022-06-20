package prob_문서검색_1543_220620;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str=  br.readLine(); // 전체 문서
		String sttr = br.readLine(); // 찾고자 하는 단어
		
		for (int i = 0; i < str.length()-(sttr.length()-1); i++) {
			String word = str.substring(i, i+sttr.length());
			if(word.equals(sttr)) {
				ans++;
				i += sttr.length()-1;
			}
		}
		System.out.println(ans);
	}

}
