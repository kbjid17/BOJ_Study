package prob_주유소_13305_220115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] ar1,ar2;
	static long price = Long.MAX_VALUE,dist;
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar1 = new long[100000]; // 도시 간 거리 배열
		ar2 = new long[100001]; // 기름 값 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			ar1[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ar2[i] = Long.parseLong(st.nextToken());
			if(i == 0) {
				price = ar2[i];
				continue;
			}
			dist += ar1[i-1];
			if(ar2[i] <= price) {
				//작은 곳을 찾았으면
				//거리 : 기름을 넣은 도시 ~ 현재 도시까지의 거리
				ans += price*dist;
				price = ar2[i];
				dist = 0;
			}
		}
		
			ans += price*dist;
		
		System.out.println(ans);
		// 첫 위치에서 기름을 넣을 때, 자기보다 기름값이 작은 도시의 위치를 기억.
		// 그곳까지 갈 수 있을 만큼의 기름만 구매해서 이동하는 값을 기록
		// 그곳으로 이동했다면 다시 해당 위치에서부터 이동했을 때 자기보다 기름값이 적은 도시의 위치를 기억 -> 그곳까지 갈 수 있을 만큼의 기름만 구매 -> 구매한 기름 값을 누적한 후 이동
		// 해당 과정을 반복하여 최종적으로 구해지는 값을 정하면 됨

	}

}
