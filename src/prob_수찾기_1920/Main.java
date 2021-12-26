package prob_수찾기_1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,aar[],bar[];
	static int start,mid,end,num;
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		aar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			aar[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		bar = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			bar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(aar);
		for (int i = 0; i < M; i++) {
			//초기값 설정
			start = 0;
			mid = (aar.length-1 + start)/2;
			end = aar.length-1;
			num = bar[i];
			
			while(true) {
//				System.out.println(start + " " + mid + " " + end);
				if(start > end) {
					System.out.println(0);
					break;
				}
				if(aar[start] == num || aar[mid] == num || aar[end] == num) {
					System.out.println(1);
					break;
				}
				if(num > aar[mid]) {
					start = mid+1;
					mid = (start+end)/2;
				}else if(num < aar[mid]) {
					 end = mid-1;
					 mid = (start+end)/2;
				}
			}
		}
	}
}
