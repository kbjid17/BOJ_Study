package prob_드래곤커브_15685_220310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static long ans;
	static int[][] dragon,ar;
	static boolean[][] selected;
	static ArrayList<Integer>[] dir;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dir = new ArrayList[11];
		
		for (int i = 0; i <= 10; i++) {
			dir[i] = new ArrayList<Integer>();
		}
		dir[0].add(0);
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < dir[i-1].size(); j++) {
				dir[i].add(dir[i-1].get(j));
			}
			for (int j = dir[i].size()-1; j >= 0; j--) {
				dir[i].add((dir[i].get(j) + 1)%4);
			}
//			System.out.println(dir[i]);
		}
		ar = new int[101][101];
		selected = new boolean[101][101];
		dragon = new int[N][4]; // x,y : 드래곤 커브 시작점, d : 시작 방향, g : 세대
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				dragon[i][j] = Integer.parseInt(st.nextToken());
			}
			// 드래곤이 모두 정해지면 커브 진행
			curve(dragon[i]);
			
		}
		check();
		System.out.println(ans);
	}
	static void curve(int[] dragon) {
		selected[dragon[0]][dragon[1]] = true;
		int ny = dragon[1];
		int nx = dragon[0];
		for (int i = 0; i < dir[dragon[3]].size(); i++) {
			ny += dy[(dir[dragon[3]].get(i) + dragon[2])%4];
			nx += dx[(dir[dragon[3]].get(i) + dragon[2])%4]; // 해당 방향으로 이동 
			selected[nx][ny] = true;
		}
	}
	
	static void check() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(selected[i][j] && selected[i][j+1] && selected[i+1][j] && selected[i+1][j+1]) {
					ans++;
				}
			}
		}
	}
}
