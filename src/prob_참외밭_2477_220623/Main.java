package prob_참외밭_2477_220623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] ar = new int[7][2];
	static int max_r,max_c;
	static int sub_r,sub_c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar[i][0] = Integer.parseInt(st.nextToken());
			ar[i][1] = Integer.parseInt(st.nextToken());
			
			if(ar[i][0] == 1 || ar[i][0] == 2) {
					max_c = Math.max(max_c, ar[i][1]);
				}
			
			else if(ar[i][0] == 3 || ar[i][0] == 4) {
					max_r = Math.max(max_r, ar[i][1]);
				}
			}
			for (int i = 1; i <= 6; i++) {
				if((ar[i][1] == max_r) && (ar[i][0] == 3 || ar[i][0] == 4)) {
					int pos = i+1;
					if(pos >= 7) pos-=6;
					int pos_2 = i-1;
					if(pos_2 <= 0) pos_2=6;
					sub_c = Math.abs(ar[pos][1] - ar[pos_2][1]);

			}
				else if((ar[i][1] == max_c) && (ar[i][0] == 1 || ar[i][0] == 2)) {
					int pos = i+1;
					if(pos >= 7) pos-=6;
					int pos_2 = i-1;
					if(pos_2 <= 0) pos_2=6;
					sub_r = Math.abs(ar[pos][1] - ar[pos_2][1]);
				}
				if(sub_r != 0 && sub_c != 0) break;
		}

			System.out.println((max_r * max_c - sub_r * sub_c) * num);
			
		
		

	}

}
