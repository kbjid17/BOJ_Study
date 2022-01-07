package prob_뱀_3190_220106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2_해결 {
	static int N,K,L;
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static boolean gameover;
	static int time,dir;
	static Deque<int[]> d = new LinkedList<int[]>();
	static move[] moves;
	static int[][] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		ar = new int[N+1][N+1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		moves = new move[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			moves[i] = new move(t,str);
		}
		d.offer(new int[] {1,1});
		
			for (int i = 0; i < L; i++) {
				
				
				while(!gameover && time < moves[i].t) {
					time++;
					int ny = d.peekFirst()[0] + dy[dir];
					int nx = d.peekFirst()[1] + dx[dir];
					//머리를 내밀어보고 그쪽으로 이동
					// 몸이랑 부딪히면 끝
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) {
						gameover = true;
						break;
					}
					for (int[] a : d) {
						if(a[0] == ny && a[1] == nx) {
							gameover = true;
							break;
						}
					}
					
					d.offerFirst(new int[] {ny,nx});
					// 사과가 없으면 꼬리를 한칸 없애고
					if(ar[ny][nx] == 0) {
						d.pollLast();
					}
					// 사과가 있으면 꼬리를 없애지 않음(사과는 사라짐)
					else if(ar[ny][nx] == 1) {
						ar[ny][nx] = 0;
					}
					
				}
				if(gameover) break;
				if(moves[i].str.equals("D")) {
					if(dir==3) dir = -1;
					dir+=1;
				}
				else if(moves[i].str.equals("L")) {
					if(dir== 0) dir = 4;
					dir-=1;
				}
				
			}
			while(!gameover && time >= moves[moves.length-1].t) {
				time++;
				int ny = d.peekFirst()[0] + dy[dir];
				int nx = d.peekFirst()[1] + dx[dir];
				//머리를 내밀어보고 그쪽으로 이동
				// 몸이랑 부딪히면 끝
				if(ny <= 0 || ny > N || nx <= 0 || nx > N) {
					gameover = true;
					break;
				}
				for (int[] a : d) {
					if(a[0] == ny && a[1] == nx) {
						gameover = true;
						break;
					}
				}
				if(gameover) break;
				d.offerFirst(new int[] {ny,nx});
				// 사과가 없으면 꼬리를 한칸 없애고
				if(ar[ny][nx] == 0) {
					d.pollLast();
				}
				// 사과가 있으면 꼬리를 없애지 않음(사과는 사라짐)
				else if(ar[ny][nx] == 1) {
					ar[ny][nx] = 0;
				}
				
			}
		
		System.out.println(time);
	}
	
	static class move {
		int t;
		String str;
		public move(int t, String str) {
			super();
			this.t = t;
			this.str = str;
		}
		
		
	}
}