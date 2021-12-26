package prob_좌표압축_18870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main3 {
	static int N;
	static int[] ar,nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		ar = nums.clone();
		Arrays.sort(ar);
		Map<Integer,Integer> map = new HashMap<>();
		int idx = 0;
		for (int n : ar) {
			if(!map.containsKey(n))
				map.put(n, idx++);
		}
		for (int  n : nums) {
			sb.append(map.get(n)).append(" ");
		}
		
		System.out.println(sb);
		// b 배열을 하나 만들어 정렬된 수의 인덱스를 기억(같은 수가 여러 개 있을 경우 가장 작은 수만 기억) (ex. 0번 인덱스 : -3 , 5번 인덱스 수 : 10
		// 이후 처음에 입력한 a배열의 원소가 b배열의 어느 인덱스에 위치해있는지를 출력
	}
}