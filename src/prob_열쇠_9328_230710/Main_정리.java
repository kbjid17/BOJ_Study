package prob_열쇠_9328_230710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정리 {
	static int T,h,w;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static char[][] ar;
	static int ans, key_earn = 0;
	static ArrayList<Character> keys = new ArrayList<Character>();
	static ArrayList<node> new_node = new ArrayList<node>();
	static boolean[][] visited;
	static Queue<node> q = new LinkedList<node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			ans = 0;
			keys.clear();
			new_node.clear();
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			ar = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			
			for (int i = 0; i < ar.length; i++) {
				if(i == 0 || i == ar.length-1) {
					for (int j = 0; j < ar[0].length; j++) {
						ar[i][j] = '.';
						visited[i][j] = true;
						q.offer(new node(i,j));
					}
				}
				else {
					ar[i] = ("."+br.readLine()+".").toCharArray();
					visited[i][0] = true;
					visited[i][ar[0].length-1] = true;
					q.offer(new node(i,0));
					q.offer(new node(i,ar[0].length-1));
				}
			}
			char[] s = br.readLine().toCharArray();
			for (int i = 0; i < s.length; i++) {
				keys.add(Character.toUpperCase(s[i]));
			}
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar[0].length; j++) {
					if(ar[i][j] >= 'A' && ar[i][j] <= 'Z') {
						if(keys.contains(ar[i][j])) ar[i][j] = '.';
					}
				}
			}
		
			do {
				search();
			}while(key_earn != 0);
			System.out.println(ans);
		}
	}
	
	static void search() {
		key_earn = 0;
		while(!q.isEmpty()) {
			node n = q.poll();
			visited[n.y][n.x] = true;
			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				if(ny < 0 || ny >= h+1 || nx < 0 || nx >= w+1 || visited[ny][nx] || ar[ny][nx] == '*') continue;
				if(ar[ny][nx] >= 'A' && ar[ny][nx] <= 'Z')  {
					new_node.add(new node(ny,nx));
					continue;
				}
				q.offer(new node(ny,nx));
				if(ar[ny][nx] >= 'a' && ar[ny][nx] <= 'z') {
					keys.add(Character.toUpperCase(ar[ny][nx]));
					ar[ny][nx] = '.';
					
				}
				if(ar[ny][nx] == '$') {
					ans++;
					ar[ny][nx] = '.';
				}
				visited[ny][nx] = true;
			}
		}
		for (node n : new_node) {
			if(keys.contains(ar[n.y][n.x])) {
				if(key_earn == 0) key_earn = 1;
				ar[n.y][n.x] = '.';
				q.offer(new node(n.y,n.x));
			}
		}
	}
	
	static class node {
		int y;
		int x;
		public node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}