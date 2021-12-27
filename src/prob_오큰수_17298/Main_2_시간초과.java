package prob_오큰수_17298;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2_시간초과 {

	static Stack<Integer> sk = new Stack<Integer>(); //수열 선언
	//스택 2개 쓰면 안됨!!!(O(N^2)로 인해 시간초과 발생)
	//같은 이유로 2차원 배열도 안됨.
	static int N;
	static int nge = - 1;
	static int[] ar;
	static StringBuilder sb;
	static Stack<Integer> stc = new Stack<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//시간초과를 없애는 것이 관건!
		//가장 가까운 오른쪽에 원하는 숫자가 있으면 된다.
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			stc.push(-1);
			for (int j = i; j < N; j++) {
				if(ar[j] > ar[i]) {
					stc.pop();
					stc.push(ar[j]);
					break;
				}
			}
		}
		for (int a : stc) {
			System.out.print(a + " ");
		}
	}
}
