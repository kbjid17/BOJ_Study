package prob_단어수학_1339_220611;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static char[][] words;
	static long cnt;
	static boolean[] isSelected = new boolean[10];
	static int scale;
	static int[] map = new int[27];
	static int[] tgt;
	static ArrayList<Integer> idxlist = new ArrayList<Integer>();
	static long ans = Long.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 완탐 접근 -> 시간초과 발생
		N = Integer.parseInt(br.readLine());
		words = new char[N][];
		scale = 0; // 등장한 문자의 개수
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine().toCharArray(); // 단어들을 입력받고, 해당 단어에 값이 들어갈 수 있도록 만들어줌
			for (int j = 0; j < words[i].length; j++) {
				if(map[words[i][j]-'A'] == 0) {
					map[words[i][j]-'A'] = 1; // 해당 문자가 있다는 걸 기억시킴
					scale++;
				}
			}
		}
		tgt = new int[26];
		int idx = 0;
		for (int i = 0; i < map.length; i++) {
			if(map[i] != 0) { // 해당 문자가 있다면 => 값을 넣을 수 있는 index를 기억시켜야 함.
				idxlist.add(i);
			}
		}
		
		perm(0);
//		System.out.println(cnt);
		System.out.println(ans);
	}
	
		static void perm(int tgtIdx) {
			if(tgtIdx == scale) { // 각 알파벳의 값을 정했다면
				cnt++;
				long newAns = 0;
//				System.out.println("이번에는 ");
				for (int i = 0; i < N; i++) {
					String parser = "";
					for (int j = 0; j < words[i].length; j++) {
//						System.out.println(words[i][j] +"= "+tgt[words[i][j]-'A']);
						parser += Integer.toString(tgt[words[i][j]-'A']);
					}
					newAns += Integer.parseInt(parser);
					
				}
				ans = Math.max(ans, newAns);
				return;
			}
			
//			for (int i = srcIdx; i < 10; i++) {
//				tgt[idxlist.get(tgtIdx)] = i; // 해당 알파벳에 값을 집어넣음
//				perm(i+1,tgtIdx+1);
//			}
			
			for (int i = 0; i < 10; i++) {
				if(isSelected[i]) continue;
				
				tgt[idxlist.get(tgtIdx)] = i;
				isSelected[i] = true;
				perm(tgtIdx+1);
				isSelected[i] = false;
			}
		}

}
