package prob_멀티탭스케줄링_1700_220628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,K;
	static int[] ar;
	static boolean[] select;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
		ar = new int[K];
		select = new boolean[K];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			if(list.contains(ar[i])) continue; 
			if(list.size() < N) {
				list.add(ar[i]);
			}
			else {

					for (int j = 0; j < list.size(); j++) { 
						boolean use = false;
						for (int k = i+1; k < ar.length; k++) { 
							if(ar[k] == list.get(j)) {
								use = true;
								break;
							}
						}
						if(!use) { 
							list.remove(list.indexOf(list.get(j)));
							list.add(ar[i]);
							cnt++;
							break;
						}
						
						if(j == list.size()-1 && use) {
							int latest = 0; int idx = 0; 
							for (int k = 0; k < list.size(); k++) {
								for (int l = i+1; l < ar.length; l++) {
									if(list.get(k) == ar[l]) {
										if(idx < l) { // 가장 늦는 인덱스를 갱신
											idx = l;
											latest = ar[l];
										}
										break;
									}
								}
							} 
							list.remove(list.indexOf(latest));
							list.add(ar[i]);
							cnt++;
						}
					}
				
			}
		}
		System.out.println(cnt);
	}
}
