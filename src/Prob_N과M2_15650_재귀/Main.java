package Prob_N과M2_15650_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static int[] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				backtrack(i,1);
			}	
		System.out.println(sb);
	}
	static void backtrack(int numb,int line) {
		if(line == M) {
			sb.append(numb).append("\n");
		}
		else {
			sb.append(numb).append(" ");
			
		}
		
	}
}
