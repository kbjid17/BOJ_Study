package prob_알고리즘수업_병합정렬1_24060_230219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] ar;
	static int[] tmp;;
	static int ans, cnt, k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ar = new int[Integer.parseInt(st.nextToken())];
		tmp = new int[ar.length];
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(0,ar.length-1);
		
		if(cnt < k) ans = -1;
		System.out.println(ans);
	}

	static void merge_sort(int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			
			merge_sort(start, mid);
			merge_sort(mid+1, end);
			merge(start,mid,end);
		}
	}
	
	static void merge(int start,int mid,int end) {
		int i = start;
		int j = mid+1;
		int t = 0;
		
		while(i <= mid && j <= end) {
			if(ar[i] <= ar[j]) 	tmp[t++] = ar[i++];
			else tmp[t++] = ar[j++];
		}
		
		while(i <= mid) tmp[t++] = ar[i++];
		
		while(j <= end) tmp[t++] = ar[j++];
		
		i = start;	t = 0;
		while(i <= end) {
			if(++cnt == k) {
				ans = tmp[t];
				return;
			}
//			System.out.println(++cnt + " " + tmp[t]);
			ar[i++] = tmp[t++];
		}
	}
}
