package prob_좋다_1253_230903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] ar;
	static long answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ar = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(ar);
		for (int i = 0; i < N; i++) {
			answer += check(i);
		}
		

		System.out.println(answer);
	}

	
	static long check(int idx) {
		int num = 0;
		int start = 0;
		int end = 0;

		switch(idx) {
			case 0:
				start = 1;
				end = N-1;
				break;
			case 1:
				start = 0;
				end = N-1;
				break;
			default:
				start = 0;
				end = N-1;
				break;
		}
			while(true) {
				if(start == idx) {
					start++;
					continue;
				}
				if(end == idx) {
					end--;
					continue;
				}
				if(start == end) break;
				
				long val = ar[start] + ar[end];
				
				if(val > ar[idx]) {
					end--;
				}
				else if(val < ar[idx]) {
					start++;
				}
				else if(val == ar[idx]) {
					num = 1;
					break;
				}
			}
		
		return num;
	}
}
