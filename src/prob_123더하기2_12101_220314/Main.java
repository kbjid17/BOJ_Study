package prob_123더하기2_12101_220314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int a,b;
	static int[][] ar;
	static ArrayList<String>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[a+3];
		
		for (int i = 0; i < a+3; i++) {
			list[i] = new ArrayList<String>();
		}
		// List 1에 해당하는 값을 집어넣음
		list[1].add("1");
		
		// List 2에 해당하는 연산을 집어넣음
		list[2].add("1+1");
		list[2].add("2");
		// List 3에 해당하는 연산을 집어넣음
		list[3].add("1+1+1");
		list[3].add("1+2");
		list[3].add("2+1");
		list[3].add("3");
		
		//1,2,3은 모두 정해졌으므로 그 다음을 보면
		for (int i = 4; i <= a; i++) {
			for (int j = 1; j <= 3; j++) {
				for (String s : list[i-j]) { //i = 4 => j = 1 
//					ArrayList[i-1] 에 있는 수식에 +1을 (ex i == 4, j == 1 => ArrayList[4-1]에 +1)
//					 ArrayList[i-2] 에 있는 수식에 +2을 (ex i == 4, j == 2 => ArrayList[4-2]에 +2)
//					 ArrayList[i-3] 에 있는 수식에 +3을 (ex i == 4, j == 2 => ArrayList[4-3]에 +3)
					list[i].add(s + "+" + j); 
				}
			}
		}
		if(list[a].size() < b) {
			System.out.println(-1);
		}
		else {
			Collections.sort(list[a]);
			System.out.println(list[a].get(b-1));
		}
		/*
		 1. ArrayList<String> 배열을 만듬
		 2. ArrayList<String> 배열을 초기화
		 3. n=1,2,3 일 때의 수식을 ArrayList에 넣어주기
		 4, for i = 4 to n 까지 돌면서
		 ArrayList[i-1] 에 있는 수식에 +1을
		 ArrayList[i-2] 에 있는 수식에 +2을
		 ArrayList[i-3] 에 있는 수식에 +3을
		 
		 5. ArrayList[n]에 있는 list의 개수가 k보다 작다면 -1 출력
		 아니라면 ArrayList[n]을 정렬하고 k번째 item을 출력
		 */
		
		

	}

}
