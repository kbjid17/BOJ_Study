package prob_2048easy_12100_아직못품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,max = Integer.MIN_VALUE,prac[];
	static int[][] ar;
	static LinkedList<block> list = new LinkedList<>();
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			ar = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
					if(ar[i][j] != 0) { // 숫자가 들어 있으면
						list.add(new block(i,j,ar[i][j]));
					}
				}
			}
			move(5);
			System.out.println(practice(prac));
	}
	/*
	 1. 이동 알고리즘
	 각 이동 방향이 존재함(북,남,서,동)
	 5회 이동을 하여야 하므로 매 카운트마다 네 방향의 이동을 진행
	 이동 방향의 맨 끝쪽에 있는 녀석들은 그 방향의 끝 칸으로 이동하고, 다른 블록들은 그를 따라감(바로 앞 블록의 앞칸까지 이동)
	 그 결과 자신의 뒷칸에 자신과 같은 숫자가 있으면 그를 합치고 그 뒤에 있던 녀석들은 다시 갖다붙임.
	 
	 */
	
	// 이동시켜야 하는건 0이 아닌 수들(현재 list에 들어간 수들)
	// 네 방향으로의 이동을 할 경우를 부여해야 함.(또 배열 복사?)
	// 한번 이동시켜보고 되돌리고 다른 방향으로도 이동시켜보고 되돌리고 (이때 이동한 정보는 각각 가지고 있어야 한다!)... 해서 네방향 진행해야하는건가?
	private static void move(int count) {
		while(count > 0) { // 5회 이동
			
		}
	}
	private static class block {
		int y;
		int x;
		int num;
		public block(int y,int x,int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}
		
	}
	
	private static int[] practice(int[] pract){ // 왼쪽 방향으로 돌리는 연습
		for (int i = 0; i < pract.length; i++) {
			if(pract[i] != 0) {
				int j = i;
				while(j > 0) {
					int temp = pract[j-1];
					if(temp == 0) {
						pract[j-1] = pract[j];
						pract[j] = temp;
					}
					else {
						if(temp == pract[j]) {
							pract[j] = 0;
							pract[j-1]*=2;
						}
						else if(temp != pract[j]) {
							break;
						}
					}
					j--;
				}
			}
		}
		return pract;
		
	}
}
