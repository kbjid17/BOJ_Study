package prob_야구_17281_220309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_흐름놓쳐서실패_1시간{
	static int N; // 이닝 수
	static int start = 1,sum;
	static int[] ans;
	static int[] ar,tgt,selected;
	public static void main(String[] args) throws Exception{
		// 매 이닝마다 해당 이닝에서 더 큰 점수가 나오는 경우, 그 끝지점 다음 주자를 다음 이닝의 타자로 변경
		// 순열로 순서 정하기 -> 이닝별로 돌리기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = new int[N+1];
		for (int t = 1; t <= N; t++) { // t번 이닝
			ar = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 9; i++) { // i번 선수가 t번 이닝에서 얻을 수 있는 점수
				ar[i] = Integer.parseInt(st.nextToken());
			}
			// 문제점 : 무조건 순서대로 진행 아니라 가장 높은 점수가 나올 수 있는 순서로 정렬 진행
			tgt = new int[10];
			selected = new int[10];
			perm(0,t);
			
		}
		for (int i = 1; i <= N; i++) {
			sum += ans[i];
		}
		System.out.println(sum);
	}
	static void cal(int[] ar,int first,int one,int two,int three,int inning) {
		int out = 0;
		int score = 0;
		for (int i = first; i <= 9; i++) {
			switch(ar[i]) {
			case 0: // 아웃
				out++;
				if(out == 3) {
					if(ans[inning] < score) {
						start = next(i);
						ans[inning] = Math.max(ans[inning], score);	
					}
					return;
				}
				break;
			case 1: // 안타
				one++;
				if(one >= 2) {
					one -=1;
					two++;
					if(two >= 2) {
						two--;
						three++;
						if(three >= 2) {
							three--;
							score++;
						}
					}
				}
				break;
			case 2: // 2루타
				if(one == 1) {
					one = 0;
					three++;
					if(three == 2) {
						three -= 1;
						score++;
					}
				}
				two++;
				if(two >= 2) {
					two = 1;
					score++;
				}
				break;
			case 3: // 3루타
				if(one == 1) {
					one = 0;
					score++;
				}
				if(two == 1) {
					two = 0;
					score++;
				}
				if(three == 1) {
					three = 0;
					score++;
				}
				three++;
				break;
			case 4: // 홈런
				if(one == 1) {
					one = 0;
					score++;
				}
				if(two == 1) {
					two = 0;
					score++;
				}
				if(three == 1) {
					three = 0;
					score++;
				}
				score++;
				break;
			}
			if(i == 9 && out < 3) {
				i =0;
			}
		}
	}
	
	static int next(int i) {
		if(i == 9) {
			return 1;
		}
		else {
			return i+1;
		}
	}
	
	static void perm(int tgtIdx,int t) {
		if(tgtIdx == 9) {
//			System.out.println(Arrays.toString(tgt));
			cal(tgt,start,0,0,0,t);
			return;
		}
		if(tgtIdx== 4) {
			tgt[tgtIdx] = ar[1];
			perm(tgtIdx+1,t);
		}
		else {
			for (int i = 2; i <= 9; i++) {
				if(selected[i] == 1) continue;
				selected[i] = 1;
				tgt[tgtIdx] = ar[i];
				perm(tgtIdx+1,t);
				selected[i] = 0;
			}
		}
	}
}
