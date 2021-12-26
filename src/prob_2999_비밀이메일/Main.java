package prob_2999_비밀이메일;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] ar;
	static int maxN = Integer.MIN_VALUE;
	static int minj = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ar = br.readLine().toCharArray();
		for (int i = 0; i < ar.length; i++) {
			for (int j = i; j < ar.length; j++) {
				if((i+1) * (j+1) == ar.length) {
					if(maxN < i+1) {
						maxN = Math.max(maxN, i+1);
						minj = j+1;
					}
				}
			}
		}
		int cnt = 0;
		int[][] ar2 = new int[maxN][minj];
		for (int i = 0; i < minj; i++) {
			for (int j = 0; j < maxN; j++) {
				ar2[j][i] = ar[cnt];
				cnt++;
			}
		}
		for (int i = 0; i < maxN; i++) {
			for (int j = 0; j < minj; j++) {
				System.out.print((char)ar2[i][j]);
			}
		}
	}
}