package prob_마법사상어와파이어볼_20056;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K,sum;
	static int[][] ar; // 같은 자리에 여러 객체가 들어올 수 있기에 fireball 객체를 여러 개 담을 수 있는 arrayList로 선언
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static ArrayList<fire> list = new ArrayList<fire>(); // 배열을 일일이 돌 필요 없이 검사하기 위해 따로 불의 정보만을 담아놓는 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열 크기
		M = Integer.parseInt(st.nextToken()); // 초기 파이어볼 개수
		K = Integer.parseInt(st.nextToken()); // 명령 횟수
		
		ar = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new fire(r,c,m,s,d,false,false,1));
		}
		
		for (int i = 0; i < K; i++) { //명령 K번
//			System.out.println("testbefore");
//			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
//			}
			for (int j = 0; j < list.size(); j++) { //모든 객체 이동 개시
				int ny = list.get(j).r;
				int nx = list.get(j).c;
				
				for (int k = 0; k < list.get(j).s; k++) {
					
					ny = ny + dy[list.get(j).d];
					nx = nx + dx[list.get(j).d];
					if(ny <= 0 || ny > N) {
						if(dy[list.get(j).d] == -1) {
							ny = N;
						}else if(dy[list.get(j).d] == 1) {
							ny = 1;
						}
					}
					if(nx <= 0 || nx > N) {
						if(dx[list.get(j).d] == -1) {
							nx = N;
						}
						else if(dx[list.get(j).d] == 1) {
							nx = 1;
						}
					}
				}
				list.get(j).r = ny;
				list.get(j).c = nx;
//				System.out.println(list.get(j).r + " " + list.get(j).c);
			} // 이동 완료
//			System.out.println("moveafter");
//			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
//			}
			// 이동이 끝나면 불의 위치를 검사 => 위치가 같은 객체가 있으면 상호작용 일으키기
			for (int j = 0; j < list.size(); j++) {
				for (int k = j; k < list.size(); k++) {
					if((j != k) && (list.get(j).r == list.get(k).r) && (list.get(j).c == list.get(k).c)) { // 리스트를 돌다가 r,c 가 같은 녀석을 발견한다면
//						System.out.println(list.get(j).m);
						list.get(j).merge = true;
						list.get(j).num++;
						list.get(j).m += list.get(k).m; // 질량 흡수
						list.get(j).s += list.get(k).s; // 속력 흡수
						if((list.get(j).d) %2 != (list.get(k).d) %2 ) list.get(j).dir = true; // 합쳐지는 두 객체의 방향%2가 같다면 그대로 놔두고, 그렇지 않다면 true 처리!
						//1. 객체 합쳐짐
						//2. 속력 : (속력 합)/(합쳐진 파이어볼 개수)
						/*3. 방향
						방향이 모두 홀수 또는 짝수 ==> 방향은 0,2,4,6
						아니면 1,3,5,7
						*/
						list.remove(k); // 흡수된 객체는 삭제
						k--; //k자리에 있던 객체가 삭제되어 list가 당겨졌으므로, 다시 k자리를 검사할 수 있도록 -1 작업
					}
				} 
			}// 합체가 완료된 후,
			
//			System.out.println("fusion");
//			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
//			}
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).merge) { //이전에 합체되서 남아있는 객체라면
//					System.out.println(list.get(j).m);
					list.get(j).m /= 5;
//					System.out.println(list.get(j).m);
					if(list.get(j).m == 0) { //나눠서 0이 되면
						list.remove(j); // 소멸하고
						j-=1;
						continue; //바로 다음으로 이동
					}
					int nr = list.get(j).r;
					int nc = list.get(j).c;
					int nm = list.get(j).m;
					int ns = list.get(j).s/list.get(j).num;
					if(list.get(j).dir) {
						//같은 좌표에서 질량은 이전 객체 /5, 방향 및 속도 결정 후 합체 여부 + 방향 홀짝 여부 초기화, 객체 하나만 존재하니까 초기값(1)으로 설정
						list.add(new fire(nr,nc,nm,ns,1,false,false,1)); 
						list.add(new fire(nr,nc,nm,ns,3,false,false,1));
						list.add(new fire(nr,nc,nm,ns,5,false,false,1));
						list.add(new fire(nr,nc,nm,ns,7,false,false,1));
					} else {
						//같은 좌표에서 질량은 이전 객체 /5, 방향 및 속도 결정 후 합체 여부 + 방향 홀짝 여부 초기화, 객체 하나만 존재하니까 초기값(1)으로 설정
						list.add(new fire(nr,nc,nm,ns,0,false,false,1));
						list.add(new fire(nr,nc,nm,ns,2,false,false,1));
						list.add(new fire(nr,nc,nm,ns,4,false,false,1));
						list.add(new fire(nr,nc,nm,ns,6,false,false,1));
					}
					list.remove(j);
					j-=1;
				}
			}
//			System.out.println("testafter");
//			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
//			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).m;
		}
		System.out.println(sum);
	}

	private static class fire {
		int r; // 행
		int c; // 열
		int m; // 질량
		int s; // 방향
		int d; // 속력
		boolean merge; // 이동이 끝난 후 검사하는 과정에서 합쳐질 수 있는지 여부 검사(true면 상호작용 후 삭제될 예정)
		boolean dir; //방향이 짝수인지 홀수인지
		int num; // 몇개의 객체가 합쳐졌는지 누적
		public fire(int r, int c, int m, int s, int d,boolean merge,boolean dir,int num) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.merge = merge;
			this.dir = dir;
			this.num = num;
		}
		@Override
		public String toString() {
			return "fire [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + ", merge=" + merge + ", dir="
					+ dir + ", num=" + num + "]";
		}
	}
}