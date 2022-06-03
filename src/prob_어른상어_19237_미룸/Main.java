package prob_어른상어_19237_미룸;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static int N,M,K; // [N][N],상어 마릿수, 냄새 유통기한
	static int[][] ar;
	static Shark[] sharkInfo;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ar = new int[N][N];
		sharkInfo = new Shark[M+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j]  != 0) {
					sharkInfo[ar[i][j]] = new Shark(ar[i][j],K,i,j,0,new int[5][5]);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sharkInfo[i].dir = Integer.parseInt(st.nextToken());
		}
		
		for (int t = 1; t <= M; t++) { // M 마리의 상어의 방향 우선순위를 정함 
			for (int i = 1; i <= 4; i++) { //네 방향의 우선순위를 정함
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 4; j++) {
					sharkInfo[t].dir_rank[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
		// 입력 완료
//		for (int i = 1; i <= M; i++) {
//			System.out.println(sharkInfo[i].toString());
//		}
		
		
		
	}
	static class Shark {
		int type = 0; // 각 상어가 이동 방향을 결정할 때는, 먼저 인접한 칸 중 아무 냄새가 없는 칸의 방향으로 잡는다. 그런 칸이 없으면 자신의 냄새가 있는 칸의 방향으로 잡는다.
		int size = 0; // size == K : 상어, size < K : 냄새
		int y;
		int x;
		int dir;
		int[][] dir_rank;
		public Shark(int type, int size, int y, int x, int dir, int[][] dir_rank) {
			super();
			this.type = type;
			this.size = size;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.dir_rank = dir_rank;
		}
		@Override
		public String toString() {
			return "Shark [type=" + type + ", size=" + size + ", y=" + y + ", x=" + x + ", dir=" + dir + ", dir_rank="
					+ Arrays.toString(dir_rank) + "]";
		}
		
		
		
		
		
		
		
	}
}
