package prob_평범한배낭_12865_210914;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
			//냅섹 문제
			/*
			 n개의 물건
			 각 물건 i의 무게 w[i] 와 가치 v[i]
			 배낭의 용량 : W
			 배낭에 담을 수 있는 물건의 최대 가치
			 배낭에 담은 물건의 무게의 합이 W를 초과하면 안됨.
			 각 물건은 하나씩만 존재
			 */
	
	static int N,W;
	static int[] weight,value;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 물건의 개수
		W = Integer.parseInt(st.nextToken()); // 가방의 무게
		weight = new int[N+1];
		value = new int[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken()); // 해당 물건의 무게
			value[i] = Integer.parseInt(st.nextToken()); // 해당 물건의 가치
		}
		
		int[][] D = new int[N+1][W+1];
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				if(weight[i] <= w) { // 물건을 가방에 넣을 수 있음 
					D[i][w] = Math.max(D[i-1][w], value[i] + D[i-1][w-weight[i]]); // 해당 물건을 넣은 경우와 안넣은 경우 중 더 큰 값을 반환
				} else {
					D[i][w] = D[i-1][w];
				}
				
			}
		}
		System.out.println(D[N][W]);
		
	}
	
}