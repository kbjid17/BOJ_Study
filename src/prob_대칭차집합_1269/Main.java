package prob_대칭차집합_1269;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int num_a,num_b,N,M;
	static HashSet<Integer> A = new HashSet<Integer>();
	static HashSet<Integer> B = new HashSet<Integer>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		num_a = A.size();
		num_b = B.size();
		//1. A-B = num_a
		for (Integer integer : B) {
			if(A.size() == 0) break;
			if(A.contains(integer)) {
				num_a--;
			}
		}
		//2. B-A = num_b
		for (Integer integer : A) {
			if(B.size() == 0) break;
			if(B.contains(integer)) {
				num_b--;
			}
		}
		System.out.println(num_a+num_b);
		
	}

}
