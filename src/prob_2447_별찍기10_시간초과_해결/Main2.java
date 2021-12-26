package prob_2447_별찍기10_시간초과_해결;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int N;
	static char[][] ar;
	static StringBuilder sb = new StringBuilder();
	static boolean blank; //가운데가 비어있음을 알려주기 위한 함수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		ar = new char[N][N];
		
		
		draw(N,0,0,false);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ar[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void draw(int size,int ystart,int xstart, boolean blank) { //크기,y시작점,x시작점,비어있는지 여부
		if(blank) { //빈곳이면
			for (int i = ystart; i < ystart+size; i++) {
				for (int j = xstart; j < xstart+size; j++) {
					ar[i][j] = ' ';
				}
			}
			return;
		}
		
		if(size == 1) { //더이상 쪼갤 수 없으면
			ar[ystart][xstart] = '*';
			return;
		}
		
		for (int i = ystart; i < ystart+size; i+=(size/3)) {
			for (int j = xstart; j < xstart+size; j+=(size/3)) {
				if(i == ystart + (size/3) && j == xstart + (size/3)) {
					draw(size/3,i,j,true); //현재 사이즈에서 9호에 걸쳐 1/3 사이즈로 재귀 수행(blank로 이동)
				}
				else {
					draw(size/3,i,j,false); //현재 사이즈에서 9호에 걸쳐 1/3 사이즈로 재귀 수행
				}
			}
		}
		
	} 
}
