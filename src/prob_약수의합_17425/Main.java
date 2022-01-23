package prob_약수의합_17425;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] ar;
	static long[] ans;
	static StringBuilder sb = new StringBuilder();
	static boolean[] prime;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1];
		ans = new long[1000001];
		prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		ans[1] = 1;
		
		for (int i = 2; i <= 1000000; i++) {
			ans[i] += ans[i-1];
			if(!prime[i]) { // 소수가 맞다면
				ans[i] += (i+1);
				
				if((long) i*i > 1000000) continue; 
					for (int j = i*i; j <= 1000000; j+=i) {
//						System.out.println(j);
						prime[j] = true; // 해당 수는 소수가 아님 -> 약수 구하는 알고리즘을 적용해야 할듯.
					}
			}
			else {
				for (int j = 1; j <= (int) Math.sqrt(i); j++) {
					if(i%j == 0) {
						ans[i] += j + (i/j);
						if(j == i/j) ans[i] -= j;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			sb.append(ans[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
		//약수를 구해야 한다.
	}

}
