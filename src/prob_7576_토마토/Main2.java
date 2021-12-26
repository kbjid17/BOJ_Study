package prob_7576_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

	static int[][] ar;
	static int M,N,count1,count2; //목표 카운트,현재 카운트
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ar = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
				if(ar[i][j] == 1) {
					queue.offer(new Node(i,j,0));
					count2++;
				}
				if(ar[i][j] == 0 || ar[i][j] == 1) {
					count1++;
				}
			}
		}
		if(count1 == count2) {
			System.out.println(0);
		}
		else {
			System.out.println(bfs());
		}
		
		
	}
	static int bfs() {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if(ny < 0 || ny >= M || nx < 0 || nx >= N || ar[ny][nx] == -1 || ar[ny][nx] == 1) continue;
				count2++;
				ar[ny][nx] = 1;
				if(count2 == count1) {
					return node.d+1;
				}
				queue.offer(new Node(ny,nx,node.d+1));
			}
		}
		return -1;
	}
	
static class Node {
	int y;
	int x;
	int d;
	public Node(int y,int x,int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}
}
