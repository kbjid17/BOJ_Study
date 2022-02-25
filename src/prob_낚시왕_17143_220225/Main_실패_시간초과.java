package prob_낚시왕_17143_220225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_실패_시간초과 {
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,1,-1};
	static int R,C,M,ans;
	static shark[][][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//낚시왕의 초기 위치 : (0,0) -> (0,C)까지 이동
		//1초 동안 해당 일이 순서대로 일어남
		/*
		 1. 낚시왕이 오른쪽으로 한칸 이동(낚시왕 이동)
		 2. 낚시왕이 있는 열에 있는 상어 중 땅과 가장 가까운 상어를 잡음. 상어를 잡으면 격자판에서 잡은 상어가 사라짐 (상어 잡힘)
		 3. 상어가 이동(상어 이동)
		 4. 상어가 모두 이동한 후, 같은 칸에 여러마리의 상어가 있으면 가장 큰 상어가 나머지 상어를 먹어치움(제거)
		 */
		
		//상어는 속도가 주어짐( 칸/초 )
		//매 턴마다 상어가 이동할 때, 끝 칸에 도달하게 되면 방향을 반대쪽으로 돌려 남은 칸 수만큼 이동하게 됨.
		//이동했을 떄, 한 칸에 상어가 2마리 이상 있을 경우 가장 큰 상어가 나머지 상어를 모두 잡아먹음
		//new shark(행,열,속력,방향,크기)
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if(M == 0) {
			System.out.println(0);
			return;
		}
		ar = new shark[M][R+1][C+1]; //상어가 겹칠 수 있기 때문에 M만큼의 요소를 더 줘서 3차원 배열로 사용
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // y좌표
			int c = Integer.parseInt(st.nextToken()); // x좌표
			int s = Integer.parseInt(st.nextToken()); // 속도
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			
			ar[0][r][c] = new shark(s,d,z,false); //초기 상어는 0번 배열의 [r][c] 위치에 상어를 놔둠
		}
		
		for (int i = 1; i <= C; i++) { // 낚시왕 이동(1초부터 C초까지)
//			System.out.println(i + "초");
			// 1. 낚시왕이 있는 열에 있는 상어 중 땅과 가장 가까운 상어를 잡음. 상어를 잡으면 격자판에서 잡은 상어가 사라짐 (상어 잡힘)
			for (int j = 1; j <= R; j++) {
				if(ar[0][j][i] != null) { // 상어를 발견했을 경우
					ans += ar[0][j][i].z; // 해당 상어를 잡음
//					System.out.println(j+" "+i+"의 "+ar[0][j][i] + " 를 잡읍");
					ar[0][j][i] = null;
					break;
				}
			}
			// 2. 상어가 이동(상어 이동)
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if(ar[0][j][k] != null && !ar[0][j][k].moved) {
//						System.out.println(0 + " " + j + " " + k + " " + ar[0][j][k].s + " " + ar[0][j][k].d + " " + ar[0][j][k].z + " " + ar[0][j][k].moved + "에서 시작");
						shark sh = ar[0][j][k];
						sh.moved = false;
						ar[0][j][k] = null;
						int dist = sh.s;
//						System.out.println(dist);
						int r = j;
						int c = k;
						int my = dy[sh.d];
						int mx = dx[sh.d];
						while(dist > 0) {
							if(r <= 1 | r >= R || c <= 1 || c >= C) { //이동 진행 전, 해당 위치가 배열 끝으로 도달했을 경우!
								if(r <= 1 && sh.d ==1) 	sh.d = 2; // 윗쪽 -> 아랫쪽
								else if(r >= R && sh.d == 2) sh.d = 1; // 아랫쪽 -> 윗쪽
								else if(c <= 1 && sh.d == 4) sh.d = 3; // 왼쪽 -> 오른쪽
								else if(c >= C && sh.d == 3) sh.d = 4; // 오른쪽 -> 왼쪽
								
								my = dy[sh.d];
								mx = dx[sh.d];
							}
							
							
							
							r += my;
							c += mx;
							dist--;
						}
						//이동이 끝났는데 이미 그곳에 상어가 있다면
						int dim = 0;
						
						while(ar[dim][r][c] != null) {
							dim++;
						}
//						ar[dim][r][c] = ar[0][j][k];
						ar[dim][r][c] = new shark(sh.s,sh.d,sh.z,true);
//						System.out.println(dim + " " +r + " " +c + " " +sh.s + " " +sh.d + " " +sh.z + " " +ar[dim][r][c].moved);
						// 이동을 한 후, 해당 칸에 있었던 상어 위치를 지움
						// 해당 칸을 지울 때 다른 상어의 정보도 지워지는가?
						// 지워지지 않는다. 
						// => 매 이동 시작시 해당 칸엔 상어가 한마리씩밖에 존재할 수 없으며, 이전 시간에 이동이 끝났을 때 다른 상어는 모두 먹혔기 때문
						// 이동 결과, 같은 칸에 위치할 수 있음. 초기 상어 정보를 저장하고 해당 배열에 있는 상어는 삭제한 후 이동을 진행해야 할듯.
					}
				}
			}
			// 각 상어를 찾아 이동을 진행
			//3. 모든 상어가 이동한 후, 같은 위치에 상어가 겹치면 해당 상어를 먹어치움
			// 위치는 변할 필요 없고, 방향과 크기만 0번에 집어넣으면 될것!
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					for (int d = 0; d < M; d++) {
						if(ar[d][j][k] != null) {
							int maxsize = 0;
							int maxdist = 0;
							int dir = 0;
							for (int q = d; q < M; q++) {
								if(ar[q][j][k] == null) break;
								
								if(maxsize < ar[q][j][k].z) {
									
									maxsize = ar[q][j][k].z;
									maxdist = ar[q][j][k].s;
									dir = ar[q][j][k].d;
								}
								
							}
							ar[d][j][k].s = maxdist;
							ar[d][j][k].d = dir;
							ar[d][j][k].z = maxsize;
							ar[d][j][k].moved = false;
							ar[0][j][k] = new shark(maxdist,dir,maxsize,false);
							for (int l = 1; l < M; l++) {
								
								ar[l][j][k] = null;
							}
//							System.out.println(j + " " +k +"에서의 최대 크기 : " + maxsize); 
							break;
						}
					}
					
				}
			}
			
			//이동 : (현재 위치값 + 이동 속도) => 현재 위치에서 속도만큼 이동
			// while(C < (현재 위치값+이동 속도)) 방향을 바꿔야 한다면?
			 
			 
			 //이동을 했는데 해당 칸에 이미 상어가 있다?
			 //[1][r][c]에 상어를 놔두고 for문으로 가장 큰 상어를 찾아 나머지 작은 상어들을 다 죽이고 가장 큰 상어를 0번 칸으로 이동시킴
			 
		}
		System.out.println(ans);
	}
	static class shark {

		int s; // 속력
		int d; // 방향
		int z; // 크기
		boolean moved;

		public shark(int s, int d, int z, boolean moved) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
			this.moved = moved;
		}

		@Override
		public String toString() {
			return "shark [s=" + s + ", d=" + d + ", z=" + z + ", moved=" + moved + "]";
		}

		
		
		
	}
}
