package prob_그룹단어체커_1316_221213;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int T = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < T; i++) {
			
			String str = br.readLine();
			if(str.length() == 1) { // 문자의 길이가 1 : 무조건 그룹단어
				result++;
				continue;
			}
			char[] ar = str.toCharArray();
			
//			String[] sss = str.split("");
			int[] alp = new int[27]; //a~z까지.
			
			for (int j = 0; j < ar.length; j++) {
				
				if(alp[ar[j]-'a' + 1] == 2) {
//					System.out.println(alp[ar[j]-'a' + 1]);
					break;
				}
				
				// 그룹 단어가 유지될 조건 : 처음 만날 때, 다음 문자가 현재 문자와 같을 때
				if(alp[ar[j]-'a' + 1] == 0 || alp[ar[j]-'a' + 1] == 1) {
					alp[ar[j]-'a' + 1] = 1;
				}
				
				// 그룹 단어가 아닐 조건 : 이전에 만났고 헤어진 단어를 다시 만날 때
				if(j >= 1) {
//					System.out.println(ar[j-1] + " " + ar[j]);
					if(ar[j-1] != ar[j]) {
//						System.out.println(ar[j-1]);
						alp[ar[j-1]-'a' + 1] = 2;
					}
				}
				
				if(j == ar.length-1) {
					result++;
				}
			}
			
		}
		
		System.out.println(result);
	}
}