package prob_타임카드_5575_220818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int starth = Integer.parseInt(st.nextToken());
			int startm = Integer.parseInt(st.nextToken());
			int starts = Integer.parseInt(st.nextToken());
			int endh = Integer.parseInt(st.nextToken());
			int endm = Integer.parseInt(st.nextToken());
			int ends = Integer.parseInt(st.nextToken());
			
			int[] time = new int[3];
			time[0] = endh - starth;
			time[1] = endm - startm;
			time[2] = ends - starts;
			
			if(time[2] < 0) {
				time[2] += 60;
				time[1] -=1;
			}
			if(time[1] < 0) {
				time[1] += 60;
				time[0] -=1;
			}
			System.out.println(time[0] + " " + time[1] + " " + time[2]);
		}

	}

}
