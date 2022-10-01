package prob_Exam_18411_221001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		int[] ar = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ar);
		System.out.println(ar[2] + ar[1]);
	}

}
