package prob_병든나이트_1783_220621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long N,M;
	static Long ans = Long.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		/*
		 	2칸 위로, 1칸 오른쪽
			1칸 위로, 2칸 오른쪽
			1칸 아래로, 2칸 오른쪽
			2칸 아래로, 1칸 오른쪽 
		 */
		move();
		System.out.println(ans);
	}
	
	static void move() {
		if(N == 1) {
			ans = (long) 1;
			return;
		}
		else if(N == 2) {
			if(M < 7) {
				ans = (long) Math.round((M*1.0)/2);
			}
			else {
				ans = (long)4;
				return;
			}
		}
		else if(N >= 3) {
			if(M < 7) ans = Math.min(4, M);
			else {
				ans = M-7+5;
			}
		}
	}
}
