package prob_신나는함수실행_9184;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a,b,c;
	static int[][][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ar = new int[51][51][51];
		// 21 0 0의 경우
		// a 가 20보다 크지만, b와 c가 0이므로 ar[21][0][0] = 1;
		
		//
		for (int a = 0; a < 51; a++) {
			for (int b = 0; b < 51; b++) {
				for (int c = 0; c < 51; c++) {
					if(a <= 0 || b <= 0 || c <= 0) {
						ar[a][b][c] = 1;
					}
					if(a > 20 || b > 20 || c > 20) // 세 수 모두 0보다는 크며, 각 수 중 하나가 20을 넘어갈 경우
						ar[a][b][c] = ar[20][20][20];
					
					if(a < b && b < c)
						ar[a][b][c] = ar[a][b][c-1] + ar[a][b-1][c-1] - ar[a][b-1][c];
					
					if(!(a <= 0 || b <= 0 || c <= 0) && !(a > 20 || b > 20 || c > 20) && !(a < b && b < c))
						ar[a][b][c] = ar[a-1][b][c]+ar[a-1][b-1][c]+ar[a-1][b][c-1]-ar[a-1][b-1][c-1];
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

			System.out.println(ar[a][b][c]);
		}
	}
}