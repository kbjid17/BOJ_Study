package prob_FourSquare_17626_220430;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int ans = 5;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		/*
		 n은 4개 이하의 (제곱수)^2로 그 값을 구할 수 있다.
		 */
		
		for (int i = (int) Math.floor(Math.sqrt(n)); i > 0; i--) {
//			System.out.println(i+" "+i*i);
			if(Math.pow(i, 2) == n) { // 첫 번째 숫자의 제곱으로 n을 구할 수 있다면
				ans = Math.min(ans, 1);
			}
			else { // 두번째 숫자가 필요하다면
				int n1 = n- (int)Math.pow(i, 2); // 첫 숫자의 제곱 값을 뺸 후 구해야 하는 값
//				System.out.println(n1);
				for (int j = (int)Math.floor(Math.sqrt(n1)); j > 0; j--) {
				
					if(Math.pow(j, 2) == n1) {
						ans = Math.min(ans, 2);
					}
					else {
						int n2 = n1-(int)Math.pow(j, 2);
//						System.out.println("두번째 값: "+n2);
						for (int k = (int)Math.floor(Math.sqrt(n2)); k > 0; k--) {
							
							if(Math.pow(k, 2) == n2) {
//								System.out.println("이거 -----------------------------------------------------------"+i + " " + j + " " + k);
								ans = Math.min(ans, 3);
							}
							else {
								int n3 = n2 - (int)Math.pow(k, 2);
//								System.out.println("세 번째 값  : "+n3);
								for (int l = (int)Math.floor(Math.sqrt(n3)); l > 0; l--) {
									if(Math.pow(l, 2) == n3) {
										ans = Math.min(ans, 4);
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
