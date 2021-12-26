package prob_N과M_15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] ar,number;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N];
		number = new int[N];
		selected = new boolean[N];
		
		perm(0);
	}

	static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			

				
				number[cnt] = i+1;
				selected[i] = true;
				
				//다음 수 뽑으러 ㄱㄱ
				perm(cnt+1);
				selected[i] = false;
		}
	}
}
