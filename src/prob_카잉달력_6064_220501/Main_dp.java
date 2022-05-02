package prob_카잉달력_6064_220501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dp {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			// <M:N>
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// <x:y>
			
			int n1 = 1;
			int n2 = 1;
			// 1. n1값을 x에 맞춘다.
			n1 = x;
			n2 = x;
			
			while(n2 > N) {
				n2 -= N;
			}
			
			int cnt = x;
			
//			System.out.println(n1 + " " + n2 + " " + cnt);
			// 2. 이후 n1 n2에 x만큼 더할 떄, n1은 변하지 않고 n2만 변하므로 x값을 더해주면서 값을 맞춰가면 됨.(최대 : x와 y의 최소공배수)
			while(true) {
				if(cnt > (N*M) / gcd(N,M)) {
//					System.out.println("최대공약수 : "+(N*M)/gcd(N,M));
					System.out.println(-1);
					break;
				}
				else {
					if(n2 == y) {
						System.out.println(cnt);
						break;
					}
				}
				n2 = (n2+M);
				while (n2 > N) {
					n2 -= N;
				}
				cnt += M;
//				System.out.println(n2 + " " + cnt);
			}
			
		}
		
	}
// 두 자연수의 곱 = 최대공약수 × 최소공배수 · A × B = L × G = G2 × a × b.
	static int gcd(int a,int b) {
		while(b > 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	
}




/*



 */
