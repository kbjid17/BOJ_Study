package prob_7576_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,N,ans,count; //ans : 토마토가 모두 익을 때까지의 최소 일자
	static int[][] ar;
	static int[][] day;
	static boolean[][] visit;
	static int[] sx;
	static int[] sy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		세로 : N 가로 : M
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ar = new int[N][M];
		day = new int[N][M];
		visit = new boolean[N][M];
		sy = new int[] {-1,1,0,0};
		sx = new int[] {0,0,-1,1};
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		
		System.out.println(count);
	}
	//1일마다 한번씩 진행한다 가정
	/*
	 0. 시작부터 모든 토마토가 익어있는 상태면 0 출력
	 -- while문을 사용해서 count 무한 증가 시전할때,배열 값의 합을 갱신. 시작부터 배열 합이 N*M이면 0 출력
	 1. 매일마다 상하좌우(범위 안벗어난다는 가정 하에)를 방문하고
	 -- while문을 사용해서 일마다 count 증가. bfs를 사용해서 방문
	 -- 이미 방문한 곳은 방문하지 않도록 처리 : visit 배열을 따로 만들어서 사용하면 될까?
	 2. 그곳이 0이면 1로 변경 / 1이면 그대로 / -1이면 그대로
	 3. 모든 곳을 방문한 후 배열의 총 합이 N*M이면 일수 출력. 아닐 시엔 -1 출력
	 */
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>(); //좌표 값을 넣을 수 있게 선언
		int[] tomato = new int[4];
//		반복문을 돌려서 1인 위치를 찾음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 1) { 
					q.offer(new int[] {i,j});
					visit[i][j] = true;
				}
			}
		}
		//count가 변하는 로직을 어떻게 처리해야할까?(전날 값의 +1값을 넣으면 되지 않을까?)
		while(!q.isEmpty()) {
			int[] a = q.poll(); //1이 위치한 값이 저장됨.
				for (int i = 0; i < 4; i++) {
					if(a[0] + sy[i] < 0 || a[1] + sx[i] < 0 || a[0] +sy[i] >= N || a[1] + sx[i] >= M) continue; //배열 밖을 벗어나지 않도록
					if(visit[a[0]+ sy[i]][a[1]+ sx[i]] == true) continue; // 한번 방문한 곳은 방문하지 않도록
					if(ar[a[0] + sy[i]] [a[1] + sx[i]] == -1) continue; // 토마토가 없으니까 방문 생략
					q.offer(new int[] {a[0]+sy[i],a[1]+sx[i]});
					ar[a[0] + sy[i]] [a[1] + sx[i]] = 1;
					
					visit[a[0]+sy[i]][a[1]+sx[i]] = true;
					day[a[0] + sy[i]] [a[1] + sx[i]] = day[a[0]][a[1]] +1;
				}
			
		} // 탐색 종료
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ar[i][j] == 0) {
					count = -1;
					return;
				}
				count = Math.max(count, day[i][j]);
			}
		}
	}
}