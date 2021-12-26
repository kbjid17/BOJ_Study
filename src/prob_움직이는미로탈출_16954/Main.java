package prob_움직이는미로탈출_16954;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<point> queue = new LinkedList<point>();
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0,-1,1,1,-1,0};
	static int[] dx = {0,0,-1,1,1,1,-1,-1,0};
	static char[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ar = new char[8][8];
		visit = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
				ar[i] = str.toCharArray();
		}
		bfs(7,0,0);
	}
	static void bfs(int y,int x,int d) {
		visit[y][x] = true;
		queue.offer(new point(y,x,d));
		if(ar[y][x] == '#') {
			System.out.println(0);
			return;
		}
		
		while(!queue.isEmpty()) {
			point num = queue.poll();
			int pointy = num.y- num.d; // 이동 횟수만큼 y값을 --해서 비교할 위치를 계산
			if(pointy >= 0) {
				for (int i = 0; i < 9; i++) {
					int ny = num.y + dy[i];
					int nx = num.x + dx[i];
					
					int desty = pointy + dy[i]; //매 이동마다 한칸씩 내려옴
					int destx = num.x + dx[i]; //앞뒤는 관계 X

					//한번 움직일때마다 모든 벽들은 한칸씩 내려옴.
					//배열을 새로 만드는 건 시간초과가 발생할 것
					
					//이동은 ny,nx 기준, 이동이 가능한지 검사 기준은 pointy,pointx 기준
					if(ny < 0 || nx < 0 || ny >= 8 || nx >= 8 || visit[ny][nx]) continue; //ny 이동 기준 체크
					if(desty < 0 || destx < 0 || desty >= 8 || destx >= 8 || ar[desty][destx] == '#') continue; //pointy,pointx 이동 기준 체크
//					if(checky < 0 || checky >= 8 || checkx <0 || checkx >= 8) //이렇게 되면 이동 가능 범위에서 제외
					visit[ny][nx] = true;
					if(ny == 0 && nx == 7) {
						System.out.println(1);
						return;
					}
					queue.offer(new point(ny,nx,num.d+1));
//					System.out.println(ny + " " + nx);
				}
			}
			else if(pointy < 0) {
				for (int i = 0; i < 9; i++) {
					int ny = num.y + dy[i];
					int nx = num.x + dx[i];

					//한번 움직일때마다 모든 벽들은 한칸씩 내려옴.
					//배열을 새로 만드는 건 시간초과가 발생할 것
					
					//이동은 ny,nx 기준, 이동이 가능한지 검사 기준은 pointy,pointx 기준
					if(ny < 0 || nx < 0 || ny >= 8 || nx >= 8 || visit[ny][nx]) continue; //ny 이동 기준 체크
					visit[ny][nx] = true;
					if(ny == 0 && nx == 7) {
						System.out.println(1);
						return;
					}
					queue.offer(new point(ny,nx,num.d+1));
//					System.out.println(ny + " " + nx);
				}
			}
			
			
		}
		System.out.println(0);
	}
	
	static class point {
		int y;
		int x;
		int d;
		public point(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}
