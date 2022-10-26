package prob_다각형의면적_2166_221003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_신발끈공식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		double max_y = Double.MIN_VALUE;
		double min_y = Double.MAX_VALUE;
		double max_x = Double.MIN_VALUE;
		double min_x = Double.MAX_VALUE;
		double[][] ar = new double[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double y = Double.parseDouble(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			ar[i][0] = y;
			ar[i][1] = x;
			if(y > max_y) max_y = y;
			if(y < min_y) min_y = y;
			if(x > max_x) max_x = x;
			if(x < min_x) min_x = x;
		}
		
		double center_y = (max_y + min_y)/2;
		double center_x = (max_x + min_x)/2;
		System.out.println(center_y + " " + center_x);
		double ans = 0;
		for (int i = 0; i < n; i++) {
			if(i == n-1) {
				double point_y = (ar[i][0] + ar[0][0])/2;
				double point_x = (ar[i][1] + ar[0][1])/2;
				System.out.println(point_y + " " + point_x);
				double width = Math.sqrt(Math.pow((ar[0][0]-ar[i][0]),2) + Math.pow((ar[0][1] - ar[i][1]), 2));
				double height = Math.sqrt(Math.pow(center_y - point_y, 2) + Math.pow(center_x - point_x, 2));
				System.out.println("길이와 높이 : " + width + " " + height );
				System.out.println("넓이 : " + (width * height)/2);
				ans += ((width * height)/2);
			}
			else {
				double point_y = (ar[i][0] + ar[i+1][0])/2;
				double point_x = (ar[i][1] + ar[i+1][1])/2;
				System.out.println(point_y + " " + point_x);
				double width = Math.sqrt(Math.pow(ar[i][0]-ar[i+1][0],2) + Math.pow(ar[i][1] - ar[i+1][1], 2));
				double height = Math.sqrt(Math.pow(center_y - point_y, 2) + Math.pow(center_x - point_x, 2));
				System.out.println("길이와 높이 : " + width + " " + height );
				System.out.println("넓이 : " + (width * height)/2);
				ans += ((width * height)/2);
			}
		}
		System.out.println(ans);
	}
}
