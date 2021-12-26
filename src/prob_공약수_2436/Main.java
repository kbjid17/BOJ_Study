package prob_공약수_2436;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long N,M;
	static long sum = Long.MAX_VALUE;
	static long[] number = new long[2];
	static long ansa,ansb;
	static ArrayList<Long> list = new ArrayList<Long>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken()); // 최대공약수
		M = Long.parseLong(st.nextToken()); // 최소공배수
		long startTime = System.currentTimeMillis();
//		System.out.println(gcd(N,M));
//		System.out.println(lcm(N,M));
		//최소공배수의 약수들 중,두 수를 곱했을 때 최소공배수가 나오고, 두 수의 유클리드 호제법을 이용해 최대공약수를 구했을 때 a가 나오면 해당 수를 keep.
		//위 두 조건을 맞추는 수들 중 두 수의 합이 가장 적은 경우의 수를 출력
		// 최대공약수 * 최소공배수 = ans1 * ans2
		// 두 수를 곱해서 최대공약수 * 최소공배수가 되는 모든 경우의 수 중, 두 수의 합이 가장 작은 경우를 찾아야 함.(결국 모든 경우를 찾아야 한다는 뜻.)
		// 두 수는 numb의 약수들 중에 있음.
		for (long i = 1; i <= M; i++) {
			if(M%i == 0)
				list.add(i); //약수 집어넣기
		}
		
		comb(0,0);
		System.out.println(ansa + " " + ansb);
		System.out.println(System.currentTimeMillis()-startTime);
	}
	static void comb(int start,int tgtidx) {
		if(tgtidx == 2) {
//			System.out.println(number[0] + " " + number[1]);
			if(gcd(number[0],number[1]) == N && lcm(number[0],number[1]) == M) {
				
				if(number[0] + number[1] < sum) {
					ansa = number[0];
					ansb = number[1];
					sum = number[0] + number[1];
				}
			}
			return;
		}
		for (int i = start; i < list.size(); i++) {
			number[tgtidx] = list.get(i);
			comb(i,tgtidx+1);
		}
	}
	static long gcd(long a,long b) {
		while(b > 0) {
			long temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	static long lcm(long a,long b) {
		return gcd(a,b) * a/gcd(a,b) * b/gcd(a,b);
	}
}