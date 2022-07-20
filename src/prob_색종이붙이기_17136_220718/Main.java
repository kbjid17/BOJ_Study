package prob_색종이붙이기_17136_220718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int area_cnt;
	static int[][] ar = new int[11][11];
	static boolean[][] visited = new boolean[11][11];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] start = new int[2];
		for (int i = 1; i <= 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 10; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 1) {
					if(start[0] == 0 && start[1] == 0) {
						start[0] = i;
						start[1] = j;
					}
					area_cnt++;
				}
			}
			
		}
		if(area_cnt == 0) {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; i <= 5; i++) {
//			System.out.println(i + "번째");
			int[] paper = {0,5,5,5,5,5};
			game(i,paper,start[0],start[1],ar,area_cnt,0);
			//(색종이의 크기, 1~5 사이즈의 색종이 남은 갯수, 탐색할 y,x위치, 사용할 배열, 남은 1 갯수, 사용한 종이 갯수
		}
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}
	
	static void game(int size, int[] paper, int y,int x, int[][] ar,int area_cnt,int paper_cnt) {
		if(paper[size] == 0) return; // size 크기의 종이를 더이상 사용할 수 없다면 종료
		if(y+size > 11 || x + size > 11) return; // 색종이가 배열 밖으로 벗어나면 종료
//		System.out.println("size : " + size + ", y : " + y + ", x : " + x + " " + Arrays.toString(paper));
		int[][] copy_ar = new int[11][11]; // 배열 복사 선언
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				copy_ar[i][j] = ar[i][j];
			}
		}
		
//		for (int i = 1; i <= 10; i++) {
//			for (int j = 1; j <= 10; j++) {
//				System.out.print(copy_ar[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		for (int i = y; i < y+size; i++) {
			for (int j = x; j < x+size; j++) {
				if(copy_ar[i][j] == 0) return; // 색종이 중간에 0이 있으면 종료
				copy_ar[i][j] = 0;
				area_cnt--;
			}
		}
		// 무사히 종이를 넣어보는 데 성공했다면
		paper_cnt++; // paper_cnt 값을 1 더해줌
		paper[size]--;
		if(area_cnt == 0) { // 만약 이번 종이 붙이기 과정을 통해 모든 공간을 메꾸는 데 성공했다면
			ans = Math.min(ans, paper_cnt);
			return;
		}
		// copy_ar에서 시작 위치와 남은 공간의 갯수를 구해야 함.
		int[] start = {0,0};
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if(copy_ar[i][j] == 1) {
					if(start[0] == 0 && start[1] == 0) {
						start[0] = i;
						start[1] = j;
						break;
					}
				}
			}
			if(start[0] != 0 && start[1] != 0) break;
		}
//		System.out.println("결과");
//		for (int i = 1; i <= 10; i++) {
//			for (int j = 1; j <= 10; j++) {
//				System.out.print(copy_ar[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 1; i <= 5; i++) {
			int[] new_paper = paper.clone();
			game(i,new_paper,start[0],start[1],copy_ar,area_cnt,paper_cnt);
		}
	}
}


// 

/*

0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 1 1 1 1 0 0 0
0 0 0 1 1 1 1 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0


1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
1 1 1 1 1 1 1 1 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0


맨 처음 1이 나오는 칸을 저장.
배열 입력 완료 후, 저장된 칸을 이용해서 함수 실행
------힘수------
for(1~5):
1~5중 n 크기의 색종이가 성립이 된다 : 
	n*n만큼 0으로 만들어준 배열을 새로 만들고, 만든 색종이 수를 넣음(1~5 중 n 값을 하나 더함)
	만약 n 색종이 개수가 5개를 넘어갔으면:
		n으론 실행 불가능. --n 후 return;
		

---------------
*/