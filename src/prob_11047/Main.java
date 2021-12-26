package prob_11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ar = new int[N];
		for(int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		for(int i = ar.length-1; i >= 0; i--) {
			while(K >= ar[i])
			{
				K -= ar[i];
				count++;
			}
		}
		System.out.println(count);
	}
}