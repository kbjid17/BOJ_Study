package prob_촌수계산_2644_1230;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,m,num1,num2;
	static int ans = Integer.MAX_VALUE;
	static boolean visit[];
	static ArrayList<Integer>[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		ar = new ArrayList[n+1];
		visit = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a].add(b);
			ar[b].add(a);
		}
		dfs(num1,0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	// 깊이 출력
	// 배열 크기만큼의 깊이를 돌려도 아무것도 나오지 않는 경우 -1 출력
	static void dfs(int num1,int cnt) {
		visit[num1] = true;
//		System.out.println("num1 값 : " + num1);
		if(cnt > n) {
//			System.out.println("끝");
			return;
		}
		if(num1 == num2) {

			ans = Math.min(ans, cnt);
			return;
		}
		for (int i = 0; i < ar[num1].size(); i++) {
			if(visit[ar[num1].get(i)]) continue;
//			System.out.println(num1 + "의 요소 : "+ar[num1].get(i));
			dfs(ar[num1].get(i),cnt+1);
		}
	}
}