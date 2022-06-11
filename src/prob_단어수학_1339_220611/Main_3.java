package prob_단어수학_1339_220611;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_3 {
	static int N;
	static char[][] str;
	static int[] word_value = new int[26];
	static Integer[] maxvalues = new Integer[26];
	static boolean[] selected = new boolean[26];
	static int maxvalue = Integer.MIN_VALUE;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = new char[N][];
		Arrays.fill(maxvalues, 0);
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine().toCharArray();
			for (int j = 0; j < str[i].length; j++) {
				word_value[str[i][j]-'A'] += (int)Math.pow(10,(str[i].length-1)-j);
				maxvalues[str[i][j]-'A'] = word_value[str[i][j]-'A'];
			}
		}
		
		Arrays.sort(maxvalues,Collections.reverseOrder());
		
		int cnt = 9;
		for (int i = 0; i < maxvalues.length; i++) {
			if(maxvalues[i] <= 0 || cnt <= -1) break;
			for (int j = 0; j < word_value.length; j++) {
				if(word_value[j] == maxvalues[i] && !selected[j]) {
					word_value[j] = cnt;
					selected[j] = true;
					cnt--;
					break;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < str[i].length; j++) {
				ans += word_value[str[i][j]-'A'] * Math.pow(10, str[i].length-1-j);
			}
		}
		System.out.println(ans);
	}

}
