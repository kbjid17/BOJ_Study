package prob_숨바꼭질3_13549_220602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_틀림_이유포함 {
	static int N,K; // 수빈이의 위치 N, 동생의 위치 K
	static int ans = Integer.MAX_VALUE;
	static boolean[] visit = new boolean[100001];
	static Queue<int[]> q = new LinkedList<int[]>(); //{위치, 초}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N => K
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		q.offer(new int[] {N,0});
		visit[N] = true;
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			if(n[0] == K) {
//				System.out.println(n[0] + " " + n[1]);
				ans = Math.min(ans, n[1]);
			}
			else {
//				System.out.println(n[0] + " " + n[1]);
				for (int t = 1; t <= 3; t++) {
					switch(t) {
					case 1:
						if(n[0]*2 > 100000 || visit[n[0]*2]) continue;
						q.offer(new int[] {n[0]*2,n[1]});
						if(n[0]*2 != K)	visit[n[0]*2] = true;
//						if(n[0]*2 == K) System.out.println(n[0]+" " + n[1] +" 를 2 곱함");
						break;
					case 2:
						if(n[0]+1 > 100000 || visit[n[0]+1]) continue;
						q.offer(new int[] {n[0]+1,n[1]+1});
						if(n[0]+1 != K)	visit[n[0]+1] = true;
//						if(n[0]+1 == K) System.out.println(n[0]+" " + n[1] +" 를 1 더함");
						break;
					case 3:
						if(n[0]-1 < 0 || visit[n[0]-1]) continue;
						q.offer(new int[] {n[0]-1,n[1]+1});
						if(n[0]-1 != K)	visit[n[0]-1] = true;
//						if(n[0]-1 == K) System.out.println(n[0]+" " + n[1] +" 를 1 뺌");
						break;
					}
				}
			}
			
		}
	}
}


/*

	45%에서 오답 발생
정답 코드와 다른점 : t 2와 3의 경우가 반대임
정답 
	t==2 => n-1 // t==3 => n+1
오답(해당 코드)
	t==2 => n+1 // t==3 => n-1
더하고 빼는 경우가 먼저 들어갈 경우, 기존에 곱하고 넣는 과정에서 충돌이 발생할 수 있음
*/