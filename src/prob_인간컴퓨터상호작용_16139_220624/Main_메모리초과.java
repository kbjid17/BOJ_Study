package prob_인간컴퓨터상호작용_16139_220624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_메모리초과 {
	static String str;
	static int[][][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		int T = Integer.parseInt(br.readLine());
		
		ar = new int[26][str.length()][str.length()]; // 200,000 * 200,000 = 40,000,000,000(400억 -> 메모리 초과)
		
		/*
		 문자 26개를 보면서
		 0 0 ~ 문자 길이 문자 길이까지 하나씩 찾음
		w와 i가 정해지고, j가 변할 때 => 이전 값을 계승함 
		 만약 [j]번째 문자가 w라면 ar[w][i][j]++;
		 */
		// abcdef
			for (int i = 0; i < str.length(); i++) {
				for (int j = i; j < str.length(); j++) {

					if(i == j) { // 한 문자를 볼때 (a, e 등)
						ar[str.charAt(i)-'a'][i][j]++; //[w][i][j]++
					}
					else {
						for (int w = 0; w < 26; w++) {
							ar[w][i][j]+= ar[w][i][j-1];
							// str의 j번째 문자가 w+1번 알파벳이라면? => i~j 번 문자 사이의 w 알파벳의 개수를 +1
							if(str.charAt(j)-'a' == w) {
								ar[w][i][j]++;
							}
						}
					}
				}
			}
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char word = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(ar[word-'a'][start][end]);
		}
		
	}
}
