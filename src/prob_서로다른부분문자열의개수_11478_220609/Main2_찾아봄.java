package prob_서로다른부분문자열의개수_11478_220609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main2_찾아봄 {
	static String str;
	static String[] tgt;
	static int ans;
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j <= str.length(); j++) {
				if(i == j) continue;
				String sttr = str.substring(i,j); // subString : i번 문자열부터 j-1번 문자열까지 가져옴
				if(!map.containsKey(sttr) && sttr.length() <= 1000) {
					map.put(sttr, 1);
				}
			}
		}
		System.out.println(map.size());
	}

}
