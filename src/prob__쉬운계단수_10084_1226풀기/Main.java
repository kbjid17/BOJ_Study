package prob__쉬운계단수_10084_1226풀기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		ans = new long[N];
		for (int i = (int) Math.pow(10, N-1); i < (int) Math.pow(10, N); i++) {
			String[] str = Integer.toString(i).split("");
			for (int j = 1; j < str.length; j++) {
				if(Math.abs(Integer.parseInt(str[j])-Integer.parseInt(str[j-1])) != 1) {
					break;
				}
				if(j == str.length-1) {
					System.out.println(i);
					ans[N-1]++;
				}
			}
		}
		System.out.println(ans[N-1]%1000000000);
	}

}
