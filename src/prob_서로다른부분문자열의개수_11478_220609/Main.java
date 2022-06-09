package prob_서로다른부분문자열의개수_11478_220609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static String[] str;
	static String[] tgt;
	static int ans;
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split("");
		for (int i = 1; i <= str.length; i++) {
			tgt = new String[i];
			comb(0,0,i);
		}
		System.out.println(ans);
	}
	static void comb(int srcIdx, int tgtIdx,int size) {
		if(tgtIdx == size) {

			String sttr = "";
			for (int i = 0; i < tgt.length; i++) {
				sttr += tgt[i];
			}
			if(!map.containsKey(sttr) && sttr.length() <= 1000) {
				map.put(sttr, 1);
				ans++;
			}
			return;
		}
		// 서로 옆에 붙어있어야 한다.
		for (int i = srcIdx; i < str.length; i++) {
			tgt[tgtIdx] = str[i];
			comb(i+1,tgtIdx+1, size);
		}
	}
}
