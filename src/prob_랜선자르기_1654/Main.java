package prob_랜선자르기_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static long start = 1,end,mid,ar[],sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ar = new long[K];
		for (int i = 0; i < K; i++) {
			ar[i] = Long.parseLong(br.readLine());
			end = Math.max(end, ar[i]);
		}
		/* 처음 : 가장 긴 랜선을 기준으로 mid값을 설정
		 * 해당 mid 값을 기준으로 각 랜선의 길이를 잰 후, N개 만큼의 랜선이 안나오면 다시 mid 값 구하기
		 * N개 만큼의 랜선이 나올 경우
		 * - 일단 해당 길이를 저장
		 * - 이후 start/mid/end를 비교해가며 start > end가 될 때까지 진행 
		*/
		while(start <= end) {
			mid = (start+end)/2;
			sum = 0;
			for (int i = 0; i < K; i++) {
				sum += ar[i]/mid;
			}
			if(sum >= N) { //랜선을 자를 수 있는 경우
				start = mid+1;
				
			} else { //그렇지 못할 경우
				end = mid-1;
			}
			
		}
		System.out.println(end);
	}
}