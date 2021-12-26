package prob_랜선자르기_1654;

import java.util.Scanner;

public class Main_소원 {
	//N개의 랜선 만들어야 함.
    //K개의 랜선 이미 있음. 길이가 다름. 
    //K개를 잘라서 랜선을 만들어야함.
    static int N, K, ans;
    static int[] al;
    static int max = Integer.MIN_VALUE;
    static int min = 1;
    //이미 가지고 있는 랜선 개수 K
    //필요한 랜선 개수  N
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        al = new int[K];
        for(int i = 0; i < K ;i++) {
            al[i] = sc.nextInt();
            
            if(al[i]>max) {
                max = al[i];
            }
        }
        

        while(min < max) {
            
            ans = (min + max) / 2; //중간값을 찾기
            
            int count = 0; 
            
            for(int i = 0; i < al.length; i++) {
                count += (al[i]/ans);//중간값으로 나눈 몫 개수 저장
            }
            
            if(count < N) {//필요한 개수보다 적을 때 => 더 작은 값으로 나누어야 한다
                max = ans;
            }else { //필요한 개수보다 클 때 범위를 좁혀야 하니까 + 1
                min = ans + 1;
            }
        }
        
        System.out.println(min - 1);
    }
}