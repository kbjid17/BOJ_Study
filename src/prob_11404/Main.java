package prob_11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int a,b,c; //시작 도시 a, 도착 도시 b, 한번 타는 데 필요한 비용 c
	static int big = 100000001;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ar = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) continue;
				ar[i][j] =big;
			}
		}
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(ar[a-1][b-1] > c) ar[a-1][b-1] = c;
 		}
//		System.out.println(ar[1][3]);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(ar[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if(i == k) continue;
				for (int j = 0; j < n; j++) {
					if(j ==k || i == j) continue;
					// i-> j 비용과 [i -> k] + [k+j] 비용 비교
					// ar[i][j] : [i -> j] 비용
					// ar[i][k] + ar[k][j] : [i -> k] + [k -> j] 비용
					ar[i][j] = Math.min(ar[i][j], ar[i][k] + ar[k][j]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(ar[i][j] >= big) ar[i][j] = 0;
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}
}
