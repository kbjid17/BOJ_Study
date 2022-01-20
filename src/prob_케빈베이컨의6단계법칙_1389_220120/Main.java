package prob_케빈베이컨의6단계법칙_1389_220120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int ans;
	static int[] people;
	static Queue<friend> queue = new LinkedList<friend>();
	static int min = Integer.MAX_VALUE;
	static ArrayList<friend>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new int[N+1]; // 케빈 베이컨 값을 저장할 배열
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<friend>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(new friend(b,1));
			list[b].add(new friend(a,1));
		}
		
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		System.out.println(ans);
	}
	//i 번친구
	/*
	 1명의 친구를 찾을 경우
	 모든 사람은 친구 관계로 연결 되어 있다(무한 반복이 일어날 일이 없다는 뜻)
	 */
	static void bfs(int i) { // i번 친구가 나머지 친구들과 이어지는 길의 합을 구해야 함.
		int bacon = 0;
//		System.out.println(i + "번 친구의 베이컨 구하기");
		for (int j = 1; j <= N; j++) { //j번 친구를 찾으려 함
			if(j == i) continue; // 본인을 찾을 필요는 없음
			queue.offer(new friend(i,1)); //본인의 값을 가져옴
			while(!queue.isEmpty()) {
				friend a = queue.poll();
//				System.out.print(a.n + " ");
				for (friend b : list[a.n]) { // list[a.n]에 있는 연결 리스트들을 모두 순회
//					System.out.println(b.n + "의 numb : " + b.numb);
					if(b.n == j) { // 확인중인 리스트가 찾던 친구면 이 친구를 찾는 데 까지 걸린 값을 더함. 이렇게 모든 친구를 찾게 되어 생긴 총합이 케빈 베이컨 값
						bacon += a.numb;
//						System.out.println(j+"번 친구의 bacon : " + bacon);
						queue.clear();
						break;
					}
					queue.offer(new friend(b.n,a.numb+1));
				}
			}
		}
//		System.out.println(bacon);
		if(min > bacon) {
			min = bacon;
			ans = i;
		}
	}
	
	static class friend {
		int n; // 친구 넘버
		int numb; // 베이컨 값
		public friend(int n, int numb) {
			super();
			this.n = n;
			this.numb = numb;
		}
		
	}
}
