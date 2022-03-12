package prob_여행가자_1976_220312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] ar;
	static boolean unable;
	static int[] travel;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		ar = new int[N+1][N+1];
		travel = new int[M+1];
		parents = new int[N+1];
		make();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] ==1) {
					union(i,j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= M; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
			if(i >= 2) {
				if(find(travel[i-1]) != find(travel[i])) {
					unable = true;
					break;
				}
			}
		}
		if(unable) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}
		
	}
	static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
