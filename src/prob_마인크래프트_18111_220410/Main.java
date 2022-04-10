package prob_마인크래프트_18111_220410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m,b,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
	static int answer = Integer.MAX_VALUE , height = Integer.MAX_VALUE;
	static int[][] ar;
	static long sum;
	static double avg;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		ar = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, ar[i][j]);
				max = Math.max(max, ar[i][j]);
				sum += ar[i][j];
			} 
		}

//		System.out.println(avg);
//		System.out.println((int)avg);
//		System.out.println(avg == (int)avg ? avg : ((int) avg) );
		
		// 1. 블록을 파내서 인벤토리에 넣는 행위(빼기 : 2초)
		// 2. 인벤토리에서 블록을 꺼내서 땅에 쌓는 행위(쌓기 : 1초)
		
		/*
		 우선 어느 정도 높이가 되는 것이 가장 좋은지 찾아야 함.
		 이걸 어떻게 찾지?
		 1. 현재 쌓인 블록의 전체 평균을 구함
		 정수가 나올 경우 그 값 그대로 적용해서 고르기를 진행하고
		 실수(62.7나 62.3 과 같은 수)가 나올 경우 62와 63(62+1)의 두 경우 모두 찾아본다.
		 
		 2. 땅고르기 진행 우선순위
		 1순위 : 인벤토리에서 꺼내기(1초)
		 2순위 : (높이가 평균보다 높은) 칸 빼서 인벤토리에 쌓기(2초)
		 
		 */
		
		for (int i = min; i <= max; i++) {
			cal(i);
		}
		
		System.out.println(answer + " " + height);
	}

	static void cal(int val) {
		int cb = b; // b값 복사
		int v = 0; // 시간 임시 값
		
		
		
		// 1. 평균보다 높이 쌓인 땅부터 제거 -> for문으로 검사하면서 높은 칸을 빼기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(ar[i][j] > val) {
					cb += ar[i][j] -val;
					v += 2*(ar[i][j] - val);
				}
			}
		}
		// 2. 평균보다 낮게 쌓인 칸에 땅 쌓기 -> for문으로 검사하면서 땅 쌓기 진행
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(ar[i][j] < val) {
					if(val - ar[i][j] > cb) { // 해당 과정이 블록이 부족해 불가능한 경우 높이를 더 높게 맞추는 건 어차피 불가능하므로 avg-1 값으로 다시 진행한다.
						return;
					}
					cb -= (val-ar[i][j]);
					v += (val-ar[i][j]);
				}
			}
		}
		// 최종적으로 땅 고르기가 완료되었다면 answer에 v 값을 넣음. 최소 시간을 구하고 그 때의 높이를 구하라. 최소 시간의 경우가 여러개일 경우 최대 높이를 구하라
		if(v <= answer) {
			if(v == answer && val <= height) return;
			answer = v;
			height = val;
		}
	}
}
