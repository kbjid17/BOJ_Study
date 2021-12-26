package prob_치킨배달_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int N,M;
	static int sum,ans = Integer.MAX_VALUE;
	static int[] dy = {-1,1,0,0}; 
	static int[] dx = {0,0,-1,1};
	static int[][] ar;
	static ArrayList<int[]> home = new ArrayList<int[]>();
	static ArrayList<int[]> chicken = new ArrayList<int[]>();
	static int[][] combarray;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N+1][N+1];
		combarray = new int[M][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
				else if(ar[i][j] == 1) {
					home.add(new int[] {i,j});
				}
			}
		}
		comb(0,0);
		System.out.println(ans);
	}
	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx == M) {
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < tgtIdx; j++) {
					min = Math.min(min, Math.abs(home.get(i)[0]-combarray[j][0]) + Math.abs(home.get(i)[1]-combarray[j][1]));
				}
				sum+= min;
			}
			ans = Math.min(ans, sum);
			sum = 0;
			return;
		}
		for (int i = srcIdx; i < chicken.size(); i++) {
			combarray[tgtIdx][0] = chicken.get(i)[0];
			combarray[tgtIdx][1] = chicken.get(i)[1];
			comb(i+1,tgtIdx+1);
		}
	}
}
