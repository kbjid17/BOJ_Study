package prob_단어정렬_1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int N;
	static ArrayList<String> lis = new ArrayList<String>();
	static ArrayList<Word> li = new ArrayList<Word>(); 
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(!lis.contains(str)) {
				lis.add(str);
				li.add(new Word(str));
			}
		}
		Collections.sort(li);
		for (Word wd : li) {
			sb.append(wd.w).append("\n");
		}
		System.out.println(sb);
	}
	static class Word implements Comparable<Word> {

		String w;
		
		public Word(String w) {
			super();
			this.w = w;
		}

		@Override
		public int compareTo(Word o) {
			//1. 길이가 길면 먼저 들어감
			if(this.w.length() > o.w.length()) {
				return 1;
			} else if(this.w.length() == o.w.length()) { //길이가 같을 경우 -> 아스키코드 합이 작은 순으로 정렬하면 되지 않을까?
				int a = 0;
				int b = 0;
				for (int i = 0; i < this.w.length(); i++) {
					a += this.w.charAt(i)-'0';
					b += o.w.charAt(i)-'0';
				}
				if(a > b) {
					return 1;
				} else { 
					return -1;
				}
			}
			return -1;
		}
		
	}
}
