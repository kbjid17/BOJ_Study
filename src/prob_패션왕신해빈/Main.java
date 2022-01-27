package prob_패션왕신해빈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			Map<String, Integer> map = new HashMap<>();
			int a = Integer.parseInt(br.readLine());
			for (int j = 0; j < a; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 키워드 & 그룹
				st.nextToken();
				String b = st.nextToken();
				if(map.containsKey(b)) {
					map.put(b,map.get(b)+1);
				}
				else {
					map.put(b, 1);
				}
			}
			int ans = 1;
			for (Integer as : map.values()) {
				ans*= (as+1);
			}
			System.out.println(ans-1);
		}
	}

}
