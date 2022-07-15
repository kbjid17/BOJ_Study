package prob_개똥벌레_3020_220715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,H;
	static int[][] ar;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 동굴의 길이
		H = Integer.parseInt(st.nextToken()); // 동굴의 높이
		
		ar = new int[2][N];
		int idx_1 = 0, idx_2 = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i % 2 == 0) {
				ar[0][idx_1] = num; // 짝수(0,2,...) : 석순(아래에서 위로) , 홀수(1,3,....) : 종유석(위에서 아래로)
				idx_1++;
			}
			else if(i %2 != 0) {
				ar[1][idx_2] = num;
				idx_2++;
			}
		}
		Arrays.sort(ar[0]);
		Arrays.sort(ar[1]);
//		System.out.println(Arrays.toString(ar[0]));
//		System.out.println(Arrays.toString(ar[1]));
		
		int min_obstacle = Integer.MAX_VALUE; // 없애는 장애물의 최솟값
		int[] height_obstacle = new int[N+1]; // 0~N개의 장애물을 없앤 구간의 수
		for (int i = 0; i < H; i++) { // i : 높이(0~H-1번 구간까지 본다.)
//			System.out.println();
			int obstacle = 0; // 부숴야 하는 장애물의 수
			for (int j = 0; j < 2; j++) {
				int start = 0;
				int end = N-1;
				int mid = (start + end)/2;
				while(start <= end) {
					switch(j) {
					case 0: // 석순(아래 -> 위) (H보다 큰 값을 가지는 최초의 석순을 찾는다)
//						System.out.println("석순");
//						System.out.println("i : " + i);
//						System.out.println(ar[j][mid]);
						if(ar[j][mid] > i) {
//							System.out.println("end의 값이 변함"+(mid-1));
							end = mid-1;
							mid = (start + end)/2;
						}
						else if(ar[j][mid] <= i) {
//							System.out.println("start의 값이 변함"+(mid+1));
							start = mid+1;
							mid = (start + end)/2;
						}
						if(start > end) {
							int block_obs = end;
//							System.out.println(i+"에서찾는 값 : "+end);
//							System.out.println("통과해야 하는 석순의 수 : " + (ar[0].length - (block_obs+1)));
							obstacle += (ar[0].length - (block_obs+1));
						}
						break;
					case 1: // 종유석(위 -> 아래) ( 
//						System.out.println("종유석");
//						System.out.println("H-i-1 : " + (H-i-1));
//						System.out.println(ar[j][mid]);
						if(ar[j][mid] > H-i-1) {
//							System.out.println("end의 값이 변함"+(mid-1));
							end = mid-1;
							mid = (start + end)/2;
						}
						else if(ar[j][mid] <= H-i-1) {
//							System.out.println("start의 값이 변함"+(mid+1));
							start = mid+1;
							mid = (start + end)/2;
						}
						
						if(start > end) {
							int block_obs = end;
//							System.out.println(i+"에서찾는 값 : "+end);
//							System.out.println("통과해야 하는 종유석의 수 : " + (ar[1].length - (block_obs+1)));
							obstacle +=(ar[j].length - (block_obs+1));
						}
						break;
					}
				}
			}
//			System.out.println(i + " 번 높이에서 없애는 장애물의 수 : " + obstacle);
			++height_obstacle[obstacle];
			if(min_obstacle > obstacle) {
//				System.out.println("장애물 수 갱신 " + obstacle);
				min_obstacle = obstacle;
			}
		}
		// 장애물의 최솟값 + 그러한 구간의 갯수
		sb.append(min_obstacle).append(" ").append(height_obstacle[min_obstacle]);
		System.out.println(sb.toString());
	}
}