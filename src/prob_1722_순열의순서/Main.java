package prob_1722_순열의순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//	생각해보니 완탐으론 힘들것같다..
//	혹시나 int로 감당을 못해서 long를 사용해보려고 했으나, 배열의 크기에도 한계가 있어서 안되는 것 같다.(애초에 크기 설정이 기본 int로 되어 있는 것 같다.)
//	입력할 숫자(count)를 long로 집어두고
//	quiz1 : perm을 count 만큼 반복시켜서?
//	quiz2 : 순열의 수는 N!이므로 4*3*2*1 이므로 첫쨰 자리가 1이면 0~5, 2면 6~11, 3이면 12~17 4면 18~23 이런 식으로 계산하면 될까?
//	count값을 따로 줘야 하나 싶다.
	static int N;
	static int quiz;
	static long quiznum = 1;
	static long[] facto = new long[21];
	static int[] quizarr;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		Arrays.fill(facto, 1);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		isSelected = new boolean[N + 1];
		quizarr = new int[N];
		
		for (int i = 1; i < N; i++) {
			facto[i] = facto[i-1]*i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		quiz = Integer.parseInt(st.nextToken());
	
		switch(quiz) {
		case 1:
			quiznum = Long.parseLong(st.nextToken());
			//Array를 입력받아야 함.
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= N; j++) { //1~N 사이의 숫자가 들어오기 때문에 1부터 N까지 반복
					if(isSelected[j]) continue; //이전에 나온 값이면 넘기기(08.23 09:14 수정 (i -> j) (1~20 사이의 숫자를 봐야 하므로 j로 돌려야한다)
					/*
					 20! = 2432902008176640000 ==> 당연히 완탐하면 시간초과남
					 첫째자리에 1이 배정될 경우 -> 19*19!개 만큼의 순열이 있음
					첫째자리에 2이 배정될 경우 -> 18*19!개 만큼의 순열이 있음
					첫째자리에 3이 배정될 경우 -> 17*19!개 만큼의 순열이 있음
					...
					첫째자리에 n이 배정될 경우 -> (20-n)*19!개 만큼의 순열이 있음.
					그렇기에 n이 배정될 경우, 주어진 값(quiznum)은 quiznum -= n*19!가 됨.
					*/
					if(quiznum > facto[N-i-1])
						quiznum -= facto[N-i-1];
					else {
						quizarr[i] = j;
						isSelected[j] = true;
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				System.out.print(quizarr[i] + " ");
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				quizarr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < quizarr[i]; j++) {
					if(!isSelected[j])
						quiznum += facto[N-i-1];
				}
				isSelected[quizarr[i]] = true;
			}
			System.out.println(quiznum);
			break;
		}	
	}
}