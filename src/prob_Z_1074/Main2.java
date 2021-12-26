package prob_Z_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N,r,c,size,count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int)Math.pow(2, N);

		start(size,r,c);
		System.out.println(count);
		
	}
	private static void start(int size, int r,int c) {
		if(size == 1) {
			return;
		}
		if(r < size/2  && c < size/2) { // 4사분면
			start(size/2,r,c);
		}
		else if(r < size/2 && c >= size/2) { // 1사분면
			count += (size*size/4)*1;
			start(size/2,r,c-size/2);
		}
		else if(r >= size/2 && c < size/2) { // 2사분면
			count += (size*size/4)*2;
			start(size/2,r-size/2,c);
		}
		else if(r >= size/2 && c >= size/2) {
			count += (size*size/4)*3;
			start(size/2,r-size/2,c-size/2);
		}
	}
}
