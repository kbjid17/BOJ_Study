package prob_인간컴퓨터상호작용_16139_220624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_50점 {
	static char[] str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine().toCharArray();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char word = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			for (int j = start; j <= end; j++) { // 시간초과 발생
				if(str[j] == word) ans++;
			}
			System.out.println(ans);
		}
	}
}
