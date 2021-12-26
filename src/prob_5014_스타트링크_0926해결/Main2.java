package prob_5014_스타트링크_0926해결;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(), S = sc.nextInt(), G = sc.nextInt(), U = sc.nextInt(), D = sc.nextInt();
        boolean[] bool = new boolean[F + 1];
        if ((U == 0 && S < G) || (D == 0 && S > G))
            System.out.println("use the stairs");
        else {
            int cnt = 0;
            while (true) {
                bool[S] = true;
                if (S == G) {
                    System.out.println(cnt);
                    break;
                } else if (S < G && S + U <= F) {
                    S += U;
                } else if (S > G && S - D >= 1) {
                    S -= D;
                } else if (S > G && S + U <= F) {
                    S += U;
                } else if (S < G && S - D >= 1) {
                    S -= D;
                } else {
                    System.out.println("use the stairs");
                    break;
                }
                if (bool[S]) {
                    System.out.println("use the stairs");
                    break;
                }
                cnt++;
            }
        }
	}
}
