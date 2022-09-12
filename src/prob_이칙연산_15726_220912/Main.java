package prob_이칙연산_15726_220912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Double[] ar = new Double[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			ar[i] = Double.parseDouble(st.nextToken());
		}
		if((ar[0]*ar[1])/ar[2] > (ar[0]/ar[1])*ar[2]) {
			System.out.println((int)(ar[0]*ar[1]/ar[2]));
		}
		else {
			System.out.println((int)(ar[0]/ar[1]*ar[2]));
		}

	}

}
