package prob_나는야포켓몬마스터이다솜_1620_220128;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static Map<String,String> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String a = br.readLine();
			map.put(Integer.toString(i), a);
			map.put(a, Integer.toString(i));
		}
		for (int i = 1; i <= M; i++) {
			String b = br.readLine();
			System.out.println(map.get(b));
		}

	}

}
