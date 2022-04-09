package prob_경사로_14890_220409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int answer;
	static int[][] ar;
	static boolean[][] rowc; // 행 방향의 경사로가 놓였는지 체크
	static boolean[][] colc; // 열 방향의 경사로가 놓였는지 체크
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ar = new int[n][n];
		rowc = new boolean[n][n];
		colc = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			check_col(i);
			check_row(i);
		}
		System.out.println(answer);
	}

	static void check_col(int r) { // 행으로 체크(왼쪽 -> 오른쪽 길)
		//for문으로 한칸씩 앞으로 나아가면서
		for (int i = 1; i < n; i++) {
			// 만약 이전 칸과 높이가 다르다면? -> 이전 칸과 비교해서 높이가 높을때와 낮을때를 구분해줘야할듯?
			if(ar[r][i] > ar[r][i-1]) { // 현재 칸이 이전 칸보다 높이가 크다면 : 이전 m개 칸의 높이가 같고 그 칸들에 경사로가 놓인 적이 없는 경우 경사로를 놓아 올라갈 수 있음
				if(i < m || ar[r][i] - ar[r][i-1] > 1) return; // 현재 지나온 길의 길이가 m보다 작을 경우 경사로를 놓을 수 없음.
				
				for (int j = i-1; j >= i-m; j--) {
					if(ar[r][j] != ar[r][i-1] || rowc[r][j]) return;   // 경사로를 놓으려는 칸의 높이가 다를 경우 or 이미 경사로가 놓인 칸일 경우 놓을 수 없음 => 지나갈 수 없음
				}
				 // 검사가 끝난 후, 경사로를 놓을 수 있다면 경사로를 놓기.
					for (int j = i-1; j >= i-m; j--) {
						rowc[r][j] = true;
					}
			}
			else if(ar[r][i] < ar[r][i-1]) { // 현재 칸이 이전 칸보다 높이가 작다면 : 앞 m개의 칸의 높이가 같고 그 칸들에 경사로가 놓인 적이 없는 경우 경사로를 놓아 올라갈 수 있음
				if(n-i < m || ar[r][i] - ar[r][i-1] < -1) return; // i칸 앞에 놓인 칸의 개수(n-i)가 m보다 적가나 ar[r][i]와 ar[r][i-1]의 높이 차이가 1보다 클 경우 경사로를 놓을 수 없음
				
				for (int j = i; j < i+m; j++) {
					if(ar[r][j] != ar[r][i] || rowc[r][j]) return; // 경사로를 놓으려는 칸의 높이가 다를 경우 or 이미 경사로가 놓인 칸일 경운 놓을 수 없음 ==> 지나갈 수 없음
				}
				// 검사가 끝난 후, 경사로를 놓을 수 있다면 경사로를 놓기/
				for (int j = i; j < i+m; j++) {
					rowc[r][j] = true;
				}
			}
		}
		// 무사히 길을 건널 수 있다면
//		System.out.println("왼쪽 -> 오른쪽의 "+r + " : able!");
		answer++;
	}
	
	static void check_row(int c) { // 열로 체크(윗쪽 -> 아랫쪽 길)
		for (int i = 1; i < n; i++) {
			if(ar[i][c] > ar[i-1][c]) {
				if(i < m || ar[i][c] - ar[i-1][c] > 1) return;
				
				for (int j = i-1; j >= i-m; j--) {
					if(ar[j][c] != ar[i-1][c] || colc[j][c]) return;
				}
				for (int j = i-1; j >= i-m; j--) {
					colc[j][c] = true;
				}
			}
			else if(ar[i][c] < ar[i-1][c]) {
				if(n-i < m || ar[i][c] - ar[i-1][c] < -1) return; 
				
				for (int j = i; j < i+m; j++) {
					if(ar[j][c] != ar[i][c] || colc[j][c]) return;
				}
				for (int j = i; j < i+m; j++) {
					colc[j][c] = true;
				}
			}
		}
//		System.out.println("위 -> 아래의 "+c + " : able!");
		answer++;
	}
}
