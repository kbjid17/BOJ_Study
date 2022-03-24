package prob_A_B_16953_220321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bfs {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<long[]> q = new LinkedList<long[]>();
		
		q.offer(new long[] {N,1});
		while(!q.isEmpty()) {
			long[] n = q.poll();
			if(n[0] > M) continue;
			if(n[0] == M) {
				System.out.println(n[1]);
				return;
			}
			q.offer(new long[] {n[0]*2,n[1]+1});
			q.offer(new long[] {n[0]*10 + 1,n[1]+1});
		}
		System.out.println(-1);
	}

}
