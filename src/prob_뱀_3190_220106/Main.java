package prob_뱀_3190_220106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,K,L;
	static boolean gameover;
	static int time;
	static long ans;
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static Deque<int[]> d = new LinkedList<int[]>();
	static space[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new space[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new space(i,j,false);
			}
		}
		d.offer(new int[] {1,1});
		// 처음의 뱀은 0,0에 1칸만 존재,목표 좌표를 추가하고(n칸만큼 이동하되, 실패 조건이 만족하면 게임 끝) 이동을 한 만큼 뒤의 뒷쪽에 있던 좌표를 제거
		// 뱀은 처음엔 오른쪽으로 이동
		// 3 D : 3초간 이동 후 오른쪽으로 90도 회전(오른쪽 -> 아랫쪽)
		// 5 L : 5초간 이동 후 왼쪽으로 90도 회전(아랫쪽 -> 오른쪽)
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].a = true;
		}
		L = Integer.parseInt(br.readLine());
		int dir = 0;
		for (int i = 0; i <= L; i++) {
			if(i == L) {
//				System.out.println(time);
				while(!gameover) {
//					System.out.println(d.peek()[0] + " " + d.peek()[1]);
					int ny = d.peekFirst()[0] + dy[dir];
					int nx = d.peekFirst()[1] + dx[dir];
					time++;
					
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) {
//						System.out.println("끝");
						gameover = true;
						ans = time;
						continue;
					}
					
					for (int[] a : d) {
						if(a[0] == ny && a[1] == nx) {
//							System.out.println("끝값 "+a[0] + " " + a[1]);
//							System.out.println("끝끝");
							gameover = true;
							ans = time;
							break;
						}
					}
					if(gameover) continue;
					
					d.offerFirst(new int[] {ny,nx});
					if(!map[ny][nx].a) d.pollLast();
					else map[ny][nx].a = false;
				}
			}
			else {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				String c = st.nextToken();
				
				
				for (int j = time; j < n; j++) {
					
					int ny = d.peekFirst()[0]+dy[dir];
					int nx = d.peekFirst()[1]+dx[dir];
					System.out.println(j + "초");
//					System.out.println(ny + " " + nx);
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) {
						System.out.println(ny + " " + nx);
						gameover = true;
						ans = j+1;
						break;
					}
					
					for (int[] a : d) {
						if(a[0] == ny && a[1] == nx) {
							gameover = true;
							ans = j+1;
							break;
						}
					}
					
					d.offerFirst(new int[] {ny,nx});
					if(!map[ny][nx].a) d.pollLast();
					else if(map[ny][nx].a)map[ny][nx].a = false;
				}
				
				// 같은 시간대의 회전 옵션을  여러개 넣었는데, 자꾸만 회전하게 됨
				if(time != n) {
					if(c.equals("D")) {
						if(dir == 3) dir = -1;
						dir +=1;
					}
					else if(c.equals("L")) {
						if(dir==0) dir = 4;
						dir -=1;
					}
				}
				time = n;
				if(gameover) break;
			}
		}
		System.out.println(ans);
	}
	
static class space {
	int y;
	int x;
	boolean a;
	public space(int y, int x, boolean a) {
		super();
		this.y = y;
		this.x = x;
		this.a = a;
	}	
}
}
