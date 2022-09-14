package prob_와글와글숭고한_17388_220913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int ans = a+b+c;
		
		if(ans >= 100) {
			System.out.println("OK");
		}
		else {
			int min = Math.min(a,Math.min(b, c));
			if(min == a) {
				System.out.println("Soongsil");
			}
			else if(min == b) {
				System.out.println("Korea");
			}
			else if(min == c) {
				System.out.println("Hanyang");
			}
		}
	}

}
