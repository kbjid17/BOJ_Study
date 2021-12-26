package prob_좌표압축_18870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int item = Integer.parseInt(st.nextToken());
			nums[i] = item;
			if(!list.contains(item)) list.add(item);
		}
		qSort(0,list.size()-1);
		for (Integer s : list) {
//			System.out.println(list.indexOf(s));
		}
		for (int i = 0; i < N; i++) {
			sb.append(list.indexOf(nums[i])).append(" ");
		}
		System.out.println(sb);
		// b 배열을 하나 만들어 정렬된 수의 인덱스를 기억(같은 수가 여러 개 있을 경우 가장 작은 수만 기억) (ex. 0번 인덱스 : -3 , 5번 인덱스 수 : 10
		// 이후 처음에 입력한 a배열의 원소가 b배열의 어느 인덱스에 위치해있는지를 출력

		
	}
	static void qSort(int start,int end) {
		if(start >= end) return;
		int pivot = start;
		int left = start+1;
		int right = end;
		while(left <= right) {
			while(left <= end && list.get(left) <= list.get(pivot)) left+=1;
			while(right > start && list.get(right) >= list.get(pivot)) right-=1;
			if(left > right) {
				int temp = list.get(right);
				list.set(right, list.get(pivot));
				list.set(pivot, temp);
			} else {
				int temp = list.get(left);
				list.set(left, list.get(right));
				list.set(right, temp);
			}
			qSort(start,right-1);
			qSort(right+1,end);
		}
	}
}