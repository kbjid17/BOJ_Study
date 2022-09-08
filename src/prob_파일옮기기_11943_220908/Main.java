package prob_파일옮기기_11943_220908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int a_1 = Integer.parseInt(st.nextToken());
		int o_1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a_2 = Integer.parseInt(st.nextToken());
		int o_2 = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		ans += (a_1 + o_2) < (a_2+o_1) ? (a_1+o_2) : (a_2+o_1); 
		System.out.println(ans);

	}

}
