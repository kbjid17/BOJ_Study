package prob_2156_포도주시식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_접근잘못됨 {

	static int n,sum,r;
	static int max = Integer.MIN_VALUE;
	static int[] ar,target;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ar = new int[n];
		selected = new boolean[n];
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		//1. 1개만 먹는 선택지
		//2. 현재 술이랑 다음 위치에 있는 술을 먹는 선택지
		//2번 과정에서 이전 술을 먹은 상태에서 2를 진행하면 안됨.
		
		//1번 후 한칸 이동해서 1은 됨.
		//1번 후 한칸 이동해서 2는 안됨.
		//1 ,12 ,
		
			for (int i = 1; i <= n; i++) {
				r = i;
				target = new int[i];
				comb(0,0);
			}

		System.out.println(max);
	}
		//dp를 뭐라고 정의해야 하지? : n까지 쓰는 함수랑 n 전까지 쓰는 함수가 그대로 계속 이어지는 논리를 사용(ex.점화식)
	static void comb(int cnt,int start) {;
			if(cnt == r) {
				//complete code
				if(cnt >= 3) { //배열의 크기가 3을 넘어갈 때
//					System.out.println("test : " + Arrays.toString(target));
					for (int j = 0; j < cnt-2; j++) {
						if(selected[j] && selected[j+1] && selected[j+2]) { //연속 3잔을 마시는 경우가 나오면
							//해당 조건은 옳지 않다는 것이 됨. ==> 생략
							//해당 조건을 만족하는 배열을 없애고,선택 배열을 초기화
							target = new int[r];
							selected = new boolean[n]; // 초기화
							//해당 조건이 성립되지 않을 경우 밑의 식을 진행
							return;
						}
					}
					//그렇지 않다면(위의 for문의 심사를 통과했다면)
					for (int j = 0; j < target.length; j++) {
						sum += target[j];
					}
					System.out.println(Arrays.toString(target));
					max = Math.max(max, sum);
//					System.out.println(sum);
					sum = 0;
					selected = new boolean[n]; // 초기화
					return;
					} 
					else {
						
					for (int j = 0; j < target.length; j++) {
						sum += target[j];
					}
					System.out.println(Arrays.toString(target));
					max = Math.max(max, sum);
					sum = 0;
					return;
				}
			}
			for (int j = start; j < n; j++) {
				target[cnt] = ar[j];
				selected[j] = true;
				comb(cnt+1,j+1);
			}
	}
}