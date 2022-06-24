package prob_인간컴퓨터상호작용_16139_220624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String str;
	static int[][] ar;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		int T = Integer.parseInt(br.readLine());
		
		ar = new int[26][str.length()];
		
		ar[str.charAt(0)-'a'][0]++;
		for (int i = 1; i < str.length(); i++) {
			
				for (int j = 0; j < 26; j++) {
					ar[j][i]+= ar[j][i-1];
				}
			
			ar[str.charAt(i)-'a'][i]++;
		}
			
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char word = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(start == 0) {
				sb.append(ar[word-'a'][end]).append("\n");
			}
			else {
				sb.append(ar[word-'a'][end] - ar[word-'a'][start-1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
