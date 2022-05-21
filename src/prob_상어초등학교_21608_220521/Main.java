package prob_상어초등학교_21608_220521;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ar;
	static long ans = 0;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<student> students = new ArrayList<student>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N+1][N+1];
		
		for (int i = 1; i <= N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			students.add(new student(num,new ArrayList<Integer>()));
			for (int j = 0; j < 4; j++) {				
				students.get(students.size()-1).likes.add(Integer.parseInt(st.nextToken()));
			}
		}
		// 학생 삽입 완료. 이제 위치를 정하자.
		
		// 첫 문자는 어차피 [1][1]에 오게 됨(배열은 3*3 이상의 크기를 가지며, 처음엔 아무것도 들어있지 않음)
		ar[2][2] = students.get(0).num;
		
		
		// 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
		// 3. 2를 만족하는 칸도 여러개일 경우, 행(y)의 번호가 가장 작은 칸으로, 그러한 칸도 여러개면 열(x)의 번호가 가장 작은 칸으로
		
		for (int i = 1; i < students.size(); i++) {
			test1(students.get(i));
		}
		
		Collections.sort(students,new Comparator<student>() {

			@Override
			public int compare(student o1, student o2) {
				if(o1.num < o2.num)
				return -1;
				else return 1;
			}
		});
		

		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
					if(students.get(ar[i][j]-1).likes.contains(ar[ny][nx])) cnt++;
				}
				switch(cnt) {
					case 0:
						break;
					case 1:
						ans++;
						break;
					case 2:
						ans += 10;
						break;
					case 3:
						ans += 100;
						break;
					case 4:
						ans += 1000;
						break;
				}
			}
		}
		System.out.println(ans);
	}
	
	static void test1(student s) {
//		System.out.println(s.num);
		// 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함.
		int max = 0;
		ArrayList<point> p = new ArrayList<point>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(ar[i][j] != 0) continue;
				p.add(new point(i,j,0,0));
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
					if(!s.likes.contains(ar[ny][nx]) && ar[ny][nx] != 0) continue;
//					System.out.println(i + " " + j + " " + ar[ny][nx]);
					if(ar[ny][nx] == 0) p.get(p.size()-1).zeropoint++;
					else p.get(p.size()-1).point++;
				}
				max = Math.max(max, p.get(p.size()-1).point);
			}
		}
		Collections.sort(p,new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				if(o1.point > o2.point)
				return 1;
				else if(o1.point < o2.point) return -1;
				else {
					if(o1.zeropoint > o2.zeropoint) {
						return 1;
					}
					else if(o1.zeropoint < o2.zeropoint) {
						return -1;
					}
					else {
						if(o1.y < o2.y) {
							return 1;
						}
						else if(o1.y > o2.y) {
							return -1;
						}
						else {
							if(o1.x < o2.x) {
								return 1;
								
							}
							else return -1;
						}
					}
				}
			}
		});
		int cnt = 0;
		
//		for (int i = 0; i < p.size(); i++) {
//			System.out.println(p.get(i).toString());
//		}
		
		ar[p.get(p.size()-1).y][p.get(p.size()-1).x] = s.num;
	}
	
	static class student {
		int num;
		ArrayList<Integer> likes;
		public student(int num, ArrayList<Integer> likes) {
			super();
			this.num = num;
			this.likes = likes;
		}
	}
	
	static class point {
		int y;
		int x;
		int point;
		int zeropoint;
		public point(int y, int x, int point, int zeropoint) {
			super();
			this.y = y;
			this.x = x;
			this.point = point;
			this.zeropoint = zeropoint;
		}
		
		@Override
		public String toString() {
			return "point [y=" + y + ", x=" + x + ", point=" + point + ", zeropoint=" + zeropoint + "]";
		}
		
		
		
	}
}
