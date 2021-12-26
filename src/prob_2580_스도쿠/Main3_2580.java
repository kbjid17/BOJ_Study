package prob_2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3_2580 {

	static boolean[] overlap;
	static int count;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static int[][] ar = new int[9][9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 0)
					list.add(new int[] {i,j}); //새 숫자를 넣어야 할 자리를 리스트로 등록!
			}
		}
		sdoku(0);
		
		
	}
	/*
	 1. 첫 0이 나온 자리부터 검사를 시작한다.
	 해당 자리에 어떤 수도 올 수 없게 된 경우, 뒤로 되돌려서 앞의 수가 다른 수를 셀 수 있는지 검사한다.
	 */

		static void sdoku(int listnum) { //xy좌표, 안에 들어가있는 수, 리스트 넘버
			if(count == 0) {
				if(listnum == list.size() && count == 0) {
					count++;
					complete();
					return;
				}
//				System.out.println(listnum);
//				System.out.println(li[0] + " " + li[1]);
				boolean[] ary = new boolean[10];
				ary[0] = true;
				//특정 자리에 대해 숫자가 들어갈 수 있는지 검사
				/*
				 가로,세로,구역 검사 필요
				 숫자 리스트(1~9에서)
				 가로에 있는 숫자들을 제외
				 세로에 있는 숫자들을 제외
				 구역에 있는 숫자들을 제외하고
				 남는 숫자를 작은 수부터 넣어보기
				 */
				for (int i = 0; i < 9; i++) { // 가로 검사
					if(!ary[ar[i][list.get(listnum)[1]]]) {
						ary[ar[i][list.get(listnum)[1]]] = true;
//						System.out.println(ar[i][li[1]]);
					}
					if(!ary[ar[list.get(listnum)[0]][i]]) { // 세로 검사
						ary[ar[list.get(listnum)[0]][i]] = true;
//						System.out.println(ar[li[0]][i]);
					}
				}
				
				//구역 검사
				int y = list.get(listnum)[0]/3*3;
				int x = list.get(listnum)[1]/3*3;
				for (int i = y; i < y+3; i++) {
					for (int j = x; j < x+3; j++) {
						if(!ary[ar[i][j]]) {
							ary[ar[i][j]] = true;
//							System.out.println(ar[i][j]);
						}
					}
				}
//				for (int i = 0; i < 10; i++) {
//					System.out.println(ary[i]);
//				}
				for (int i = 1; i <= 9; i++) { //현재의 숫자부터 계산을 시작해서
					if(ary[i]) continue;
//					System.out.println(i);
						// 해당 숫자가 방문되지 않았다면
						ar[list.get(listnum)[0]][list.get(listnum)[1]] = i;
//						System.out.println("들어가는 수 : " + i);
							sdoku(listnum+1); //돌아가서 해당 자리의 숫자부터 시작!
							ar[list.get(listnum)[0]][list.get(listnum)[1]] = 0;
				}
			}
	}
		static void complete() {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(ar[i][j] + " ");
				}
				System.out.println();
			}
		}
		
}