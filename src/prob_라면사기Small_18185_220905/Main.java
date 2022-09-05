package prob_라면사기Small_18185_220905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] ar = new int[100001];
	static long ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		
		for (int i = 1; i <= N; i++) {
			
			if(ar[i+1] > ar[i+2]) {
				int two = Math.min(ar[i], ar[i+1] - ar[i+2]);
				ans += 5*two;
				ar[i] -= two;
				ar[i+1]-=two;
				
				int three = Math.min(ar[i], Math.min(ar[i+1], ar[i+2]));
				ans += 7*three;
				ar[i] -= three;
				ar[i+1] -= three;
				ar[i+2] -= three;
			}
			else {
				int three = Math.min(ar[i], Math.min(ar[i+1], ar[i+2]));
				ans += 7*three;
				ar[i] -= three;
				ar[i+1] -= three;
				ar[i+2] -= three;
				
				int two = Math.min(ar[i], ar[i+1]);
				ans += 5*two;
				ar[i]-=two;
				ar[i+1] -= two;
			}
			ans += 3*ar[i];
		}
		System.out.println(ans);
	}

}
