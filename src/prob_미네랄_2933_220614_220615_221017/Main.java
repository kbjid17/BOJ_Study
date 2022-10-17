package prob_미네랄_2933_220614_220615_221017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0,-1,0,1};
	static int[] dx = {-1,0,1,0};
	static int R,C,T;
	static char[][] ar;
	static int[] turn;
	static Queue<int[]> group = new LinkedList<int[]>(); // 특정 그룹의 시작점을 넣어놓기(여러개의 그룹이 생겨날 수 있다.)
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ar = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			ar[i] = br.readLine().toCharArray();
		}
		T = Integer.parseInt(br.readLine());
//		System.out.println(T);
		turn = new int[T+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < turn.length; i++) {
			
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					System.out.print(ar[j][k]);
				}
				System.out.println();
			}
			System.out.println("여기서 시작");
			turn[i] = Integer.parseInt(st.nextToken());
			int able = -1;
			if(i % 2 != 0) { // 홀수일 떄 : 높이에서 가장 왼쪽에 있는 미네랄을 파괴.
				for (int j = 0; j < C; j++) {
					if(ar[R-turn[i]][j] == 'x') {
						able = j;
						break;
					}
				}
				if(able == -1) continue;
				destroy(R-turn[i], able);
			}
			else { // 짝수일 때 : 높이에서 가장 오른쪽에 있는 미네랄을 파괴.
				for (int j = C-1; j >= 0; j--) {
					if(ar[R-turn[i]][j] == 'x') {
						able = j;
						break;
					}
				}
				if(able == -1) continue;
				destroy(R-turn[i], able);
			}
			
			System.out.println("--------------------" + i + "번 단계의 완성작-----------------------------");
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					System.out.print(ar[j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
		
		
	}
	static void destroy(int y, int x) { // [i][j]의 미네랄을 파괴
		System.out.println(y + " " + x);
		/*
			해당 미네랄이 속한 클러스터의 구성을 확인
			- 상하좌우를 확인하고 다른 미네랄이 없으면 부수고 끝, 있다면 bfs로 구성 확인
			- 미네랄 파괴 -> 찾았던 구성에서 해당 미네랄을 뺀 후, 해당 미네랄의 구성 중 가장 높이가 낮은(R-1에 가까운) 미네랄의 높이를 체크.
			(수정) 파괴할 미네랄 위의 요소를 큐에 넣어 그룹을 구축한 후, 그룹이 있다면 계속 진행
			(양옆이나 아래에 미네랄이 있다 => 내려오기 이전의 미네랄 덩이는 이미 다 내려온 상태이고, 더 내려올 곳이 없을것임.)
			-- 높이가 R-1이면 종료.
			-- 높이 < R-1 이면 "내리기" 진행
			 => 한칸씩 내리기!
			 => 다른 배열(copy_ar)에서 한칸씩 내려갈 때의 미네랄 구성을 구함.
			 => 해당 미네랄 구성을 ar에 넣을 수 있는지 체크
			 ==> 있으면 한칸 내림
			 ==> 만약 copy_ar의 구성요소 중 배열을 벗어나거나(R-1을 넘어감) 기존에 존재하던 미네랄과 겹친다면,
			 ==> 해당 내리기는 시행하지 않고 종료.
		 */
		
		// 해당 미네랄이 속한 클러스터의 구성을 확인
		// 상하좌우를 확인하고 다른 미네랄이 없으면 부수고 끝
		boolean exist = false; // 그룹이 존재하는지 확인하는 변수
		int ny = 0;
		int nx = 0;
		for (int d = 0; d < 4; d++) {
			ny = y + dy[d];
			nx = x + dx[d];
			if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			if(ar[ny][nx] =='x') {
				exist = true; // 그룹이 존재한다면 다음 단계로 이동
				group.offer(new int[] {ny,nx});
			}
		}
		
		if(!exist) { // 그룹 없이 혼자면 부수고 끝
			ar[y][x] = '.';
			return;
		}
		else { // 그룹이 있다면
			ar[y][x] = '.';
			while(!group.isEmpty()) {
				int[] point = group.poll(); // 이곳을 기준으로 그룹을 생성해보자.
				System.out.println(Arrays.toString(point));
				//bfs로 구성 확인
				boolean[][] selected = new boolean[R][C];
				char[][] copy_ar = new char[R][C];
				// 초기화
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						copy_ar[i][j] = '.';
					}
				}
				selected[point[0]][point[1]]= true;
				copy_ar[point[0]][point[1]] = 'x';
				q.offer(new int[] {point[0],point[1]});
				int min_deep = Integer.MIN_VALUE;
				while(!q.isEmpty()) {
					int[] n = q.poll();
					ar[n[0]][n[1]] = '.'; // 그룹이 존재한다 -> 일단 ar에선 해당 그룹을 삭제.
					min_deep = Math.max(min_deep, n[0]);
					for (int d = 0; d < 4; d++) {
						ny = n[0] + dy[d];
						nx = n[1] + dx[d];
						if(ny < 0 || ny >= R || nx < 0 || nx >= C || selected[ny][nx] || ar[ny][nx] == '.') continue;
						q.offer(new int[] {ny,nx});
						selected[ny][nx] = true;
						copy_ar[ny][nx] = 'x';
//						min_deep = Math.max(min_deep, ny);
					}
				}
//				System.out.println("copy_ar은");
//				for (int i = 0; i < R; i++) {
//					for (int j = 0; j < C; j++) {
//						System.out.print(copy_ar[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("로 되어 있다.");
				
				while(true) {
					if(min_deep == R-1) { // 더이상 내려갈 수 없으면, 복구하고 종료.
						for (int i = 0; i < R; i++) {
							for (int j = 0; j < C; j++) {
								if(copy_ar[i][j] == 'x') {
									ar[i][j] = 'x';
								}
							}
						}
						System.out.println("결과 : ");
						for (int i = 0; i < R; i++) {
							for (int j = 0; j < C; j++) {
								System.out.print(ar[i][j]);
							}
							System.out.println();
						}
						break;
					}
					else { // 더 내려갈 수 있다면!
						boolean found = false; // 가장 낮은 높이를 찾자!
						for (int i = R-1; i >= 1; i--) {
							for (int j = 0; j < C; j++) {
								if(copy_ar[i-1][j] == 'x') {
									if(!found) {
										found = true;
										min_deep = i;
									}
									copy_ar[i][j] = 'x';
									copy_ar[i-1][j] = '.';
								}
							}
						}
						// copy_ar에서 낮춘 후, ar에 들어갈 수 있는지 체크!!(겹치는 게 있으면 안됨.)
						boolean unable = false;
						for (int i = 0; i < R; i++) {
							for (int j = 0; j < C; j++) {
								if(ar[i][j] == 'x' && copy_ar[i][j] == 'x') { // 내려갈 수 없음!!!
									// 현재 copy_ar이 성립될 수 없다는 게 확인됐다!
									unable = true;
									break;
								}
								if(unable) break;
							}
							if(unable) break;
						}
						
						if(unable) { // 더이상 내려갈 수 없다면 -> copy_ar을 한칸 위로 올리는 것으로 copy_ar이 확정된다.
							for (int i = 0; i < R-1; i++) {
								for (int j = 0; j < C; j++) {
									if(copy_ar[i+1][j] == 'x') {
										copy_ar[i][j] = 'x';
										copy_ar[i+1][j]='.';
									}
								}
							}
							min_deep = R-1; // 더이상 내려갈 필요가 없으므로, min_deep을 R-1로 설정하여 ar에 붙여넣는 작업을 진행
							continue;
						}
						//더 내려갈 수 있다면 while문을 계속 진행
					}
				} 	
				
				
			}
		}
	}
}
