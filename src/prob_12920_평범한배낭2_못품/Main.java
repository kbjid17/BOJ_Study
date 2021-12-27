package prob_12920_평범한배낭2_못품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //물건의 종류, 가방의 무게
	static int wei,val,qu; //물건 번호, 물건 가치(만족도), 물건 수량
	static int[][] goods;  //무게 분리, 가치 분리
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//물건의 개수는 최대 100만개까지 가능
		goods = new int[1000001][2];
		int a = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			wei = Integer.parseInt(st.nextToken());
			val = Integer.parseInt(st.nextToken());
			qu = Integer.parseInt(st.nextToken());
			// 같은 물건을 여러개
			// 물건의 종류는 100가지까지 가능
			// 한 물건당 수량은 10000까지 가능 ==> 1,000,000개까지 물건을 가질 수 있음.
			// 메모리초과가 발생하는 원인 : dp가 돌아가는 횟수가 억대까지 가기 때문이다!(3차원 배열로 해결될 문제가 아님)
			// 가방 무게를 모두 활용할 경우 낼 수 있는 최대의 만족도만 조사하면 됨.
			// 가방 무게를 넘기지 않는 범위 내에서 물건을 최대한 넣었을 때 만족도가 가장 높은 경우를 구하면 되지 않을까?
			while(qu > 0) {
				a++;
				goods[a][0] = wei;
				goods[a][1] = val;
				qu--;
			}
		}
		dp = new int[a+1][M+1];
		for (int i = 1; i <= a; i++) {
			for (int w = 1; w <= M; w++) {
				if(goods[i][0] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], goods[i][1] + dp[i-1][w-goods[i][0]]);
					//1000001*1000000(누적합이 이렇게 되어야 하므로) DP로는 힘든건가?
				}
				else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[a][M]);
	}
} // 메모리 초과가 나는 이유?