package prob_톱니바퀴_14891_220305_230312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_230312_정리 {
	static char[][] ar = new char[4][8];
	static ArrayList<int[]> list = new ArrayList<int[]>();
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			ar[i] = br.readLine().toCharArray();
		}
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			list.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int dir = b;
			list.add(new int[] {a-1,dir});
			
			for (int i = a; i < 4; i++) {
				if(ar[i-1][2] == ar[i][6]) break;
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
		case 1:
			ar[num][0] = temp[7];
			for (int i = 1; i < 8; i++) {
				ar[num][i] = temp[i-1];
			}
			
			break;
		case -1:
			ar[num][7] = temp[0];
			for (int i = 0; i < 7; i++) {
				ar[num][i] = temp[i+1];
			}
			break;
		}
	}
}
