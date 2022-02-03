package prob_종이의개수_1780_미룸;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,c1,c2,c3; // c1 : -1로만 채워진 종이 수 , c2 : 0으로만 채워진 종이 수, c3 : 1로만 채워진 종이 수
	static boolean[][] paper;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(1,1,N,N,ar[1][1],N);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
	/*
		paper
		주어진 영역을 돌아보면서
		모두 같은 카드가 되면 해당 값에 해당하는 c를 ++ 해주면서 종료
		다른 카드가 있을 경우 
	 */
	static void paper(int sy,int sx,int ey,int ex,int value,int size) {
		int papers = value;
		for (int i = sy; i <= ey; i++) {
			for (int j = sx; j <= ex; j++) {
				if(ar[i][j] != value) {
					papers = -2;
					break;
				}
			}
			if(papers != value) break;
		}
		switch(papers) {
		case -1 :
			c1++;
			return;
		case 0 : 
			c2++;
			return;
		case 1:
			c3++;
			return;
		default:
			if(sy >= N || sx >= N || ey > N || ex > N || size <= 0) return;
//			paper(sy,sx,sy+(int)Math.sqrt(size)-1,sx+(int)Math.sqrt(size)-1,ar[sy][sx],(int)Math.sqrt(size));
//			paper(sy,sx+(int)Math.sqrt(size),sy+(int)Math.sqrt(size)-1,sx+2*(int)Math.sqrt(size)-1,ar[sy][sx+(int)Math.sqrt(size)],(int)Math.sqrt(size));
//			paper(sy,sx+2*(int)Math.sqrt(size),sy+(int)Math.sqrt(size)-1,ex,ar[sy][sx+2*(int)Math.sqrt(size)],(int)Math.sqrt(size));
//			
//			paper(sy+(int)Math.sqrt(size),sx,sy+2*(int)Math.sqrt(size)-1,sx+(int)Math.sqrt(size)-1,ar[sy+(int)Math.sqrt(size)][sx],(int)Math.sqrt(size));
//			paper(sy+(int)Math.sqrt(size),sx+(int)Math.sqrt(size),sy+2*(int)Math.sqrt(size)-1,(ex*2)/3,ar[sy+(int)Math.sqrt(size)][sx+(int)Math.sqrt(size)],(int)Math.sqrt(size));
//			paper(sy+(int)Math.sqrt(size),sx+2*(int)Math.sqrt(size),sy+2*(int)Math.sqrt(size)-1,ex,ar[sy+(int)Math.sqrt(size)][sx+2*(int)Math.sqrt(size)],(int)Math.sqrt(size));
//			
//			paper(sy+2*(int)Math.sqrt(size),sx,ey,sx+(int)Math.sqrt(size)-1,ar[sy+2*(int)Math.sqrt(size)][sx],(int)Math.sqrt(size));
//			paper(sy+2*(int)Math.sqrt(size),sx+(int)Math.sqrt(size),ey,sx+2*(int)Math.sqrt(size)-1,ar[sy+2*(int)Math.sqrt(size)][sx+(int)Math.sqrt(N)],(int)Math.sqrt(size));
//			paper(sy+2*(int)Math.sqrt(size),sx+2*(int)Math.sqrt(size),ey,ex,ar[sy+2*(int)Math.sqrt(size)][sx+2*(int)Math.sqrt(size)],(int)Math.sqrt(size));
			
//			paper(sy,sx,ey/3,ex/3,ar[sy][sx],size/N);
//			paper(sy,ex/3+1,ey/3,(ex*2)/3,ar[sy][ex/3+1],size/N);
//			paper(sy,(ex*2)/3+1,ey/3,ex,ar[sy][(ex*2)/3]+1,size/N);
//			
//			paper(ey/3+1,sx,(ex*2)/3,ex/3,ar[ey/3+1][sx],size/N);
//			paper(ey/3+1,ex/3+1,(ey*2)/3,(ex*2)/3,ar[ey/3+1][ex/3+1],size/N);
//			paper(ey/3+1,(ex*2)/3+1,(ey*2)/3,ex,ar[ey/3+1][(ex*2)/3+1],size/N);
//			
//			paper((ey*2)/3+1,sx,ey,ex/3,ar[(ey*2)/3+1][sx],size/N);
//			paper((ey*2)/3+1,ex/3+1,ey,(ex*2)/3,ar[(ey*2)/3+1][ex/3]+1,size/N);
//			paper((ey*2)/3+1,(ex*2)/3+1,ey,ex,ar[(ey*2)/3+1][(ex*2)/3+1],size/N);
			break;	
		}
	}
}
