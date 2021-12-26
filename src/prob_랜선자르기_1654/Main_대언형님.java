package prob_랜선자르기_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_대언형님 {
    static int K, N;
    static long ans;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        long end = max;
        long begin = 0;
        long mid = 0;
        while (begin <= end) {
            mid = (begin + end) / 2;
            
            if (test(mid)) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
    private static boolean test(long mid) {
        int sum = 0;
        for (int n : arr) {
            sum += (n / mid);
        }

        if (sum >= N) {
            if (ans < mid) ans = mid;
            return true;
        }
        return false;
    }
}