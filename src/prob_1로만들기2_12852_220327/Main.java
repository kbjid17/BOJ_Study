package prob_1로만들기2_12852_220327;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static long ans;
	static Node[] ar;
	static Queue<Node> q = new LinkedList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ar = new Node[n+1];
		for (int i = 0; i <= n; i++) {
			ar[i] = new Node(0,"");
		}
		
		ar[1].n = 1;
		ar[1].str = Integer.toString(ar[1].n);
		for (int i = 2; i <= n; i++) {
			ar[i].n = ar[i-1].n+1;
			ar[i].str = Integer.toString(i) + " " + ar[i-1].str;
			if(i % 2 == 0)
				if(ar[i].n > ar[i/2].n) {
					ar[i].n = ar[i/2].n+1;
					ar[i].str = Integer.toString(i) + " " + ar[i/2].str;
				}
			if(i % 3 == 0) {
				if(ar[i].n > ar[i/3].n) {
					ar[i].n = ar[i/3].n+1;
					ar[i].str = Integer.toString(i) + " " + ar[i/3].str;
				}
			}
		}
		System.out.println(ar[n].n-1);
		System.out.println(ar[n].str);
	}

	static class Node {
		int n;
		String str;
		public Node(int n, String str) {
			super();
			this.n = n;
			this.str = str;
		}
		
	}
}
