package prob_숫자카드2_10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static int N,M,aar[],bar[];
	static int start,mid,end,num;
	static StringBuilder sb = new StringBuilder();
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
			mid = (aar.length + start)/2;
			end = aar.length;
			num = bar[i];
			

//			System.out.println(left + " " + right);
//			System.out.print(right-left + " ");
			sb.append(getRight(start,mid,end,num)-getLeft(start,mid,end,num)).append(" ");
		}
		System.out.println(sb);
	}
	static int getRight(int start,int mid,int end,int num) {
		while(start < end) {
			mid = (start + end)/2;
			if(aar[mid] > num) {
				end = mid;
			}
			else start = mid+1;
		}
		return start;
	}

	static int getLeft(int start,int mid,int end,int num) {
		while(start < end) {
			mid = (start + end)/2;
			if(aar[mid] >= num) {
				end = mid;
			}
			else start = mid+1;
		}
		return start;
	}
}
