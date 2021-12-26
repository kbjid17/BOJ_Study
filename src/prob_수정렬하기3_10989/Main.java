package prob_수정렬하기3_10989;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,max,num;
	static int[] ar,ar2,ar3,counting;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, ar[i]);
		}
		ar2 = new int[max+1];
		for (int i = 0; i < N; i++) {
			ar2[ar[i]]++;
		}
		ar3 = new int[max+1];
		for (int i = 0; i < ar3.length; i++) {
			num+= ar2[i];
			ar3[i] = num-1;
		}
		counting = new int[N];
		for (int i = N-1; i >= 0; i--) {
			counting[ar3[ar[i]]] = ar[i];
			ar3[ar[i]]--;
		}
		for (int i = 0; i < N; i++) {
			sb.append(counting[i]).append("\n");
		}
		System.out.println(sb);
	}

}
