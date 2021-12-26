package prob_골드바흐의추측_6588;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,max,da,db;
	static boolean[] ar;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ar = new boolean[1000001];
		ar[0] = true;
		ar[1] = true;
		for (int i = 2; i*i <= 1000000; i++) {
			if(!ar[i])
				for (int j = i*i; j <= 1000000; j+=i) {
					ar[j] = true;
				}
		}
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			max = Integer.MIN_VALUE;
			int a = 0;
			int b = 0;
			for (a = 2; a <= N/2; a++) {
				if(!ar[a])
					b = N-a;
				if(!ar[b]) {
					da = a;
					db = b;
					break;
				}
			}
			if(da == 0 && db == 0) {
				System.out.println("Goldbach's conjecture is wrong.");
			} else {
				System.out.println(N + " = "+ da +  " + " + db);
			}
		}
		
	}
}
