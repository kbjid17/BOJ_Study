package prob_리모컨_1107_220218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	static String N;
	static int M, ch = 100,cnt1,cnt2 = Integer.MAX_VALUE;
	static int [] ar;
	static String[] tgt;
	static boolean[] numb = new boolean[10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		M = Integer.parseInt(br.readLine());
		if(M > 0) {
			ar = new int[M];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
				numb[ar[i]] = true;
			}
		}
		if(ch != Integer.parseInt(N)) { //번호를 찾을 떄까지 계산 진행
			cnt1 = Math.abs(ch-Integer.parseInt(N));
			int a = N.length();
			for (int i = a-1; i <= a+1; i++) {
				if(i <= 0) continue;
				tgt = new String[i];
				comb(0,i);	
			}
		}
		System.out.println(Math.min(cnt1, cnt2));
	}
		static void comb(int tgtIdx,int i) {
			if(tgtIdx == i) {
				String a = "";
				for (int j = 0; j < tgt.length; j++) {
					a += tgt[j];
				}
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
