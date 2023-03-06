package prob_약수구하기_2501_230307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int a,b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ar = new ArrayList<Integer>();
		b = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= a; i++) {
			if(a%i == 0) ar.add(i);
		}
		
		if(ar.size() < b) System.out.println(0);
		else System.out.println(ar.get(b-1));
	}

}
