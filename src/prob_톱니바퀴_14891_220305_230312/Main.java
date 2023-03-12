package prob_톱니바퀴_14891_220305_230312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] d;
	static int[][]ar, move;
	static boolean[][] rotated;
	static int K,ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		
		d = new ArrayList[5];
		rotated = new boolean[5][2];
		for (int i = 1; i <= 4; i++) {
			d[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= 4; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < str.length; j++) {
				d[i].add(Integer.parseInt(str[j])); // 1 : s , 0 : n
			}
		}
		// 12시 : 0번, 오른쪽 만나는 부분 : 2번 , 왼쪽 만나는 부분 : 6번
		K = Integer.parseInt(br.readLine());
		move = new int[K][2];
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
				// 한 톱니바퀴를 회전시킬 경우, 그 톱니바퀴의 양쪽에 있는 다른 톱니바퀴들이 회전할지의 여부를 결정하게 됨.
				// 극이 다르다면 반대방향으로 회전, 같다면 회전 x
			}
			rotateCheck(move[i][0],move[i][1]);
			
			for (int k = 1; k <= 4; k++) {
				if(k == move[k][0] && rotated[k][0]) {
					rotate(k,move[k][1]);
				}
				else if(k != move[k][0] && rotated[k][0]) {
					rotate(k,move[k][1]* (-1));
				}
			}
			
			Arrays.fill(rotated, false);
		}
		
		for (int i = 0; i < 4; i++) {
			ans += d[i+1].get(0) == 1 ? 0 : (int)Math.pow(2, i);
		}
		
		System.out.println(ans);
	}
	
	/*
	 현 톱니바퀴 상태에서
	 다른 톱니바퀴를 회전시킬 수 있는지 검사한 후,
	 한번에 회전
	 이후 회전한 양옆 톱니바퀴를 기준으로 다시 검사
	 */
	
	static void rotation(int n,int dir) {
		rotated[n][0] = true;
		
		if(dir == -1) { //반시계
			// 1. 지목된 톱니바퀴 외 어떤 톱니바퀴가 회전할 수 있는지 검사
			if(n == 1) {
				if(d[n].get(6) != d[n+1].get(2) && !rotated[n+1][1]) {
					rotated[n+1][0] = true;
				}
			}
			else if(n == 2 || n == 3) {
				if(d[n].get(6) != d[n+1].get(2) && !rotated[n+1][1]) {
					rotated[n+1][0] = true;
				}
				if(d[n].get(2) != d[n-1].get(6) && !rotated[n-1][1]) {
					rotated[n-1][0] = true;
				}
			}
			else if(n == 4) {
				if(d[n].get(2) != d[n-1].get(6) && !rotated[n-1][1]) {
					rotated[n-1][0] = true;
				}
			}
			// 2. 회전 진행
			for (int i = 1; i <= 4; i++) {
				if(i == n && rotated[i][0]) {
					rotate(i,dir);
				}
				else if(i != n && rotated[i][0]) {
					rotate(i,dir* (-1));
				}
			}
		}
		
		else if(dir == 1) { // 시계
			if(n == 1) {
				
			}
			else if(n == 2 || n == 3) {
				
			}
			else if(n == 4) {
				
			}
		}
		// 2. 회전 진행
		
		// 3. 회전된 다른 톱니바퀴들을 기준으로 rotate 다시 진행
		 
		
	}
	
	static void rotateCheck(int n,int dir) {
			// 1. 지목된 톱니바퀴 외 어떤 톱니바퀴가 회전할 수 있는지 검사
			rotated[n][0] = true;
			if(n == 1) {
				if(d[n].get(6) != d[n+1].get(2) && !rotated[n+1][1]) {
					rotated[n+1][0] = true;
					rotateCheck(n+1,dir*(-1));
				}
			}
			else if(n == 2 || n == 3) {
				if(d[n].get(6) != d[n+1].get(2) && !rotated[n+1][1]) {
					rotated[n+1][0] = true;
					rotateCheck(n+1,dir*(-1));
				}
				if(d[n].get(2) != d[n-1].get(6) && !rotated[n-1][1]) {
					rotated[n-1][0] = true;
					rotateCheck(n-1,dir*(-1));
				}
			}
			else if(n == 4) {
				if(d[n].get(2) != d[n-1].get(6) && !rotated[n-1][1]) {
					rotated[n-1][0] = true;
					rotateCheck(n-1,dir*(-1));
				}
			}
			// 2. 회전 진행
			
	}
	
	static void rotate(int n, int dir) {
		switch(dir) {
		case -1:
			
			break;
		case 1:
			
			break;
		}
	}

}
