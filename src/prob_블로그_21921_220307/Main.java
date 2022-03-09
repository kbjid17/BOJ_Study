package prob_블로그_21921_220307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long ans,day,nans;
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static int[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		//기초 값 설정
		for (int i = 1; i <= M; i++) {
			d.offerLast(ar[i]);
			ans+= ar[i];
		}
//		System.out.println(ans);
		if(ans > 0) day = 1;
		nans = ans;
		for (int i = M+1; i <= N; i++) {

//			System.out.println("before : " + nans);
			nans -= d.pollFirst();
			d.offerLast(ar[i]);
			nans += ar[i];
//			System.out.println("after : " + nans);
			if(nans > ans) {
				day = 1;
				ans = nans;
			}
			else if(nans == ans) {
				day++;
			}
		}
		
		if(ans == 0) {
			System.out.println("SAD");
		}
		else if(ans > 0) {
			System.out.println(ans);
			System.out.println(day);
		}
	}

}
