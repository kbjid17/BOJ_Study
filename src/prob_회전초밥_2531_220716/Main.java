package prob_회전초밥_2531_220716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N,D,K,C; // 접시의 수 N, 초밥의 가짓수 D, 연속해서 먹는 접시의 수 K, 쿠폰 번호 C
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static int[] sushi;
	static int[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시의 수
		D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		// 먹는 초밥들 중 쿠폰을 발급받은 종류의 초밥이 없으면 새로 만들어줌
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
//		System.out.println(cnt);
		for (int i = 0; i < sushi.length; i++) { // 슬라이딩 윈도우를 지정하기 위한 
//			System.out.println(sushi[i] + " 를 뺌");
			selected[sushi[i]] -=1;
			
			if(selected[sushi[i]] == 0) {
//				System.out.println(sushi[i] + "가 0이 됨");
				cnt-=1;
//				System.out.println(cnt);
			}
			int add_idx = i+K;
			if(add_idx > sushi.length-1) {
				add_idx -= sushi.length;
			}
//			System.out.println(sushi[add_idx] + " 를 넣음");
			selected[sushi[add_idx]]++; 
//			System.out.println(sushi[add_idx]);
			if(selected[sushi[add_idx]] == 1) {
				if(sushi[add_idx] == C) { // 없었다가 새로 들어온 스시가 C번 스시인 경우, 이미 더해져 있기 때문에 더해줄 필요가 없음.
					cnt--;
				}
//				System.out.println(sushi[add_idx] + "가 들어옴");
//				System.out.println(cnt);
				cnt++;
//				System.out.println(cnt);
			}
//			System.out.println(cnt + "의 가중치를 가짐");
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}

}
