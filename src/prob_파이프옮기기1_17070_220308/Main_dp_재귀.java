package prob_파이프옮기기1_17070_220308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dp_재귀 {
	static int[][] ar;
	static int N,ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp(1,2,1);

		System.out.println(ans);
	}

	static void dp(int y,int x,int dir) { // dir의 경우, 1 : 가로, 2 : 대각선, 3 ㅣ 세로
		if(y == N && x == N && ar[y][x] != 1) {
			ans++;
			return;
		}
		int ny = y+1;
		int nx = x+1;
		
		// 가로로 갈 수 있는 경우
		if(x < N && ar[y][nx] != 1 && dir != 3) dp(y,nx,1);
		
		// 대각선으로 갈 수 있는 경우
		if(y < N && x < N && ar[ny][x] != 1 && ar[y][nx] != 1 && ar[ny][nx] != 1) dp(ny,nx,2);
		// 세로로 갈 수 있는 경우
		if(y < N && ar[ny][x] != 1 && dir != 1) dp(ny,x,3);
	}
}
