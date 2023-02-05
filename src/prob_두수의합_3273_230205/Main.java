package prob_두수의합_3273_230205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int N =  Integer.parseInt(br.readLine());
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar.add(Integer.parseInt(st.nextToken()));
		}
		int t = Integer.parseInt(br.readLine());
		
		Collections.sort(ar);
		
		int a = 0;
		int b = N-1;
		
		while(a < b) {
			int num = ar.get(a)+ar.get(b);
			
			if(num == t) {
				ans++;
				b--;
			}
			else if(num < t) a++;
			else if(num > t) b--;
		}
		System.out.println(ans);
	}
}