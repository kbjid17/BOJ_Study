package prob_darius님한타안함_20499_220917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine(),"/");
		
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		if(D == 0 || K+A < D) {
			System.out.println("hasu");
		}
		else {
			System.out.println("gosu");
		}
	}

}
