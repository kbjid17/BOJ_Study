package prob_사다리조작_15684_220521_220522_220529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2트_실패 {

	static int[][] ar = new int[32][12];
	static int N,M,H,ans = 4;
	static int[][] tgt;
	static Stack<int[]> s = new Stack<int[]>();
	static ArrayList<int[]> input = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ar[a][b] = 1;
		}
		
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				if(ar[i][j] == 0) {
					input.add(new int[] {i,j});
				}
			}
		}
		
		for (int i = 0; i <= 3; i++) {
			tgt = new int[i][2];
			comb(0,0,i);
		}
		
		if(ans == 4) {
			ans = -1;
		}
		System.out.println(ans);

	}
	
	static void comb(int tgtIdx, int srcIdx, int size) {
		if(ans < 4) return; // 답이 이미 나왔기 때문에 더 볼 필요가 없음
		
		if(tgtIdx == size) {
			
			for (int i = 0; i < size; i++) {
				if(ar[tgt[i][0]][tgt[i][1]-1] == 1 ||ar[tgt[i][0]][tgt[i][1]+1] == 1) {
					for (int j = 0; j < size; j++) {
						ar[tgt[j][0]][tgt[j][1]] = 0;
					}
					return; // 선을 그을 수 없는 곳. 잘못된 선.
				}
				ar[tgt[i][0]][tgt[i][1]] = 1;
			}

			// 선을 다 그었으면 게임 시작
			for (int i = 1; i <= N; i++) {
				if(dfs(i) != i) {
					break;
				}
				if(i == N && dfs(i) == i) {
					ans = size;
					return;
				}
			}
			for (int i = 0; i < size; i++) {
				ar[tgt[i][0]][tgt[i][1]] = 0;
			}
			return;
		}
		
		for (int i = srcIdx; i < input.size(); i++) {
			if(ar[input.get(i)[0]][input.get(i)[1]+1] == 1 || ar[input.get(i)[0]][input.get(i)[1]-1] == 1) {
				for (int j = 0; j < size; j++) {
					ar[tgt[j][0]][tgt[j][1]] = 0;
				}
			}
			tgt[tgtIdx] = input.get(i);
			comb(tgtIdx+1,i+1,size);
		}
	}

	static int dfs(int num) {
		int[] start = {0,num};
		s.push(start);
//		System.out.println(num);
		while(!s.isEmpty()) {
			int[] a = s.pop();
//			System.out.println(a[0] + " " + a[1]);
			if(a[0] == H+1) {
				return a[1];
			}
			if(ar[a[0]][a[1]] == 1) s.push(new int[] {a[0]+1,a[1]+1});
			else if(ar[a[0]][a[1]-1] == 1) s.push(new int[] {a[0]+1,a[1]-1});
			else s.push(new int[] {a[0]+1,a[1]});
		}
		return num;
	}
}
