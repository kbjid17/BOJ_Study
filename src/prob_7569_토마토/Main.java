package prob_7569_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][][] ar;
	static int M,N,H,count1,count2; //목표 카운트,현재 카운트
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[] dd = {-1,0,1};
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //x ==> 가로
		N = Integer.parseInt(st.nextToken()); //y ==> 세로
		H = Integer.parseInt(st.nextToken()); //h ==> 판 수
		ar = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					ar[i][j][k] = Integer.parseInt(st.nextToken());
					if(ar[i][j][k] == 1) {
						queue.offer(new Node(i,j,k,0));
						count2++;
					}
					if(ar[i][j][k] == 0 || ar[i][j][k] == 1) {
						count1++;
					}
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
//				System.out.println("위치 : " + (node.d + " "+ ny + " " + nx));
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || ar[node.d][ny][nx] == -1 || ar[node.d][ny][nx] == 1) continue;
				count2++;
				ar[node.d][ny][nx] = 1;
				if(count2 == count1) {
					return node.day+1;
				}
				queue.offer(new Node(node.d,ny,nx,node.day+1));
			}
			for (int i = 0; i < 3; i++) {
				int nd = node.d + dd[i];
				if(nd < 0 || nd >= H || ar[nd][node.y][node.x] == -1 || ar[nd][node.y][node.x] == 1) continue;
				count2++;
				ar[nd][node.y][node.x] = 1;
				if(count2 == count1) {
					return node.day+1;
				}
				queue.offer(new Node(nd,node.y,node.x,node.day+1));
			}
		}
		return -1;
	}
	
static class Node {
	int d;
	int y;
	int x;
	int day;
	
	public Node(int d,int y,int x,int day) {
		this.d = d;
		this.y = y;
		this.x = x;
		this.day = day;
	}
}
}
