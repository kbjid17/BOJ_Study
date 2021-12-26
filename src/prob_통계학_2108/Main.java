package prob_통계학_2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N,many,manypos;
	static double sum;
	static int[] ar,quantity = new int[8001];
	static ArrayList<Integer> manyNum = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		/*
		 최빈값 구하기
		 1. 수를 넣을 때 빈도수를 계산
		 2. 가장 빈도수가 높은 녀석을 출력(가장 높은 빈도수를 가지는 수가 여러개일 경우엔 두번째로 작은 값을 출력)
		 */
		ar = new int[N];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(br.readLine()); // 수를 넣음
			quantity[ar[i]+4000]++;
			sum+= ar[i]; // 산술평균을 구하기 위해 합계를 구함
			many = Math.max(many, quantity[ar[i]+4000]);
		}
		
		for (int i = 0; i < quantity.length; i++) {
			if(quantity[i] == many) {
				manyNum.add(i-4000);
			}
			
		}
		if(manyNum.size() == 1) {
			manypos = manyNum.get(0);
		}
		else {
			manypos = manyNum.get(1);
		}
		System.out.println(Math.round(sum/N));
		Arrays.sort(ar);
		System.out.println(ar[N/2]);
		System.out.println(manypos);
		System.out.println(ar[N-1]-ar[0]);
	}
}
