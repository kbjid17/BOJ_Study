package prob_터렛_1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,x1,x2,r1,r2,y1,y2,ans; //d1 : 목적지의 x좌표, d2 : 목적지의 y좌표
	//인터넷 힌트 1. 원을 그려라
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()); //
			y1 = Integer.parseInt(st.nextToken()); //
			r1 = Integer.parseInt(st.nextToken()); //
			
			x2 = Integer.parseInt(st.nextToken()); //
			y2 = Integer.parseInt(st.nextToken()); //a와 목적지 사이의 거리 ==> 반지름1
			r2 = Integer.parseInt(st.nextToken()); //b와 목적지 사이의 거리 ==> 반지름2
			
			int dist = (int) (Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				ans = -1;
			}
			else if(dist > Math.pow(r1+r2, 2)) {
				ans = 0;
			}
			else if(dist < Math.pow(r2-r1, 2)) {
				ans = 0;
			}
			else if(dist == Math.pow(r2-r1, 2)) {
				ans = 1;
			}
			else if(dist == Math.pow(r1+r2, 2)) {
				ans = 1;
			}
			else {
				ans = 2;
			}
			System.out.println(ans);
//			r1*r1 = (d1-x1)*(d1-x1) + (d2-y1)*(d2-y1);
//			r1*r1 = ((d1*d1)-2*d1*x1+(x1*x1))+((d2*d2)-2*d2*y1+(y1*y1));
//			r2*r2 = (d1-x2)*(d1-x2) + (d2-y2)*(d2-y2);
			
			//dis1-dis2 = 2*(x1-x2)r1+((x1*x1)-(x2*x2))+2*(y1-y2)r2+(y1*y1)-(y2*y2);
			
		}
	}

}
