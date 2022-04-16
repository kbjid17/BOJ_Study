package prob_뱀과사다리게임_16928_220416;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //사다리 수 N, 뱀의 수 M
	static Queue<node> q = new LinkedList<node>();
	static int ans;
	static int[] ladder;
	static boolean[] visit = new boolean[101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사다리 개수
		M = Integer.parseInt(st.nextToken()); // 뱀 마릿수
		
		ladder = new int[101]; //1~100번 칸이 필요. 0번 칸은 더미
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			ladder[from] = to;
		}
		
		bfs();
	}
	
	static void bfs() {
		q.offer(new node(1,0)); // 플레이어의 첫 시작 위치 :1
		visit[1] = true;
		while(!q.isEmpty()) {
			node s = q.poll();
//			System.out.println(s.pos);
			if(s.pos == 100) {
				System.out.println(s.cnt);
				return;
			}
			for (int i = 1; i <= 6; i++) {
				if(s.pos + i > 100 || visit[s.pos+i]) continue;
				if(ladder[s.pos+i] > 0) { // 뱀이나 사다리가 있는 경우
					if(visit[ladder[s.pos+i]]) continue;
					else {
						visit[ladder[s.pos+i]] = true;
						q.offer(new node(ladder[s.pos+i],s.cnt+1));
					}
				}
				else { // 그렇지 않은 경우
					visit[s.pos+i] = true;
					q.offer(new node(s.pos+i,s.cnt+1));
				}
			}
		}
	}

	static class node {
		int pos;
		int cnt;
		public node(int pos, int cnt) {
			super();
			this.pos = pos;
			this.cnt = cnt;
		}
	}
}
