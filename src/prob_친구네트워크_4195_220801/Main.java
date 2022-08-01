package prob_친구네트워크_4195_220801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static HashMap<String,String> map;
	static HashMap<String,Integer> friend_num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int f = Integer.parseInt(br.readLine());
			parents = new int[f+1];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			map = new HashMap<String,String>();
			friend_num = new HashMap<String,Integer>();
			for (int i = 0; i < f; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				String fr = st.nextToken();
				String frr = st.nextToken();
				if(!map.containsKey(fr)) {
					map.put(fr, fr);
					friend_num.put(fr, 1);
				}
				if(!map.containsKey(frr)) {
					map.put(frr, frr);
					friend_num.put(frr, 1);
				}
				union(fr,frr);
				System.out.println(friend_num.get(map.get(fr)));
			}
			
		}
	}
	
	static String find(String fr)  {
		if(fr.equals(map.get(fr))) return fr;
//		System.out.println(fr);
//		System.out.println("find "+fr + " " + map.get(fr));
		map.put(fr, find(map.get(fr)));
		return map.get(fr);
	}

	static boolean union(String a, String b) {
		String aRoot = find(a);
		String bRoot = find(b);
		if(aRoot.equals(bRoot)) {
//			System.out.println(aRoot + " " + bRoot + "가 같네");
			return false;
		}
//		System.out.println("대표값은 " +aRoot + " " + bRoot);
		map.put(bRoot, aRoot);
		friend_num.put(aRoot, friend_num.get(aRoot) + friend_num.get(bRoot));
//		System.out.println(bRoot + "의 대푯값 :  " + aRoot);
		return true;
	}
}
