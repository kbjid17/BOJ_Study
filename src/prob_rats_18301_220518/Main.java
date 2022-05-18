package prob_rats_18301_220518;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())+1;
		int b = Integer.parseInt(st.nextToken())+1;
		int c = Integer.parseInt(st.nextToken())+1;
		System.out.println(((a*b)/c) -1);
	}

}
