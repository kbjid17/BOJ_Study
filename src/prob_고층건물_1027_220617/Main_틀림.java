package prob_고층건물_1027_220617;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_틀림 {
	static int N;
	static long[] ar;
	static long ans = Long.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ar = new long[N+1];
		for (int i = 1; i <= N; i++) {
			ar[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
//			System.out.println(i);
			long val = 0;
			if(i > 1) {
				val+= cal_sub(i);
			}
			if(i < N) {
				val+= cal_add(i);
			}
			ans = Math.max(ans, val);
//			System.out.println(i + "에선 " + val);
		}
		System.out.println(ans);
	}

	static int cal_sub(int i) {
		int val = 0;
		double idx_sub = i;
		while(idx_sub > 1) {
			--idx_sub;
			long diff = ar[i]-ar[(int)idx_sub]; // 높이 차이
			double dist = i-idx_sub;
			
				for (int j = i-1; j >= idx_sub; j--) {
//					System.out.println("여기는" + j);
					if(j == idx_sub) {
//						System.out.println(idx_sub + "에 도착함!");
						val++;
						break;
					}
					if(diff > 0) { //A > B (ar[i] = A, ar[idx_sub] = B)
						if(ar[j] >= ar[i]-((diff/dist)*(i-j)) ) {
//							System.out.println("여기서 부딪힘!" + " " + i + " " + j + " " + idx_sub);
//							System.out.println(ar[i] + " " + ar[j]);
//							System.out.println(((diff/dist)*(i-j)));
							break;
						}
					}
					else if(diff == 0) { // A == B
						if(ar[j] >= ar[i]) {
							break;
						}
					}
					else if(diff < 0) { // A < B
						if(ar[j] >= ar[i]+((diff/dist)*(i-j)) ) {
//							System.out.println(((diff/dist)*(i-j)));
							break;
						}
					}
				}
		}
		return val;
	}
	
	static int cal_add(int i) {
		int val = 0;
		double idx_add = i;
		while(idx_add < N) {
			++idx_add;
			long diff = ar[i]-ar[(int)idx_add];
			double dist = idx_add-i;
			for (int j = i+1; j <= idx_add; j++) {
				if(j == idx_add) {
//					System.out.println(idx_add + " " + "에도 도착함!");
					val++;
					break;
				}
				if(diff > 0) { //A > B
					if(ar[j] >= ar[i]-((diff/dist)*(j-i))) {
						break;
					}
				}
				else if(diff == 0) { // A == B
					if(ar[j] >= ar[i]) {
						break;
					}
				}
				else if(diff < 0) { // A < B
					if(ar[j] >= ar[i]+((diff/dist)*(j-i))) {
						break;
					}
				}
			}
		}
		return val;
	}
}
