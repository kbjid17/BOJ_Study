package prob_회의실배정_1931_220114_220625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N,ans,cnt;
	static int[][] ar;
	static int start,end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar[i][0] = Integer.parseInt(st.nextToken());
			ar[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ar, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] < o2[1]) return -1;
				if(o1[1] == o2[1]) {
					if(o1[0] < o2[0]) return -1;
				}
				return 1;
			}
		});
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(ar[i][0] + " " + ar[i][1]);
//		}
		ans = 1;
		start = ar[0][0];
		end = ar[0][1];
		for (int i = 1; i < N; i++) {
				if(ar[i][0] >= end) {
					ans++;
					start = ar[i][0];
					end = ar[i][1];
				}
			
		}
		//맨 위의 원소부터 한칸씩 내려오면서 확인을 진행
		/*
		 시작과 끝을 정한 후, 배열을 내려가면서 0번 배열의 값이 end 값과 같거나 큰 경우, cnt를 1 더한 후,start를 해당 위치의 [0]번 원소, end 값을 해당 위치의 [1]번 원소로 변경
		 */
		
		System.out.println(ans);
	}
}
