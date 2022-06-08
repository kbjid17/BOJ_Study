package prob_문자열집합_14425_220608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_ArrayList {
	static int N,M,ans;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(list.contains(str)) ans++;
		}
		System.out.println(ans);
		
	}

}
