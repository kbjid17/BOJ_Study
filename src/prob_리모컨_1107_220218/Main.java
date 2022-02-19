package prob_리모컨_1107_220218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 현 위치 : 100
// 고장난 버튼들을 제외하고 다른 버튼들을 눌러서 들어갈 수 있는 최소

public class Main {
	static String N;
	static int M, ch = 100,cnt1,cnt2 = Integer.MAX_VALUE;
	static int [] ar;
	static String[] tgt;
	static boolean[] numb = new boolean[10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//511111 -> 6번 입력
		//500000 -> 11111먼 입력
		N = br.readLine();
		M = Integer.parseInt(br.readLine());
		if(M > 0) {
			ar = new int[M];
//			System.out.println(Integer.MAX_VALUE);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
				numb[ar[i]] = true;
			}
		}
		if(ch != Integer.parseInt(N)) { //번호를 찾을 떄까지 계산 진행
			// 1. ch++ 계산
			// 2. ch-- 계산
			cnt1 = Math.abs(ch-Integer.parseInt(N));
			// 3. 새 숫자 만들기
			int a = N.length();
			for (int i = a-1; i <= a+1; i++) {
				if(i <= 0) continue;
				//i자리의 수를  중복조합으로 구해냄 -> 각 숫자별 목포값과의 차이를 찾음
				tgt = new String[i];
				comb(0,i);	
			}
		}
		
		System.out.println(Math.min(cnt1, cnt2));

	}
		static void comb(int tgtIdx,int i) { // i : 숫자 길이
			if(tgtIdx == i) {
				String a = "";
				for (int j = 0; j < tgt.length; j++) {
					a += tgt[j];
				} // 숫자를 구했으면
				// 해당 숫자를 만드는 데 버튼을 누른 횟수 + 목표값과 구해진 값의 차이
				cnt2 = Math.min(cnt2, tgt.length + Math.abs(Integer.parseInt(N)-Integer.parseInt(a)));
				return;
			}
			
			for (int j = 0; j < 10; j++) {
				if(numb[j]) continue;
				if(i >= 2 && tgtIdx == 0 && j == 0) continue;
				tgt[tgtIdx] = Integer.toString(j);
				comb(tgtIdx+1,i);
			}
			
		}
}
