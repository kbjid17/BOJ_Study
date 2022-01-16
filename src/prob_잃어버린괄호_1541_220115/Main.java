package prob_잃어버린괄호_1541_220115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long ans = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer addst = new StringTokenizer(st.nextToken(),"+");
			while(addst.hasMoreTokens()) {
				temp += Integer.parseInt(addst.nextToken());
			}
			if(ans == Long.MAX_VALUE) ans = temp;
			else ans -= temp;
		}
		System.out.println(ans);
//		String a = "007";
//		int b = Integer.parseInt(a);
//		
//		System.out.println(b);
		
		//007과 같은 숫자도 Integer.parseInt 안에 넣으면 평등하게 7로 변함. 새로운 지식!
	}

}
