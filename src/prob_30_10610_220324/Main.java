package prob_30_10610_220324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static Integer[] a;
	static String[] b;
	static int sum;
	static boolean able;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		a = new Integer[n.length()];
		b = n.split("");
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(b[i]);
			if(a[i] == 0) able = true;
			sum+= a[i];
		}
		if(sum % 3 == 0 && able) {
			Arrays.sort(a,Collections.reverseOrder());
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
		}
		else {
			System.out.println(-1);
		}
		
		//이걸 이용해서 역순으로 순열을 돌리고, 가장 먼저 30의 배수가 나오는 녀석이 끝
		
	}
	
	}

