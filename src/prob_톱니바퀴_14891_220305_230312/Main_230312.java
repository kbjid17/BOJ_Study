package prob_톱니바퀴_14891_220305_230312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_230312 {
	static char[][] ar = new char[4][8];
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			ar[i] = br.readLine().toCharArray(); // N극 : 0점, S극 : 1점 
			// [0] : 점수
			// [2] : 오른쪽 톱니의 [6]과 닿음 
			// [6] : 왼쪽 톱니의 [2]와 닿음
		}
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			list.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); // 1 : 시계, -1 : 반시계
			
			// 회전할 톱니와 방향이 주어진다.
			
			/*
			 1. 어떤 톱니가 회전해야 할지 결정한다.
			 2. 그 회전할 각 톱니의 방향을 결정한다.
			 (ex. 1번 시계 -> 2번 반시계 -> 3번 시계 -> 4번 X)
			 3. 한꺼번에 회전을 진행한다.
			 */
			int dir = b;
			list.add(new int[] {a-1,dir});
//			System.out.println(Arrays.toString(ar[a-1]));
			for (int i = a; i < 4; i++) {
				if(ar[i-1][2] == ar[i][6]) break;
				// 회전이 필요!
				dir *= -1;
				list.add(new int[] {i,dir});
			}
			dir = b;
			for (int i = a-1; i >= 1; i--) {
				if(ar[i][6] == ar[i-1][2]) break;
				dir *= -1;
				list.add(new int[] {i-1,dir});
			}
			
			for (int i = 0; i < list.size(); i++) {
				rotate(list.get(i)[0], list.get(i)[1]);
			}
		}
		int score = 1;
		if(ar[0][0] == '1') ans += 1;
		for (int i = 1; i < 4; i++) {
			score *= 2;
			if(ar[i][0] == '1') ans += score;
		}
		System.out.println(ans);
	}

	static void rotate(int num, int dir) {
		char[] temp = ar[num].clone();
		switch(dir) {
		case 1: // 시계 방향
			ar[num][0] = temp[7];
			for (int i = 1; i < 8; i++) {
				ar[num][i] = temp[i-1];
			}
			
			break;
		case -1: // 반시계 방향
			ar[num][7] = temp[0];
			for (int i = 0; i < 7; i++) {
				ar[num][i] = temp[i+1];
			}
			break;
		}
//		System.out.println((num+1) + " : "+ Arrays.toString(ar[num]));
	}
}
