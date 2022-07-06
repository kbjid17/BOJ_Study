package prob_연료채우기_1826_220706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3 {
	static int N, ans, currentpos,currentfuel;
	static ArrayList<int[]> list = new ArrayList<>();
	static PriorityQueue<int[]> stationpq = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0] > o2[0])
			return 1;
			else if(o1[0] == o2[0]) {
				if(o1[1] > o2[1]) return -1;
				else return 1;
			}
			return -1;
		}
	});
	static PriorityQueue<Integer> fuelpq = new PriorityQueue<Integer>(Comparator.comparingInt(o -> -o));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())} );
			stationpq.offer(list.get(i));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int goal = Integer.parseInt(st.nextToken());
		currentfuel = Integer.parseInt(st.nextToken());
		
		while(currentfuel < goal) {
			if(stationpq.isEmpty() && fuelpq.isEmpty()) {
				ans = -1;
				break;
			}
			if(fuelpq.isEmpty() && stationpq.peek()[0] > currentfuel) {
				ans = -1;
				break;
			}
			
			while(!stationpq.isEmpty() && stationpq.peek()[0] <= currentfuel) {
				fuelpq.offer(stationpq.poll()[1]);
			}
			
			if(!fuelpq.isEmpty()) {
				currentfuel += fuelpq.poll();
				ans++;
			}
			
		}
		System.out.println(ans);
	}
}
