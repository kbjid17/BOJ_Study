package prob_마법사상어와토네이도_20057_220531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정리 {
	static int N;
	static int[][] ar;
	static long ans;
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
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
		
		int ny = (N+1)/2;
		int nx = (N+1)/2; 
		int dir = 0;
		int dis = 1;
		int round = 0;
		while(!(ny == 1 && nx == 1)) { 
			for (int i = 0; i < dis; i++) {
				ny = ny+dy[dir]; 
				nx = nx+dx[dir]; 

				int sand = ar[ny][nx];
				if(sand == 0) {
					if(ny == 1 && nx == 1) break;
					continue;
				}
				else {
					int p_1 = ar[ny][nx]/100;
					int p_2 = ar[ny][nx]/50;
					int p_5 = ar[ny][nx]/20;
					int p_7 = (ar[ny][nx]*7)/100;
					int p_10 = ar[ny][nx]/10;
					
					if(dir == 0 || dir == 2) {
						if(ny-1 > 0) ar[ny-1][nx] += p_7;
						else ans += p_7;
						if(ny -2 > 0) ar[ny-2][nx] += p_2;
						else ans += p_2;
						if(ny+1 <= N) ar[ny+1][nx] += p_7;
						else ans += p_7;
						if(ny+2 <= N) ar[ny+2][nx] += p_2;
						else ans += p_2;
						
						if(dir == 0) {
							if(ny-1 >0 && nx-1 > 0) ar[ny-1][nx-1] += p_10;
							else ans += p_10;
							if(ny+1 <= N && nx-1 > 0) ar[ny+1][nx-1] += p_10;
							else ans += p_10;
							if(ny-1 > 0 && nx+1 <= N) ar[ny-1][nx+1] += p_1;
							else ans += p_1;
							if(ny+1 <= N && nx+1 <= N) ar[ny+1][nx+1] += p_1;
							else ans += p_1;
							
							if(nx-2 > 0) ar[ny][nx-2] += p_5;
							else ans += p_5;
							
							if(nx -1 > 0) ar[ny][nx-1] += (ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2)));
							else ans += (ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2)));
							
							ar[ny][nx] = 0;
						}
						else if(dir == 2) {
							if(ny-1 >0 && nx-1 > 0) ar[ny-1][nx-1] += p_1;
							else ans += p_1;
							if(ny+1 <= N && nx-1 > 0) ar[ny+1][nx-1] += p_1;
							else ans += p_1;
							if(ny-1 > 0 && nx+1 <= N) ar[ny-1][nx+1] += p_10;
							else ans += p_10;
							if(ny+1 <= N && nx+1 <= N) ar[ny+1][nx+1] += p_10;
							else ans += p_10;
							
							if(nx+2 <= N)	ar[ny][nx+2] += p_5;
							else ans += p_5;
							
							if(nx +1 <= N) ar[ny][nx+1] += (ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2)));
							else ans += (ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2)));
							
							
							ar[ny][nx] = 0;
						}
					}
					else if(dir == 1 || dir == 3) {
						if(nx-1 >0) ar[ny][nx-1] += p_7;
						else ans += p_7;
						if(nx-2 >0) ar[ny][nx-2] += p_2;
						else ans += p_2;
						if(nx+1 <= N) ar[ny][nx+1] += p_7;
						else ans += p_7;
						if(nx+2 <= N) ar[ny][nx+2] += p_2;
						else ans += p_2;
						
						if(dir == 1) { //하
							if(ny-1 >0 && nx-1 > 0) ar[ny-1][nx-1] += p_1;
							else ans += p_1;
							if(ny-1 > 0 && nx+1 <= N) ar[ny-1][nx+1] += p_1;
							else ans += p_1;
							if(ny+1 <= N && nx-1 > 0) ar[ny+1][nx-1] += p_10;
							else ans += p_10;
							if(ny+1 <= N && nx+1 <= N) ar[ny+1][nx+1] += p_10;
							else ans += p_10;
							
							if(ny+2 <= N)	ar[ny+2][nx] += p_5;
							else ans += p_5;
							
							if(ny +1 <= N) ar[ny+1][nx] += ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2));
							else ans += (ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2)));
							
							ar[ny][nx] = 0;
						}
						else if(dir == 3) { // 상
							if(ny-1 >0 && nx-1 > 0) ar[ny-1][nx-1] += p_10;
							else ans += p_10;
							if(ny-1 > 0 && nx+1 <= N) ar[ny-1][nx+1] += p_10;
							else ans += p_10;
							if(ny+1 <= N && nx-1 > 0) ar[ny+1][nx-1] += p_1;
							else ans += p_1;
							if(ny+1 <= N && nx+1 <= N) ar[ny+1][nx+1] += p_1;
							else ans += p_1;
							
							if(ny-2 > 0) ar[ny-2][nx] += p_5;
							else ans += p_5;
							
							if(ny -1 > 0) ar[ny-1][nx] += ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2));
							else ans += (ar[ny][nx]-((p_1*2) + (p_2*2) + (p_5*1) + (p_7*2) + (p_10*2)));
							
							ar[ny][nx] = 0;
						}
					}
				}
				if(ny == 1 && nx == 1) break;
			}

			round++;
			if(round == 2) {
				round = 0;
				dis++;
			}
			dir = (dir+1)%4; // dir : 0~3
			
		}
		System.out.println(ans);
	}

}