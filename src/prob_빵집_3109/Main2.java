package prob_빵집_3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
	static int R,C,count;
	static char[][] ar;

	static int[] dy = {-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ar = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			ar[i] = str;
		}
		for (int i = 0; i < R; i++) {
			if(dfs(i,0)) count++;
		}
		System.out.println(count);
	}
	static boolean dfs(int y,int x) {
		int nx = x+1; //nx 거리 추가
		
		for (int i = 0; i < 3; i++) {
			int ny = y+dy[i]; //순회 기준 윗방향부터!
			
			if(ny < 0 || ny >= R || ar[ny][nx] == 'x') continue; //조건을 벗어나지 않도록
			if(nx == C-1) return true;
			ar[ny][nx] = 'x';
			
			if(dfs(ny,nx)) return true; // 핵심
			/*
			 첫번째 ny,nx의 값은 처음 값과 다름. 이 재귀 과정을 반복해서 결국 x가 C-1까지 도달하면 도착한 것이 되므로 도착 처리가 가능!!!!!!(역시 신박하다)
			 재귀를 사용하는 신기한 방법이다.
			 */
		}
		return false;
	}
}
