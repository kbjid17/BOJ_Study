package prob_개수세기_10807_220610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] ar = new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		int a = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			if(ar[i] == a) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}
