package prob_배고픈아리의샌드위치구하기_25166_220920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()); // 샌드위치 가격
		int b = Integer.parseInt(st.nextToken()); // 쿠기 재산
		
		if(a < 1024) {
			System.out.println("No thanks");
		}
		else {
			a-=1023;
			if((a & b) == a) {
				System.out.println("Thanks");
			}
			else {
				System.out.println("Impossible");
			}
		}
	}

}
