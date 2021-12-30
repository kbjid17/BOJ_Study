package prob_시험감독_13458_211230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,B,C;
	static long ans;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//총감독관은 1명, 부감독관은 자유로히
		//총감독관은 반드시 있어야 하고, 부감독관은 없어도 됌.
		for (int i = 0; i < ar.length; i++) {
			ar[i] -= B;
			ans++;
			if(ar[i] > 0) {
				ans += Math.ceil(((double)ar[i] / C));
			}
		}
		System.out.println(ans);
	}

}
