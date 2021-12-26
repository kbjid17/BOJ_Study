package prob_3053_택시기하학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int R;
	static double L1,L2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		R = Integer.parseInt(br.readLine());
		
		L1 = R*R*Math.PI;
		L2 = R*R*2;
		System.out.printf("%.6f \n",L1);
		System.out.printf("%.6f \n",L2);
	}

}
