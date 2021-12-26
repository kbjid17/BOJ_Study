package prob_Z_1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,r,c,size;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int)Math.pow(2, N);
		ar = new int[size][size];
		ar[0][0] = 0;
		System.out.println(ar[r][c]);
		//짝(0포함) --> 홀(ex.0 -> 1) :옆칸 이동
		//홀 --> 짝(ex. 1-> 2) : 제곱에 따라 상호작용 수행
		//(((0 1 2 3) -> (4 5 6 7)) -> ((8 9 10 11) -> (12 13 14 15)))
		start(0,0,ar[0][0]);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void start(int a,int b, int d) {
		if(d < size) {
			if(ar[a][b] %2 == 0) { // 짝 --> 홀
				ar[a][b+1] = ar[a][b]+1;
				if(ar[a][b]+1 ==5) {
					System.out.println(a + " "+ (b+1));
				}
				start(a,b+1,ar[a][b+1]);
			}else if(ar[a][b] %2 != 0) { //홀 --> 짝
				int e = ar[a][b]+1;
				while(e > 0) {
					int c = 0;
					while( e  >= Math.pow(2, c)) { //ex.e = 34 ==> 1,2,4,8,16,32,64까지 2의 c승이 올라감 // (진행후) e의 남은 값은 2 ==> c는 2까지 올라감
						c++;
					}
					c-=1; // c = 5로 확정 // c = 1로 확정
					e -= Math.pow(2, c);
					if(c %2 == 0) {
						int move =(int) Math.pow(2, c/2)-1;
						a = a-move;
						b = b+1;
					} else if(c %2 != 0) { //5 %2 != 0 // 1%2 != 0
						int move = (int) Math.pow(2, (c/2)+1)-1; // move = 7 // move = 1
						a = a+1; // y값 이동 // y값 이동
						b = b-move; //x값은 -7 // x값은 -1
					}
					// 2의 c승만에 해당하는 연산 수행
				}//y값은 2가 남아있음
				ar[a][b] = d+1;
				start(a,b,d);
			}
		}
	}
}