package prob_2447_별찍기10_시간초과_해결;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,num; //시작할 draw count를 결정하기 위함(N은 3의 num승)
	static char[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		//1승의 경우 가운데에 1*1 만큼의 빈공간이 생김 , 2승의 경우 가운데에 3*3으로 만들어진 공간이 빔, 3승의 경우 가운데에 9*9 만큼의 빈 공간이 생김
		//분할 정복
		//처음에 3의 1승 짜리를 하나 그리고, 다음에 3의 2승 짜리를 그린 다음(3의 1승 짜리로 3*3) 다음에 3의 3승 짜리를 그림(3의 2승 짜리로 9개)
		//3의 0승부터 시작 -> 1승부터 본격적 그림이 나오기 ( draw(1) -> draw(draw(1))-> draw(draw(draw1)) -> draw(draw(draw(draw1)))
		//가운데는 continue
		ar = new char[N][N];
		while(N/Math.pow(3, num) > 1) {
			num++;
		}
		
		draw(num,0,0);
		
		ar[0][0] = '*';
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ar[i][j]);
			}
			if(i < N-1)sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void draw(int count,int ystart,int xstart) {
			if(count == 0) return;
		
		if(count == 1) { //count == 1이면 draw 1을 실헹 => 기본 배열 생성
			for (int i = ystart; i < ystart+3; i++) {
				for (int j = xstart; j < xstart+3; j++) {
					if(i == ystart+1 && j == xstart+1) continue;
					ar[i][j] = '*';
				}
			}
		} else {
			int a = (int)Math.pow(3, count-1); //시작 포인트를 잡기 위함.
			for (int i = ystart; i < ystart+(int)Math.pow(3, count); i+= a) {
				for (int j = xstart; j < xstart+(int)Math.pow(3, count); j+= a) {
					if(i == ystart+a && j == xstart+a) continue;
					draw(count -1,i,j);
				}
			}
		}
			
			//count == 2이면 draw 2를 실행 => draw1을 8회 반복,
			//각 반복되는 draw들은 시작점이 달라짐.
			//count == 3이면 draw 3을 실행 => draw2를 8회 반복, 
		
	} 
}
