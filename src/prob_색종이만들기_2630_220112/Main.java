package prob_색종이만들기_2630_220112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int blue,white,bluep,whitep;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ar = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		solve(N,0,0,0,0);
		
		System.out.println(whitep);
		System.out.println(bluep);
		//색종이 입력을 마침
		//1~4사분면이 존재
	}
	static void solve (int size,int a,int b,int white,int blue) {
		for (int i = a; i < a+size; i++) {
			for (int j = b; j < b+size; j++) {
				if(ar[i][j] == 0) {
					white++;
				}
				else if(ar[i][j] == 1) {
					blue++;
				}
			}
		}
		if(white == 0) {
			bluep++;
		}
		else if(blue == 0) {
			whitep++;
		}
		else {
			solve(size/2,a,b,0,0);
			solve(size/2,a,b+size/2,0,0);
			solve(size/2,a+size/2,b,0,0);
			solve(size/2,a+size/2,b+size/2,0,0);
		}
	}
}

