package prob_듣보잡_1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M,num;
	static HashSet<String> a = new HashSet<String>();
	static ArrayList<String> c = new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			a.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(a.contains(str)) c.add(str);
		}
		Collections.sort(c);
		System.out.println(c.size());
		for (String s : c) {
			System.out.println(s);
		}
	}

}
