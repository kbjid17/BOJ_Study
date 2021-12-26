package prob_하노이탑이동순서_11729;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int K,a,b,c;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		int num = (int)Math.pow(2, K)-1;
		System.out.println(num);
		hanoi(K,1,3,2);
		System.out.println(sb);
	}
		static void hanoi (int k,int from,int to,int mid) {
			if(k == 1) {
				sb.append(from + " " + to + "\n");
				return;
			} else {
				hanoi(k-1,from,mid,to);
				
				sb.append(from + " " + to + "\n");
				
				hanoi(k-1,mid,to,from);
			}
		}
}
