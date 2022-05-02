package prob_IOIOI_5525_220411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3th_해결 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		int[] val = new int[str.length];
		
		for (int i = 1; i < str.length-1; i++) {
			if(str[i] == 'O' && str[i+1] == 'I') {
				val[i+1] = val[i-1]+1;
			}
			
			if(val[i+1] >= N && str[i-(2*N)+1] == 'I') {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
