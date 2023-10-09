package prob_1991_트리순회_231009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char [][] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		tree = new char[3][N]; // [0][~] : 부모노드, [1][~] : 왼쪽 자식 , [2][~] : 오른쪽 자식
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char p = st.nextToken().charAt(0);
			char lc = st.nextToken().charAt(0);
			char rc = st.nextToken().charAt(0);
			
			Arrays.fill(tree[0], '.');

			tree[1][p-'A'] = lc;
			tree[2][p-'A'] = rc;
			
			if(lc != '.'){
				tree[0][lc-'A'] = p;
			}
			
			if(rc != '.') {				
				tree[0][rc-'A'] = p;
			}
		}
		
		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
		
	}
	
	static void preorder(char cur) {
		System.out.print(cur);
		if(tree[1][cur-'A'] != '.') preorder(tree[1][cur-'A']);
		if(tree[2][cur-'A'] != '.') preorder(tree[2][cur-'A']);
	}
	static void inorder(char cur) {
		if(tree[1][cur-'A'] != '.') inorder(tree[1][cur-'A']);
		System.out.print(cur);
		if(tree[2][cur-'A'] != '.') inorder(tree[2][cur-'A']);
	}
	static void postorder(char cur) {
		if(tree[1][cur-'A'] != '.') postorder(tree[1][cur-'A']);
		if(tree[2][cur-'A'] != '.') postorder(tree[2][cur-'A']);
		System.out.print(cur);
		
	}

}
