package prob_숫자카드2_10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,aar[],bar[];
	static int start,mid,end,num,count,left,right;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		aar = new int[N+1];
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
			end = aar.length;
			num = bar[i];
			right = 0;
			left = 0;
			
			getLeft(start,mid,end,num);
			getRight(start,mid,end,num);
//			System.out.println(left + " " + right);
			System.out.print(right-left + " ");
//			sb.append(right-left).append(" ");
		}
		System.out.println(sb);
	}
	static void getRight(int start,int mid,int end,int num) {
		while(true) {
			if(start >= end) {
				right = start;
				return;
			}
			if(aar[mid] <= num) {
				start = mid+1;
				mid = (start + end)/2;
			}
			else if(aar[mid] > num) {
				end = mid;
				 mid = (start+end)/2;
			}
		}
	}

	static void getLeft(int start,int mid,int end,int num) {
		while(true) {
			if(start >= end) {
				left = start;
				return;
			}
			if(aar[mid] < num) {
				start = mid+1;
				mid = (start+end)/2;
			}else if(aar[mid] >= num) {
				 end = mid;
				 mid = (start+end)/2;
			}
		}
	}
}
