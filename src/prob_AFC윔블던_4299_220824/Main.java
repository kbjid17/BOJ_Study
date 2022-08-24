package prob_AFC윔블던_4299_220824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int[] ar = new int[2];
		for (int i = 0; i < 2; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}

		int[] ar_2 = new int[2];	
		ar_2[0] = (ar[0] + ar[1]) /2;
		ar_2[1] = (ar[0] - ar[1]) /2;
		
		Arrays.sort(ar_2);
		
		if(ar_2[1] + ar_2[0] != ar[0] || ar_2[1] - ar_2[0] != ar[1]) System.out.println(-1);
		else if(ar_2[0] < 0 || ar_2[1] < 0) System.out.println(-1);
		else {
			System.out.println(ar_2[1] + " " + ar_2[0]);
		}
		
	}

}
