package prob_최소힙_1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,num;
	static long[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new long[200000];
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				if(ar[1] == 0) {
					System.out.println(0);
				}else {
					pop(num--);	
				}
			}
			else {
				push(++num,a);
			}
		}
	}
	static void push(int i,int a) {
//		System.out.println("num 값은 : " + i);
			ar[i] = a;
		if(i >= 2) {
			// 들어온 순간부터 부모보다 값이 같거나 크면
			if(ar[i] >= ar[i/2]) {
				return; // 그냥 끝내기
			}
			while(ar[i/2] > ar[i]) {
				if(i/2 == 1) { //결국 루트까지 가게 된다면 break;
					long temp = ar[i/2];
					ar[i/2] = ar[i];
					ar[i] = temp;
					return;
				}
				long temp = ar[i/2];
				ar[i/2] = ar[i];
				ar[i] = temp;
				i /= 2; // ar[i] 값이 부모(ar[i/2])보다 작으면 ar[i]를 부모로 이동
				
			}
			//ar[i] 값이 ar[i/2]보다 같거나 작을 경우

		}
	}
	static void pop(int i) {
		System.out.println(ar[1]); //꼭대기 값을 출력
		top(i); //맨 위에는 배열의 마지막 값이 들어올 것! 
	}
	//꼭대기엔 0이 아닌 값 중 가장 큰 작은이 와야 함!
	static void top(int i) {
		int n = i;
		ar[1] = ar[i]; //머리에 값 삽입(2. 맨 끝쪽 노드가 루트 노드가 됨)
		ar[i] = 0; // 이동시켰으므로 0 처리
//		System.out.println(ar[1]);
		i = 1; //루트 노드부터 계산을 진행해야 하므로 1로 만들어주기
		while(true) {
			if((ar[i] <= ar[2*i] && ar[i] <= ar[2*i+1]) || (ar[2*i] == 0 && ar[2*i+1] == 0) || (ar[i] <= ar[2*i]) && (ar[2*i+1] == 0)) 
			{
//				System.out.println("num 값은 : " + n);
//				System.out.println("주어진 큐의 순서는");
//				for (int j = 1; j < n; j++) {
//					System.out.print(ar[j] + " ");
//				}
				break; //2-4.리프노드이거나 한(두) 자식보다 값이 작거나 같으면 break; 
			}
				
			
			if(ar[i] > ar[2*i] && ar[i] <= ar[2*i+1]) { //2-3.넣은 값이 왼쪽 자식보다 값이 크고 오른쪽 자식보다는 같거나 작으면
				long temp = ar[i];
				ar[i] = ar[2*i];
				ar[2*i] = temp; // 왼쪽 자식과 바꿈
				i = 2*i; //계속 이 값을 봐줘야 함!
			} else if(ar[i] > ar[2*i+1] && ar[i] <= ar[2*i]) { // 2-2.넣은 값이 오른쪽 자식보다 값이 크고 왼쪽 자식보다는 같거나 작으면(작은 자식이랑 바꿔줘야 함)
				long temp = ar[i];
				ar[i] = ar[2*i+1];
				ar[2*i+1] = temp; // 오른쪽 자식과 바꿈
				i = 2*i+1;
			} else { // 2-1. 두 자식 값 중 어느 녀석보다도 크면
				//두 녀석 중 작은 값으로 변경
//				long min = Math.min(ar[2*i], ar[2*i+1]);
				long temp = ar[i];
				
				int num = 0;
				if(ar[2*i] <= ar[2*i+1]) {
					if(ar[2*i] <= 0) {
						num = 2*i+1;
					}
					else {
						num = 2*i;
					}
				} else if(ar[2*i+1] <= ar[2*i]) {
					if(ar[2*i+1] <= 0) {
						num = 2*i;
					}else {
						num = 2*i+1;
					}
				}
//				int num = (ar[2*i] <= ar[2*i+1] && ar[2*i] > 0) ? 2*i : (2*i+1); // 같으면 왼쪽 녀석 위주로
				ar[i] = ar[num];
//				System.out.println("min의 값은 : "+ar[num]);
				ar[num] = temp;
				i = num;
			}
		}
	}
}
