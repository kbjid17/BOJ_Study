package prob_주사위굴리기_14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,x,y,K;
	static int[][] ar;
	static int[] dice = {0,0,0,0,0,0};
	static int[] dx = {0,0,0,-1,1}; // 세로
	static int[] dy = {0,1,-1,0,0}; // 가로
	static int[] cmd;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); // 배열의 크기
		x = Integer.parseInt(st.nextToken()); // 세로 좌표
		y = Integer.parseInt(st.nextToken()); // 가로 좌표
		K = Integer.parseInt(st.nextToken()); // 명령 횟수
		
		ar = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cmd = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
			setdice(cmd[i]);
		}
	}
	
	static void setdice(int d) {
		y += dy[d];
		x += dx[d];
		int temp = dice[2];
		if(x < 0 || x >= N || y < 0 || y >= M) {
			y -= dy[d];
			x -= dx[d];
			return;
		}
//		System.out.println("방향 : ");
//		System.out.println("방향 "+d);
		switch(d) {
		case 1: // 동쪽
			dice[2] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
			break;
		case 2: // 서쪽
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
		case 3: // 북쪽
			dice[2] = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
			break;
		case 4: // 남쪽
			dice[2] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[0];
			dice[0] = temp;
			break;
		}
		
		if(ar[x][y] == 0) {
			ar[x][y] = dice[5];
		}
		else {
			dice[5] = ar[x][y];
			ar[x][y] = 0;
		}
		System.out.println(dice[2]);
	}
}


/*
 dice 고찰
 윗 면 숫자 기준
 각 숫자당 4개의 케이스가 존재하며, 4개의 케이스당 4방향으로 굴릴 수 있음
 1~6이므로
 6*(4*4)(4방향으로 구를 수 있고, 4개의 방향이 있으므로 4*4) = 96
 dice에 필요한 매개변수 : 윗면의 수,위치(xy),바라보는 방향 (다른 숫자들의 위치가 바뀜(dy dx 의 0,1,2,3)(어차피 반대편에 있는 수는 한번 굴리기로 나오지 않기 때문.즉 반대편의 수는 고정
 ex. 
 윗면의 수가 1일 때 아랫면의 수는 6,(옆면의 수 : 2,3,4,5)
 윗면의 수가 2일 때 아랫면의 수는 5,(옆면의 수 : 1,3,4,6)
 윗면의 수가 3일 때 아랫면의 수는 4,(옆면의 수 : 1,2,5,6)
 윗면의 수가 4일 때 아랫면의 수는 3,(옆면의 수 : 1,2,5,6)
 윗면의 수가 5일 때 아랫면의 수는 2,(옆면의 수 : 1,3,4,6)
 윗면의 수가 6일 때 아랫면의 수는 1,(옆면의 수 : 2,3,4,5)
 (아랫면의 수 : 7-윗면의 수))
 값을 저장해야 하므로 ArrayList를 쓰는 게 좋을까? ==> 사용 목적은 6개의 값을 저장하고 변형시키는 것이므로 배열을 사용하는 게 더 효율적일듯
*/