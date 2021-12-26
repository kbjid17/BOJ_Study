package prob_신나는함수실행_9184;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int a,b,c;
	static int[][][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ar = new int[101][101][101];
		
		//-50 ~ 50까지!
		// 21 0 0의 경우
		// a 가 20보다 크지만, b와 c가 0이므로 ar[21][0][0] = 1;
		// 우선순위가 적용된다.
		// a,b,c가 0보다 작으면  1 // a,b,c 중 하나가 20보다 크면 dp[20][20][20]
		// a< b && b < c이면 조건 적용(19 20 21 이면?)
		for (int i = 0; i <= 20; i++) {
			ar[i+50][i+50][i+50] = (int) Math.pow(2, i); // (*point) 19 20 21과 같은 수를 돌릴 때는 20 20 20이 선언되지 않은 상황이기 때문에 0이 출력될 수 있음
			//그렇기에 0 0 0 ~20 20 20 까지는 미리 선언해둬야 함!
		}
		
		for (int a = 0; a < 101; a++) {
			for (int b = 0; b < 101; b++) {
				for (int c = 0; c < 101; c++) {
					if(a <= 50 || b <= 50 || c <= 50)
						ar[a][b][c] = 1;
					else if(a > 70 || b > 70 || c > 70) {
						// 세 수 모두 0보다는 크며, 각 수 중 하나가 20을 넘어갈 경우
						ar[a][b][c] = ar[70][70][70];
					}
						
					else if(a < b && b < c) {
						if(a == 69 && b == 70 && c == 71) {
							System.out.println(a + " " + b + " " + c + "222222");
						}
						ar[a][b][c] = ar[a][b][c-1] + ar[a][b-1][c-1] - ar[a][b-1][c];
					}
					else
						ar[a][b][c] = ar[a-1][b][c] + ar[a-1][b-1][c] + ar[a-1][b][c-1] - ar[a-1][b-1][c-1];
				}
			}
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			
			System.out.print("w("+a+", "+b+", "+c+") = ");
			if(a <= 0) a = 0;
			if(b <= 0) b = 0;
			if(c <= 0) c = 0;
			System.out.println(ar[a+50][b+50][c+50]);
		}
	}
}