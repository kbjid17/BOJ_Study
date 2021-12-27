package prob_1722_순열의순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_시간초과 {
//	생각해보니 완탐으론 힘들것같다..
//	혹시나 int로 감당을 못해서 long를 사용해보려고 했으나, 배열의 크기에도 한계가 있어서 안되는 것 같다.(애초에 크기 설정이 기본 int로 되어 있는 것 같다.
//	입력할 숫자(count)를 long로 집어두고
//	quiz1 : perm을 count 만큼 반복시켜서?
//	quiz2 : 순열의 수는 N!이므로 4*3*2*1 이므로 첫쨰 자리가 1이면 0~5, 2면 6~11, 3이면 12~17 4면 18~23 이런 식으로 계산하면 될까?
//	count값을 따로 줘야 하나 싶다.
	static int N;
	static long facto = 1;
	static int quiz;
	static long quiz1num;
	static int[] quiz2arr;
	static int[] number;
	static boolean[] isSelected;
	static int[] permlist;
	static long count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		isSelected = new boolean[N + 1];
		quiz2arr = new int[N];
		facto = factorial(N);
		permlist = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		quiz = Integer.parseInt(st.nextToken());
	
		switch(quiz) {
		case 1:
			quiz1num = Long.parseLong(st.nextToken());
			System.out.println(quiz1num);
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				quiz2arr[i] = Integer.parseInt(st.nextToken());
			}
			break;
		}	
		perm(0);
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			count++;
			if(quiz == 1 && count == quiz1num) { 
				permlist = number;
				for (int i = 0; i < N; i++) {
					System.out.print(permlist[i] + " ");
				}
			}
			else if(quiz == 2 && number == quiz2arr) {
				System.out.println(count);
			}
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			number[cnt] = i;
			
			perm(cnt+1);
			isSelected[i] = false;
			
		}
	}
	static long factorial(int N) {
		if(N > 1) {
			facto  *= N;
			return factorial(N-1);
		}
		return facto;
	}
}