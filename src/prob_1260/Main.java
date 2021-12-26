package prob_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			CompleteBinaryTree tr = new CompleteBinaryTree(N);
			for(int i = 0; i < N; i++) {
				tr.add(i);
			}
			tr.bfs();
			tr.dfsByPreOrder();
	}
}

class CompleteBinaryTree {
	private int[] nodes;
	private final int SIZE;
	private int lastIndex; //마지막에 추가된 노드의 인덱스
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new int[size+1];
	}
	public void add(int c) {
		if(lastIndex==SIZE) { //트리가 꽉 차서 못넣음
			return;
		}
		nodes[++lastIndex] = c;
	}
	public void bfs() {
		//탐색을 기다리는 노드들이 저장됨.
		//배열로 관리 -> 탐색할 노드에 해당되는 인덱스를 저장
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); //루트노드의 인덱스를 저장
		
		int current = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(nodes[current] + " ");
			//왼쪽 자식이 있다면
			if(current*2 <= lastIndex) {
				queue.offer(current*2); //1의 왼쪽 자식은 2,  4의 왼쪽 자식은 8 이런 식으로 해서 current*2가 왼쪽 자식.
			}
			//오른쪽 자식이 있다면
			if(current*2+1 <= lastIndex) {
				queue.offer(current*2+1);//1의 오른쪽 자식은 3,  4의 왼쪽 자식은 9 이런 식으로 해서 current*2+1이 오른쪽 자식.
			}
			//여기서 두 조건은 배타적이지 않으며, 함께 일어날 수 있음(왼쪽 자식과 오른쪽 자식이 같이 있을 수 있음.)(왼쪽 자식이 없는데 오른쪽 자식이 있을 순 없음. -> 완전 이진트리 기준)
			
		}
		System.out.println();
	}
	public void bfs2() { 
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드의 인덱스 저장
		
		int current = 0, level = 0, size = 0;
		while(!queue.isEmpty()) {
			size = queue.size();
			
			System.out.println("level " + level + " : ");
			while(--size>= 0) { //기본적으로 트리의 사이즈가 1 이상 ==> bfs를 수행할 수 있다는 상황에서
				current = queue.poll();
				System.out.print(nodes[current] + " ");
				//왼쪽 자식이 있다면
				if(current*2 <= lastIndex) {
					queue.offer(current*2);
				}
				//오른쪽 자식이 있다면
				if(current*2+1 <= lastIndex ) {
					queue.offer(current*2+1);
				}
			}
			System.out.println();
			++level;
		}
	}
	
	public void dfsByPreOrder() {
		System.out.print("PreOrder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	private void dfsByPreOrder(int current) {
		//현재 노드 처리
		System.out.print(nodes[current] + " ");
		//왼쪽 자식 노드 처리
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		//으론쪽 자식 노드 처리
		if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);
	}
	
	public void dfsByInOrder() {
		System.out.println("InOrder : ");
		dfsByInOrder(1); //루트노드에 대한 중위순회
		System.out.println();
	}
	public void dfsByInOrder(int current) {
		//왼쪽자식 노드 처리
		if(current*2 <= lastIndex) dfsByInOrder(current*2);
		//현재 노드 처리
		System.out.print(nodes[current] + " ");
		//오른쪽 자식 노드 방문
		if(current*2+1 <= lastIndex) dfsByInOrder(current*2+1);
	}
	public void dfsByPostOrder() {
		System.out.print("PreOrder : ");
		dfsByPostOrder(1);
		System.out.println();
		
	}
	private void dfsByPostOrder(int current) {
		//왼쪽자식 노드 처리
		if(current*2<= lastIndex) dfsByPostOrder(current*2);
		//오른쪽 자식 노드 방문
		if(current*2+1<= lastIndex) dfsByPostOrder(current*2+1);
		//현재 노드 처리
		System.out.print(nodes[current] + " ");
	}
}