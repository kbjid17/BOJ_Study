package prob_사다리조작_15684_220521_220522_220529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3th {
	static int[][] ar = new int[31][11];
	static int n,m,h,ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 세로선의 개수
		m = Integer.parseInt(st.nextToken()); // 가로선의 개수
		h = Integer.parseInt(st.nextToken()); // 세로선마다 놓을 수 있는 위치의 개수
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar[a][b] = 1;
		}
		
		ans = 4; // 4를 넘어가면 안되므로 기저조건을 설정하기 위해 4로 지정
		dfs(0,1,1); // [1][1]부터 탐색 시작
		
		if(ans >= 4) ans = -1;
		System.out.println(ans);
	}

	
	static void dfs(int cnt, int y, int x) {
		if(cnt >= ans) return; //ans가 바뀌기 전에는 4이므로 4 이상이 되면 볼 필요가 없음
		
		if(check()) // 요구한 조건(1~n번 세로선이 모두 자신의 세로선 위치에서 맨 밑으로 도착) 을 만족하면
		{
			ans = cnt;
			return;
		}
		if(cnt == 3) return; // 위의 것을 만족 못했는데 cnt가 3이면, 다음 cnt는 4이므로 볼 필요가 없음.
		
		for (int i = y; i <= h; i++) {
			for (int j = x; j < n; j++) {
				if(ar[i][j] == 0 && ar[i][j-1] == 0 && ar[i][j+1] == 0) {
					ar[i][j] = 1;
					dfs(cnt+1,i,j);
					ar[i][j] = 0;
				}
				x = 1;
			}
		}
	}
	
	static boolean check() {
		
		for (int i = 1; i <= n; i++) { // 1~ n번 세로선까지 하나씩 사다리 이동 진행
			int pos = i; // 현재 가로 위치
			for (int j = 0; j <= h; j++) {
				if(ar[j][pos] == 1) pos++; // 오른쪽으로 갈 수 있으면 pos++
				else if(ar[j][pos-1] == 1) pos--; // 왼쪽으로 갈 수 있으면 pos--
			}
			if(i != pos) return false;
		}
		
		return true;
		
	}
}
