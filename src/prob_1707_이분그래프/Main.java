package prob_1707_이분그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T,V,E;
	static Queue<Integer> queue;
	static ArrayList<Integer>[] al;
	static int[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer (br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			al = new ArrayList[V+1];
			visit = new int[V+1];
			for (int i = 0; i <= V; i++) {
				al[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				al[start].add(end);
				al[end].add(start);
			}

			//그래프를 만든 후, 각 점별로 인접한 정점에 같은 색깔이 있으면 이분그래프가 아님!
			bfs();
		}	
	}
	//색을 어떻게 칠해야 할까?
	//리스트별로 색을 칠함(일단 다 칠한다는 마인드로 접근)
	//위에서 칠해진 색이 있다 하더라도 

	
	
	static void bfs() {
		queue = new LinkedList<Integer>();
		for (int j = 1; j <= V; j++) {
			if(visit[j] == 0) {
				queue.offer(j);
				visit[j] = 1;
			}
				while(!queue.isEmpty()) {
					int num = queue.poll(); //해당 리스트의 요소를 가져옴
					for (int i = 0; i < al[num].size(); i++) { //가져온 리스트의 구성요소 중
						if(visit[al[num].get(i)] == 0) {
							queue.add(al[num].get(i));
						}
							if(visit[num] ==visit[al[num].get(i)]) {
								System.out.println("NO");
								return;
							}
							if(visit[num] == 1 && visit[al[num].get(i)] == 0)
								visit[al[num].get(i)] = 2;
							else if(visit[num] == 2 && visit[al[num].get(i)] == 0)
								visit[al[num].get(i)] = 1;
					}
			}
		}
		System.out.println("YES");
	}
}
