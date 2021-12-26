//package prob_18352_특정거리의도시찾기;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main_dijkstra_이따가 {
//	static int N,M,K,X,A,B; // 도시 개수, 도로 개수 , 거리 정보, 출발 도시 번호, A번 도시에서 B번 도시로 이동하는 단방향 도로 존재.
//	static ArrayList<Integer>[] list;
//	static boolean[] visit;
//	static int[] cost;
//	static ArrayList<Integer> cityList = new ArrayList<Integer>(); // 답이 될 도시 리스트를 저장할 수열
//	static PriorityQueue<int[]> pqueue = new PriorityQueue<int[]>();
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//		X = Integer.parseInt(st.nextToken());
//		list = new ArrayList[N+1];
//		visit = new boolean[N+1];
//		cost = new int[N+1];
//		Arrays.fill(cost, Integer.MAX_VALUE);
//		for (int i = 0; i <= N; i++) {
//			list[i] = new ArrayList<Integer>();
//		}
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			A = Integer.parseInt(st.nextToken());
//			B = Integer.parseInt(st.nextToken());
//			
//			list[A].add(B);
//			//인접 리스트로 시도.
//			//X에서 출발할 수 있는 거리 중에서 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순 출력
//			
//		}
//		dijkstra(X,0);
//		for (int i = 1; i < cost.length; i++) {
//			if(cost[i] == K) 
//				cityList.add(i);
//		}
//		Collections.sort(cityList);
//		if(cityList.size() == 0)
//			System.out.println(-1);
//		else {
//			for (Integer a : cityList) {
//				System.out.println(a);
//			}
//		}
//	}
//	static void dijkstra(int start,int d) {
//		visit[start] = true; //시작점 방문 처리
//		pqueue.offer(new int[] {start,d}); //시작점 삽입
//		
//		while(!pqueue.isEmpty()) {
//			int[] num = pqueue.poll();
//			if(cost[num[0]] <  num[1])
//				continue;
//			for (int i = 0; i < list[num[0]].size(); i++) { //인접 리스트[시작점]을 탐색
//				int dist = cost[num[0]]+1;
//				if(dist < ) { //해당 인접 리스트 내 요소 중 아직 방문하지 않은 녀석들 중
//						visit[list[num[0]].get(i)] = true;
//						pqueue.offer(new int[] {list[num[0]].get(i),dist});
//					}
//				}
//			
//		}
//	}
//}