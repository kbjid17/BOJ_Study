package prob_최소비용구하기_1916_220507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 도시의 개수 N, 버스의 개수 M
	static int[][] edge;
	static int[] minCost;
	static boolean[] visit;
	static int INF = Integer.MAX_VALUE;
	static int start,end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edge = new int[N+1][N+1];
		minCost = new int[N+1];
		visit = new boolean[N+1];
		Arrays.fill(minCost, INF);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				edge[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken()); // a에서 b로 가는 비용 c ==> edge[a][b] = c;
			edge[a][b] = Math.min(edge[a][b], c); // 두 정점간 경로가 여러개가 주어질 수 있음
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); // 시작 정점
		end = Integer.parseInt(st.nextToken()); // 목적지 정점
		
		
		
		/*
		 1) 시작 정점과 연결되어 있는 정점의 가중치를 mincost에 넣음
		 2) 1) 과정에서 도착한 정점에서 이동할 수 있는 정점으로의 가중치를 계산하여 계산(이전에 계산된 가중치 값 + 새로운 정점으로 이동할 가중치 값)
		 3) 해당 과정을 더이상 출발할 정점이 없을 때까지 진행( 연결되어 있는 정점들은 이동 진행 )
		 */
		
		minCost[start] = 0;
		visit[start] = true;
		
		for (int i = 1; i <= N; i++) {
			if(!visit[i] && edge[start][i] != Integer.MAX_VALUE)
				minCost[i] = edge[start][i];
		}
		
		for (int t = 0; t < N-1; t++) {
			int min = Integer.MAX_VALUE;
			int min_Index = 0;
			for (int i = 1; i <= N; i++) {
				if(!visit[i]) {
					if(minCost[i] < min) {
						min = minCost[i];
						min_Index = i;
					}
				}
			}
			
			visit[min_Index] = true;
			for (int i = 1; i <= N; i++) {
				if(!visit[i] && edge[min_Index][i] != INF) {
					minCost[i] = Math.min(minCost[i], minCost[min_Index] + edge[min_Index][i]);
				}
			}
		}
		
		System.out.println(minCost[end]);
	}
}