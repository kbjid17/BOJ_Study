package prob_2225_합분해_3트만에해결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int num;
	//더해지는 정수는 같을 수 있음. (0,0 이나 10, 10 등 모두 가능)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cal(N,K);
		System.out.println(cal(N,K));
	}
	static int cal(int n,int k) {
		if(k == 2) {
			return n+1;
		}
		else if(k == 1) {
			return 1;
		}
		else {
			return num = (((cal(n,k-1) * (1 + cal(n,k-1))))/2) % 1000000000;
		}
	}
}
