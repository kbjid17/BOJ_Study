package prob_단어정렬_1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main2 {

	static int N;
	static String[] ar;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new String[N];
		for (int i = 0; i < N; i++) {
			ar[i] = br.readLine();
		}
		Arrays.sort(ar,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2); // 사전순 정렬(이게 되네.. 신기하다)
				}
				else {
					return o1.length()-o2.length(); // 길이순 정렬
				}
			}
		});
		System.out.println(ar[0]);
		if(N >= 2) {
			for (int i = 1; i < N; i++) {
				if(!ar[i].equals(ar[i-1])) {
					System.out.println(ar[i]);
				}
			}
		}
	}	
}
