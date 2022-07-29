package prob_공항_10775_220729;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long ans;
	static int G,P; // 게이트의 수 G , 비행기의 수 P
	static int[] parents;
	static int[] planes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		planes = new int[P];
		for (int i = 0; i < P; i++) {
			planes[i] = Integer.parseInt(br.readLine());
		}
		parents = new int[G+1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < planes.length; i++) {
			// 이 비행기가 가지는 번호의 parents값이 0이면 부수고 ans 출력
			// planes[i]를 게이트에 연결 -> planes[i]의 대푯값을 planes[i-1]과 결합
			if(find(planes[i]) == 0) break;
//			System.out.println(planes[i] + " " + parents[planes[i]]);
			union(parents[planes[i]]-1,parents[planes[i]]);
			ans++;
		}
		
		System.out.println(ans);

	}

	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}