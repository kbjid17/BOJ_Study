package prob_다각형의면적_2166_221003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		double[][] ar = new double[n+1][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double y = Double.parseDouble(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			ar[i][0] = y;
			ar[i][1] = x;
			
			
		}
		ar[n][0] = ar[0][0];
		ar[n][1] = ar[0][1];
		
		double ysum =0;
		double xsum =0;
		for (int i = 0; i < ar.length-1; i++) {
			ysum += ar[i][0]*ar[i+1][1];
			xsum += ar[i+1][0]*ar[i][1];
		}
		
		double ans = (ysum - xsum)/2;
//		System.out.println((ysum - xsum)/2);
		System.out.println(String.format("%.1f", Math.abs(ans)));
	}
}
