package prob_오큰수_17298;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_시간초과_스택2개쓰면안됨 {

	static Stack<Integer> sk = new Stack<Integer>(); //수열 선언
	static Stack<Integer> sk_2 = new Stack<Integer>(); //오큰수를 찾기 위한 여정에 필요한 수열의 복제품
	//스택 2개 쓰면 안됨!!!(O(N^2)로 인해 시간초과 발생)
	static int N,ss;
	static int nge = - 1;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sk.push(Integer.parseInt(st.nextToken()));
		}
		sk_2 = (Stack<Integer>) sk.clone(); // 스택의 깊은 복사가 필요할듯
		//뽑아내는 도중 인덱스는 다른데 값이 같은 값이 나오면 생략해야함.
		//peek() 값의 인덱스가 달라도 값이 목표로 한 값과 같은 경우, 같은 인덱스가 나옴.
		//사이즈가 a의 인덱스 값+1이면 되지 않을까?
		for (int a : sk_2) {
			ss +=1; //첫번째,두번째,세번째 값을 기준으로 해야 하므로, 매 반복마다 ss를 1씩 증가시킴
			while(sk.size() != ss) {
				int num = sk.pop();
				if(num > a)
					nge = num;
			}
			sb.append(nge).append(" ");
			nge = -1;
			sk = (Stack<Integer>)sk_2.clone();
		}
		System.out.println(sb);
	}
}
