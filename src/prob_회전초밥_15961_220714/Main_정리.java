package prob_회전초밥_15961_220714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,D,K,C;
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static int[] sushi;
	static int[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); 
		sushi = new int[N];
		selected = new int[D+1];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sushi[i] = num;
		}
		int cnt = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < K; i++) {
			d.offer(sushi[i]);
			if(selected[sushi[i]] == 0) {
				cnt++;
			}
			selected[sushi[i]]++;
		}
		if(selected[C] == 0) {
			cnt++;
		}
		selected[C]++;
		ans = Math.max(ans, cnt);
		for (int i = 0; i < sushi.length; i++) { 
			selected[sushi[i]] -=1;
			
			if(selected[sushi[i]] == 0) {
				cnt-=1;
			}
			int add_idx = i+K;
			if(add_idx > sushi.length-1) {
				add_idx -= sushi.length;
			}
			selected[sushi[add_idx]]++; 
			if(selected[sushi[add_idx]] == 1) {
				if(sushi[add_idx] == C) {
					cnt--;
				}
				cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
