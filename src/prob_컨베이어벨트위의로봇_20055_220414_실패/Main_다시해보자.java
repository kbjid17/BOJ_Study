package prob_컨베이어벨트위의로봇_20055_220414_실패;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_다시해보자 {
	static int N,K,z; // z : 내구도가 0인 칸
	static area[] ar; 
	static ArrayList<Integer> list = new ArrayList<Integer>(); // 올라온 로봇의 위치를 순서대로 기억하는 list
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ar = new area[N*2+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < ar.length; i++) {
			ar[i] = new area(Integer.parseInt(st.nextToken()),0);
		}
		// ar[n] : 내리는 위치, ar[2*n] : 올리는 위치
		/*
		 * 
		 */
		
		/*
		 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
		 -- 벨트와 로봇은 한칸씩 이동
		가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
		-- 로봇은 한칸 더 이동할 수 있으면 이동
			로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
				2번째 이동을 하려는데 옆칸에 로봇이 있거나 이동하려는 칸의 내구도가 0이면 이동 불가능
		올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		-- 올리는 위치는 매 단계마다 바뀌므로 로봇이 없거나 내구도가 0이 아니라면 올릴 수 있음
		내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		 -- 단계 중 0이 발생할 경우 카운트를 진행. 카운트가 K개 이상 나면 해당 단계를 출력하면 답. 
		 
		 */
		int stage = 1;
		while(true) {
			int uparea = stage % (2*N) + 1; // 올리는 위치
			int downarea = (N-1+stage) % (2*N)+1;// 내리는 위치
			
			//1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전한다.
			area temp = ar[ar.length-1];
			for (int i = ar.length-1; i >= 1; i--) {
				if(i == 1) ar[i] = temp;
				else {
					ar[i] = ar[i-1];
				}
			}
			//2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			for (int n : list) { // 올라온 순서대로 로봇이 이동해야 하므로 foreach문으로 로봇을 순서대로 이동
				if(ar[(n+1) % (2*N) + 1].n > 0 && ar[(n+1) % (2&N) + 1].r == 0) { // 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아있어야 함.
					ar[(n+1) % (2*N) + 1].n -= 1;
					ar[(n+1) % (2*N) + 1].r = 1;
					ar[n].r = 0;
					if(ar[(n+1) % (2*N) + 1].n == 0) { // 내구도가 0인 칸의 개수가 k개 이상이면 과정 종료
						z++;
					}
				}
			}
			//3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(ar[uparea].n > 0) ar[uparea].r = 1;
			if(z == K) {
				ans = stage;
				break;
			}
			stage++;
		}
	}

	static class area {
		int n; // 내구도
		int r; //현재 해당 칸에 로봇이 올라와있는지
		public area(int n, int r) {
			super();
			this.n = n;
			this.r = r;
		}
		@Override
		public String toString() {
			return "area [n=" + n + ", r=" + r + "]";
		}
		
	}
}
