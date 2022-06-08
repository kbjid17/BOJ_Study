package prob_문자열집합_14425_220608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans;
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			if(map.containsKey(br.readLine())) ans++;
		}
		System.out.println(ans);
	}
}