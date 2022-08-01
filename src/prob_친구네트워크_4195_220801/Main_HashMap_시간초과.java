package prob_친구네트워크_4195_220801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_HashMap_시간초과 {
	static HashMap<String,ArrayList<String>> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			map = new HashMap<String,ArrayList<String>>();
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String fr = st.nextToken();
				String frr = st.nextToken();
				if(!map.containsKey(fr)) {
					map.put(fr, new ArrayList<String>());
					map.get(fr).add(fr);
				}
				if(!map.containsKey(frr)) {
					map.put(frr, new ArrayList<String>());
					map.get(frr).add(frr);
				}
				for (String s : map.get(frr)) {
					if(!map.get(fr).contains(s)) {
						map.get(fr).add(s);
					}
				}
				for (String s : map.get(fr)) {
					if(!map.get(frr).contains(s)) {
						map.get(frr).add(s);
					}
				}
				
				System.out.println(map.get(fr).size());
			}
		}
	}

}
