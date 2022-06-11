package prob_단어수학_1339_220611;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_2 {
	static int N;
	static char[][] str;
	static int[] word_value = new int[26];
	static Integer[] maxvalue = new Integer[26];
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = new char[N][];
		Arrays.fill(maxvalue, 0);
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine().toCharArray();
			for (int j = 0; j < str[i].length; j++) {
				word_value[str[i][j]-'A'] += (int)Math.pow(10,(str[i].length-1)-j);
				maxvalue[str[i][j]-'A'] = word_value[str[i][j]-'A'];
			}
		}
		
		Arrays.sort(maxvalue, Collections.reverseOrder());
		int cnt = 9;
		for (int i = 0; i < maxvalue.length; i++) {
			if(maxvalue[i] == 0) break;
			for (int j = 0; j < word_value.length; j++) {
				if(cnt ==-1) break;
				if(word_value[j] == maxvalue[i]) {
					word_value[j] = cnt;
					cnt--;
				}
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < str[i].length; j++) {
				ans += (word_value[str[i][j]-'A'] * (int)Math.pow(10, str[i].length-1-j));
			}
		}
		System.out.println(ans);
	}

}
