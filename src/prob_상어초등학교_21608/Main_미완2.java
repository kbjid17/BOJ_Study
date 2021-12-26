//package prob_상어초등학교_21608;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class Main_미완2 {
//	static int N;
//	static int[][] student,map;
//	static ArrayList space;
//	static int[] dy= {-1,1,0,0};
//	static int[] dx = {0,0,-1,1};
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		int size = N*N;
//		student = new int[size][8]; //본인, 좋아하는 학생 4명, 1~3번 가중치 : 총 8개 원소
//		map = new int[N+1][N+1]; //N*N 격자(0 제외)
//		 
//		
//		for (int i = 0; i < N*N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 5; j++) {
//				student[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		
//	}
//}
