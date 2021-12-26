package Prob_1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int S,K;
	static int previous; //이전 노드 위치값
	static int count,cnt;
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//현재 위치에 맞춰 S-1,S+1,S*2가 나오게 해야함.
			bfs(S);
	}
	
	//linkedList를 이용해서 이전에 방문했던 곳으로 들어가는 선택지를 컷해야함.
	//ex. 3 -> 6으로 이동했다 가정. 6에서 3으로 돌아가는 선택지가 있으면 안됨.
	//남은 거 : 레벨 처리
	// 100000 이상을 0으로 인식하는 상황이 일어남.
	static void bfs(int S) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {S,count});
		while(!q.isEmpty()) {
			int[] a = q.poll();
			visit[a[0]] = true;
			count = a[1] + 1;
			if(a[0] == K) {
				System.out.println(a[1]);
				return;
			}
				for (int b : new int[] {a[0]-1,a[0]+1,a[0]*2}) {
					if(b > 100000 || b < 0 || visit[b]) continue;
					q.offer(new int[] {b,count});
					visit[b] = true;
				}
		}
	}
}