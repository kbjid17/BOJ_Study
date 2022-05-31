package prob_마법사상어와토네이도_20057_220531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ar;
	static long ans; // 격자의 밖으로 나간 모래의 양을 출력해야함!
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0}; // 좌 -> 하 -> 우 -> 상 (2번 방향이 바뀔 때마다 이동 거리가 1씩 늘어남)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // N은 무조건 홀수
		ar = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 가운데 칸에 있는 모래의 양은 0 (토네이도가 [r][c]에 있다고 하면, [r][c]에는 모래가 없음.
		
		int ny = (N+1)/2;
		int nx = (N+1)/2; // 시작점 : [N/2][N/2]
		int dir = 0; // 이동 방향
		int dis = 1; // 이동 거리
		int round = 0;
		while(!(ny == 1 && nx == 1)) { // ar 배열의 중앙에서부터 이동 시작 -> [1][1]에 도달할 때까지 이동 진행
//			System.out.println(dir + " " + dis);
			for (int i = 0; i < dis; i++) {
				ny = ny+dy[dir]; // 토네이도의 새로운 y좌표
				nx = nx+dx[dir]; // 토네이도의 새로운 x좌표
				
				//토네이도의 이동.
				/*
				 비율이 적힌 칸으로 모래들이 이동(소숫점 단위는 버림) -> [ny+dy[dir]][nx+dx[dir]]로 나머지 모든 모래가 이동
				 (모래가 이미 있는 칸으로 이동하면 모래의 양은 더해짐)
				 */
				
				// 각 이동에 따라 비율을 지정해줘야 함.
//				System.out.println("새 위치 : " + ny + " " + nx);
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
//			System.out.println("이동 결과 : " + ny + " " + nx);
			// 해당 방향으로의 이동을 완료했다면 방향 및 거리를 바꿔주기
			round++; // 현재 dis값으로 2회 이동을 완료했을 시, dis값을 늘려줘야함.
			if(round == 2) {
				round = 0;
				dis++;
			}
			dir = (dir+1)%4; // dir : 0~3
			
		}
		System.out.println(ans);
	}

}
