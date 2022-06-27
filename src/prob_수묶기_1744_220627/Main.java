package prob_수묶기_1744_220627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Long> list = new ArrayList<Long>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long sum = 0;
		for (int i = 0; i < n; i++) {
			list.add(Long.parseLong(br.readLine()));
			sum += list.get(i);
		}
		Collections.sort(list); // n의 크기는 50 이하 -> 정렬에는 문제가 없음.
		int idx = 0;
		for (int i = list.size()-1; i >= 1; i--) {
			
			if(list.get(i) <= 0) {
				idx = i;
				break;
			}
			
			long add = list.get(i)+list.get(i-1);
			long mul= list.get(i)*list.get(i-1);
			if(sum-(list.get(i)+list.get(i-1)) > sum-(list.get(i)*list.get(i-1))) {
				sum -= add;
				sum += mul;
				list.remove(i);
				list.remove(i-1);
				list.add(i-1, mul);
				i -= 1; 
			}
			
		}
		
		// 음수 ~ 0
		for (int i = 0; i < idx; i++) {
			if(list.get(i) >= 0) break;
			long add = list.get(i)+list.get(i+1);
			long mul = list.get(i)*list.get(i+1);
			if(sum-add > sum-mul) {
				sum -= add;
				sum += mul;
				list.remove(i);
				list.remove(i);
				list.add(i,mul);

			}
		}
		System.out.println(sum);
	}

}
