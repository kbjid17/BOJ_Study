package prob_개똥벌레_3020_220715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N,H;
	static int[][] ar;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ar = new int[2][N];
		int idx_1 = 0, idx_2 = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i % 2 == 0) {
				ar[0][idx_1] = num;
				idx_1++;
			}
			else if(i %2 != 0) {
				ar[1][idx_2] = num;
				idx_2++;
			}
		}
		Arrays.sort(ar[0]);
		Arrays.sort(ar[1]);
		
		int min_obstacle = Integer.MAX_VALUE; 
		int[] height_obstacle = new int[N+1]; // n개의 장애물을 없애야 하는 구간의 수를 구하는 배열 [0] : 0개의 장애물을 없애야 하는 구간의 수 , [1] : 1개의 장애물의 수를 없애야 하는 구간의 수
		for (int i = 0; i < H; i++) { 
			int obstacle = 0; 
			for (int j = 0; j < 2; j++) {
				int start = 0;
				int end = N-1;
				int mid = (start + end)/2;
				while(start <= end) {
					switch(j) {
					case 0:
						if(ar[j][mid] > i) {
							end = mid-1;
							mid = (start + end)/2;
						}
						else if(ar[j][mid] <= i) {
							start = mid+1;
							mid = (start + end)/2;
						}
						if(start > end) {
							int block_obs = end;
							obstacle += (ar[0].length - (block_obs+1));
						}
						break;
					case 1: // 종유석(위 -> 아래) ( 
						if(ar[j][mid] > H-i-1) {
							end = mid-1;
							mid = (start + end)/2;
						}
						else if(ar[j][mid] <= H-i-1) {
							start = mid+1;
							mid = (start + end)/2;
						}
						
						if(start > end) {
							int block_obs = end;
							obstacle +=(ar[j].length - (block_obs+1));
						}
						break;
					}
				}
			}
			++height_obstacle[obstacle];
			if(min_obstacle > obstacle) {
				min_obstacle = obstacle;
			}
		}
		sb.append(min_obstacle).append(" ").append(height_obstacle[min_obstacle]);
		System.out.println(sb.toString());
	}
}