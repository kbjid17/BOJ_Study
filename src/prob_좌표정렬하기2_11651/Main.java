package prob_좌표정렬하기2_11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Point> li = new ArrayList<Point>();
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			li.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
	Collections.sort(li);
		for (Point p : li) {
			System.out.println(p.x + " " + p.y);
		}
	}
	static class Point implements Comparable<Point>{
		int y,x;
		
		
		public Point(int x, int y) {
			super();
			this.y = y;
			this.x = x;
		}


		@Override
		public int compareTo(Point o) {
			if(this.y > o.y) {
				return 1;
			}
			else if(this.y == o.y) {
				if(this.x > o.x) {
					return 1;
				}
			}
			return -1;
		}
	}
}