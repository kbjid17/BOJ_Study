package prob_10974;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] input;
	static int[] number;
	static boolean[] isSelected;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		number = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		perm(0);

	}
static void perm(int cnt) {
	if(cnt == N) {
		for (int i = 0; i < N; i++) {
			System.out.print(number[i] +  " ");
		}
		System.out.println();
		return;
	}
	for(int i = 0; i < N; i++) {
		if(isSelected[i]) continue;
		
		
		number[cnt] = input[i];
		isSelected[i] = true;
		
		perm(cnt+1);
		isSelected[i] = false;
	}
}
}
