package prob_1269;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int AB,BA;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Stack<Integer> aar = new Stack<Integer>();
		Stack<Integer> bar = new Stack<Integer>();
		Stack<Integer> ac = new Stack<Integer>();
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < A; i++) {
			aar.push(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < B; i++) {
			bar.push(Integer.parseInt(st.nextToken()));
		}
		for (int a : aar) {
			if(!bar.contains(a)) {
				AB +=1;
			}
		}
		for (int b : bar) {
			if(!aar.contains(b)) {
				BA +=1;
			}
		}
		System.out.println(AB + BA);
	}
}