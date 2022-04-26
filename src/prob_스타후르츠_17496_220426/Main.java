package prob_스타후르츠_17496_220426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,T,C,P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		System.out.println((C*P) * ((N-1)/T));
	}

}
