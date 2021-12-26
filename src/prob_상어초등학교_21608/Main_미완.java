package prob_상어초등학교_21608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_미완 {
	static int N,max_1,cnt_1,max_2,cnt_2;
	static int[][] student,map,numb_1,numb_2;
	static ArrayList numb_3;
	static int[] dy= {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int size = N*N;
		student = new int[size][8]; //본인, 좋아하는 학생 4명, 1~3번 가중치 : 총 8개 원소
		map = new int[N+1][N+1]; //N*N 격자(0 제외)
		 
		
		//조건 1: 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함
		//조건 2: 조건 1을 만족하는 칸이 여러개이면 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리 정함
		//조건 3: 2를 만족하는 칸도 여러 개인 경우 행(y)의 번호가 가장 작은 칸으로, 그러한 칸도 여러개이면 열(x)의 번호가 가장 작은 칸으로 자리를 정함
		//1번 가산점(score_1) => 2번 가산점(score_2) => 3번 가산점(score_3)을 줘야 할듯
		
		//매 학생마다 격자의 빈칸 찾기 -> 빈칸별로 좋아하는 학생이 얼마나 인접했는지 확인 -> 
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
			check_1(i);
		}
		
		
	}
	static void check_1(int num) {
		max_1 = 0;
		cnt_1 = 0;
		numb_1 = new int[N+1][N+1]; // 조건 1 검사를 위한 격자
		int pos_y = 0;
		int pos_x = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] != 0) continue;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
					for (int k = 1; k <= 4; k++) {
						if(map[ny][nx] == student[num][k]) numb_1[i][j]++;
					}
				} //가중치 계산이 끝난 후
				if(numb_1[i][j] > max_1) {
					max_1 = numb_1[i][j];
					pos_y = i;
					pos_x = j;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] != 0) continue;
				if(max_1 == numb_1[i][j]) {
					cnt_1++;
					if(cnt_1 >= 2) {
						check_2(num);
						return;
					}
				}
			}
		}
		map[pos_y][pos_x] = num;
	}
	
	static void check_2(int num) {
		max_2 = 0;
		cnt_2 = 0;
		numb_2 = new int[N+1][N+1]; // 조건 2 검사를 위한 격자
		int pos_y = 0;
		int pos_x = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] != 0) continue;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
					if(map[ny][nx] == 0) numb_2[i][j]++;
				}
				if(max_2 < numb_2[i][j]) {
					max_2 = numb_2[i][j];
					pos_y = i;
					pos_x = j;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] != 0) continue;
				if(max_2 == numb_2[i][j]) {
					cnt_2++;
					if(cnt_2 >= 2) {
						check_3(num);
						return;
					}
				}
			}
		}
		map[pos_y][pos_x] = num;
	}
	
	static void check_3(int num) {
		numb_3 = new ArrayList<int[]>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] != 0) continue;
				numb_3.add(new int[] {i,j});
			}
		} //배열을 모두 찾고 나서
	}
}
