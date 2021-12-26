package prob_2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {

	static boolean[] overlap;
	static int count;
	static Stack<int[]> stack = new Stack<int[]>();
	static boolean[][] visited = new boolean[9][9];
	static int[][] ar = new int[9][9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0,0부터 탐색 시작
		sdoku(0,0,1,0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 한칸씩 옆으로 이동해가면서 0이 위치해 있는 곳을 탐색
	// 0이 발견될 경우, 해당 자리를 기억하고 수를 찾기 시작
	// 수를 넣은 후 다음 자리를 탐색
	// 그렇게 자리를  찾아가다가 더이상 숫자를 넣을 수 없을 경우, 해당 자리 이전의 자리로 돌아감
	// 이후 기존에 위치해있던 수를 제외한 다른 수를 삽입하도록 탐색
	// 그렇게 모든 수를 채울 때까지 반복
	static void sdoku(int y,int x,int number,int count) {
			if(ar[y][x] == 0) {
				stack.push(new int[] {y,x});
				ar[y][x] = number;
			}
	}
}	