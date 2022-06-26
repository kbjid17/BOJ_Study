package prob_회의실배정_1931_220114_220625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_복습_220625 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] ar = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(ar,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] < o2[1]) return o1[1]-o2[1];
				
				if(o1[1] == o2[1]) {
					if(o1[0] < o2[0]) return o1[0] - o2[0];
					
				}
				return 1;
			}
		});
		
		int start = ar[0][0]; int end = ar[0][1]; int cnt = 1;
		for (int i = 1; i < n; i++) {

				if(ar[i][0] >= end) {
					start = ar[i][0];
					end = ar[i][1];
					cnt++;
				}
		}
		System.out.println(cnt);
	}
}