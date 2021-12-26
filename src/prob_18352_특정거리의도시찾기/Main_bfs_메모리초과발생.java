package prob_18352_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bfs_메모리초과발생 {
	static int N,M,K,X,A,B; // 도시 개수, 도로 개수 , 거리 정보, 출발 도시 번호, A번 도시에서 B번 도시로 이동하는 단방향 도로 존재.
	static boolean[][] ar;
	static boolean[] visit;
	static ArrayList<Integer> cityList = new ArrayList<Integer>(); // 답이 될 도시 리스트를 저장할 수열
	static Queue<int[]> queue = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ar = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			ar[A][B] = true;
			//인접 행렬로 시도.
			//X에서 출발할 수 있는 거리 중에서 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순 출력
			
		}
		bfs(X,0);
		Collections.sort(cityList);
		if(cityList.size() == 0)
			System.out.println(-1);
		else {
			for (Integer a : cityList) {
				System.out.println(a);
			}
		}
	}
	static void bfs(int start,int d) {
		visit[start] = true; //시작점 방문 처리
		queue.offer(new int[] {start,d}); //시작점 삽입
		while(!queue.isEmpty()) {
			int[] num = queue.poll();
			if(num[1] == K)
				cityList.add(num[0]);
			else 
			{
			for (int i = 0; i < ar[num[0]].length; i++) { //해당 정점과 연결된 녀석을 탐색
				if(ar[num[0]][i] && !visit[i]) { //num[0]번 정점과 i번 정점이 연결되어 있으며, i번 정점이 방문한 적 없는 경우
						visit[i] = true;
						queue.offer(new int[] {i,num[1]+1});
					}
				}
			}
		}
	}
}