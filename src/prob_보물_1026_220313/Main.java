package prob_보물_1026_220313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static Integer[][] a;
	static int ans;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new Integer[2][n];
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//b의 가장 큰 값에 a의 가장 작은 값을 매칭
		Arrays.sort(a[0]);
		Arrays.sort(a[1],Collections.reverseOrder());
		//b의 가장 작은 값에 a의 가장 큰 값을 매칭
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < n; i++) {
			ans += a[1][i] * a[0][i];
		}
System.out.println(ans);
	}

}
