package prob_5014_스타트링크_0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F,S,G,U,D;
	static int count;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> fl = new LinkedList<Integer>();
//	F : 건물 최대 높이
//	S : 강호의 현재 위치한 층
//	G : 회사가 위치한 층
//	U : U버튼을 눌렀을 시 올라가는 층수( U가 4일 때, U버튼을 누르면 1층에서 5층으로, 또는 3층에서 7층으로)
//	D : D버튼을 눌렀을 시 내려가는 층수( D가 4일 때, D버튼을 누려먼 5층에서 1층으로, 또는 7층에서 3층으로)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		//적어도 한번 방문한 층은 다시 방문하지 않을것.
		//강호가 아래에 있을 경우, 바로 아래까지 올라가기.
		//u버튼을 눌러서 도착할 수 있으면 바로 올라가서 끝내고,
		//그렇지 않을 경우 다시 한번 u버튼을 눌러도 현재 위치 층수 <= S일때까지 D로 강하
		//한번 방문한 곳을 D를 통해 다시 방문하게 될 경우, 엘리베이터론 올라갈 수 없게 설정.(use the stairs)
		
		isVisited = new boolean[F+1];
		bfs(S,count);
		
		System.out.println(sb);
	}
	static void bfs(int start,int count) {
		isVisited[start] = true;
		fl.offer(start);
		while(!fl.isEmpty()) {	
			int num = fl.poll();
				if(count > 0 && isVisited[num]) //이미 방문한 곳을 다시 방문하면
				{	
					sb.append("use the stairs"); //계단 써야 한다 선언하기
					return;
				}	
				else {
					isVisited[num] = true;
					if(num == G) { //다시 반복했을 때 G층에 도달해있으면
						sb.append(count);
						return;
					}
					else if((num < G | num-D < 1) && num + U <= F)
					{
						count++;
						fl.offer(num+U);
					}
					else if((num > G | num+U > F) && num - D >= 1) 
					{
						count++;
						fl.offer(num-D);
					}
			}
		}
	}
}
