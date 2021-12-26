package prob_9184;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a,b,c;
	static int sum;
	static int[][][] ar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(a != -1 || b != -1 || c != -1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int a2 = a-1;
			int b2 = b-1;
			int c2 = c-1;
			ar = new int[21][21][21];
			
				if(a <= 0 || b <= 0 || c <= 0) {
					ar[a][b][c] = 1;
					sum += ar[a][b][c];
				}
				else if(a == b && b == c) {
					ar[a][b][c] = (int)Math.pow(2, a);
					sum += ar[a][b][c];
				}
				else if(a > 20 || b > 20 || c > 20)
					ar[a][b][c] =  ar[20][20][20];
					
				else if (a < b && b < c) {
					
					ar[a][b][c] = ar[a][b][c2] + ar[a][b2][c2] - ar[a][b2][c];
				}else {
					ar[a][b][c] = ar[a2][b][c] + ar[a2][b2][c] + ar[a2][b][c2] - ar[a2][b2][c2];
				}
			
			
			}
		
	}
	static int w(int a,int b,int c) {
		if(a <= 0 || b <= 0 || c <= 0)
				return 1;
		
		if(a == b && b == c)
			return (int)Math.pow(2, a);

		if(a > 20 || b > 20 || c > 20)
		return w(20, 20, 20);

		if (a < b && b < c) // a < b < c
		return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

		else 
			return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
}