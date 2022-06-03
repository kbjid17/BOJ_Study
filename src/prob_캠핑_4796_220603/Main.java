package prob_캠핑_4796_220603;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,L,P,V; // 테스트 케이스 T, 연속하는 P일 중, L일만 사용할 수 있음
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			T++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken()); // L일만 사용할 수 있음
			P = Integer.parseInt(st.nextToken()); // 연속하는 P일 중
			V = Integer.parseInt(st.nextToken()); // 총 휴가 일수
			if(L == 0 && P == 0 && V == 0) break;
			int day = 0;
			while(V > 0) {
				if(V < P) {
					if(V < L) {
						day += V;
						V = 0;
					}
					else  {
						day += L;
						V = 0;
					}
				}
				else {
					day += L;
					V -= P;
				}
			}
			System.out.println("Case " + T + ": " + day);
		}

	}

}
