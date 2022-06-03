package prob_새로운게임2_17837_220515_미완;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	//  이동 방향은 4보다 작거나 같은 자연수이고 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.
	static box[][] ar;
	static int round = 0,malsize = 0;
	static int N,K; // 체스판 : [N][N] , 말의 개수 : K
	static ArrayList<mal> mallist = new ArrayList<mal>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ar = new box[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = new box(Integer.parseInt(st.nextToken()),new ArrayList<mal>());
			}
		}
		mallist.add(null); // mallist.get(0)은 더미로!
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			ar[y][x].list.add(new mal(i,y,x,dir,ar[y][x].list.size())); 
			// i번 말은 [y][x]에 위치하고 있으며, 방향은 dir이다. ar[y][x]의 ar[y][x].list.size()+1 번째 말이다.(들어가기 전의 사이즈 +1 = 들어간 후의 사이즈)
			mallist.add(new mal(i,y,x,dir,ar[y][x].list.size()-1));
		}
		
		do {
			game();
		}while(malsize < 4);
		
//		do {
//			game();
//		}while(false);
		
		if(round > 1000) {
			round = -1;
		}
		System.out.println(round);
	}
	
	static void game() {
		round++;
		if(round > 1000) return;
		for (int i = 1; i <= K; i++) { // 1번 말부터 K번 말까지 이동 진행
			int ny = mallist.get(i).y + dy[mallist.get(i).dir];
			int nx = mallist.get(i).x + dx[mallist.get(i).dir];
			
			int ry =  mallist.get(i).y;
			int rx =  mallist.get(i).x;
			int ridx = mallist.get(i).idx; // ArrayList에서 ridx번 블록이 삭제되면 다음 블록이 ridx번 블록이 됨.
			// i번 말이 [ny][nx]로 이동 진행
			switch(ar[ny][nx].num) {
			case 0: // 흰색의 경우( 큐 처럼 밑에서 위로 넣기)
				for (int j = mallist.get(i).idx; j < ar[mallist.get(i).y][mallist.get(i).x].list.size(); j++) {
					// ar[ny][nx]로 말을 옮기기
					ar[ny][nx].list.add(ar[mallist.get(i).y][mallist.get(i).x].list.get(j)); //ar[ny][nx].list에 값 더하기
					
					// 방금 더해진 블록의 정보 값 바꿔주기
					// 하얀 색 블록으로 이동할 때 바꿔줘야 할 값 : y,x,idx
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).y = ny;
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).x = nx;
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).idx = ar[ny][nx].list.size() -1;
					
					mal nmal = ar[ny][nx].list.get(ar[ny][nx].list.size()-1); // 정보가 바뀐 말.
					
					
					// mallist에 있는 블록들의 정보도 바꿔줘야 함!
					mallist.get(nmal.num).y = nmal.y;
					mallist.get(nmal.num).x = nmal.x;
					mallist.get(nmal.num).idx = nmal.idx;
					
				}
				
				// ar[malList.get(i).y][malList.get(i).x]에서 말을 빼기
				
				for (int j = ridx; j < ar[mallist.get(i).y][mallist.get(i).x].list.size(); j++) {
					/*
					 * ridx = mallist.get(i).idx = 0 이라 하면
					 * ar[ry][rx].list의 ridx번 말을 제거하면
					 * 그 다음에 있는 말이 ridx번 말이 됨 
					 */
					ar[ry][rx].list.remove(ridx);
				}
				malsize = ar[ny][nx].list.size();
				if(malsize >= 4) {
					return;
				}
				break;
			case 1: // 빨간색의 경우
				// 하얀색 블록과 반대로 넣기(스택처럼 위에서 아래로)
				for (int j = ar[mallist.get(i).y][mallist.get(i).x].list.size()-1; j >= mallist.get(i).idx; j--) {
					ar[ny][nx].list.add(ar[mallist.get(i).y][mallist.get(i).x].list.get(j));
					
					// 방금 더해진 블록의 정보 값 바꿔주기
					// 붉은 색 블록으로 이동할 때 바꿔줘야 할 값 : y,x,idx
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).y = ny;
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).x = nx;
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).idx = ar[ny][nx].list.size() -1;
					
					mal nmal = ar[ny][nx].list.get(ar[ny][nx].list.size()-1); // 정보가 바뀐 말.
					
					
					// mallist에 있는 블록들의 정보도 바꿔줘야 함!
					mallist.get(nmal.num).y = nmal.y;
					mallist.get(nmal.num).x = nmal.x;
					mallist.get(nmal.num).idx = nmal.idx;
				}
				break;
			case 2: // 파란색의 경우
				int ndir = (mallist.get(i).dir %2 == 0 ? mallist.get(i).dir+1 : mallist.get(i).dir-1);
				ny = mallist.get(i).y + dy[ndir];
				nx = mallist.get(i).x + dx[ndir];
				ar[mallist.get(i).y][mallist.get(i).x].list.get(mallist.get(i).idx).dir = ndir; // 맨 밑 블록의 방향만 바꾼 후에는 하얀색 이동과 동일
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || ar[ny][nx].num == 2) break; // 밖으로 나가거나 이동할 곳도 파란 블록이면 이동 X
				
				// 맨 밑 말의 방향만 바꿔주고 위치 바꿔주기
				for (int j = mallist.get(i).idx; j < ar[mallist.get(i).y][mallist.get(i).x].list.size(); j++) {
					// ar[ny][nx]로 말을 옮기기
					ar[ny][nx].list.add(ar[mallist.get(i).y][mallist.get(i).x].list.get(j)); //ar[ny][nx].list에 값 더하기
					
					// 방금 더해진 블록의 정보 값 바꿔주기
					// 하얀 색 블록으로 이동할 때 바꿔줘야 할 값 : y,x,idx
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).y = ny;
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).x = nx;
					ar[ny][nx].list.get(ar[ny][nx].list.size()-1).idx = ar[ny][nx].list.size() -1;
					
					mal nmal = ar[ny][nx].list.get(ar[ny][nx].list.size()-1); // 정보가 바뀐 말.
					
					
					// mallist에 있는 블록들의 정보도 바꿔줘야 함!
					mallist.get(nmal.num).y = nmal.y;
					mallist.get(nmal.num).x = nmal.x;
					mallist.get(nmal.num).idx = nmal.idx;
				}
				
				// ar[malList.get(i).y][malList.get(i).x]에서 말을 빼기
				
				for (int j = ridx; j < ar[mallist.get(i).y][mallist.get(i).x].list.size(); j++) {
					/*
					 * ridx = mallist.get(i).idx = 0 이라 하면
					 * ar[ry][rx].list의 ridx번 말을 제거하면
					 * 그 다음에 있는 말이 ridx번 말이 됨 
					 */
					ar[ry][rx].list.remove(ridx);
				}
				break;
			
			}
		}
	}
	
	static class box {
		int num; // 블록의 색(0 : 흰색, 1 : 빨간색, 2 : 파란색)
		ArrayList<mal> list; // 말이 어떻게 쌓여 있는지(각 블록은 번호와 좌표,방향을 가짐)
		public box(int num, ArrayList<mal> list) {
			super();
			this.num = num;
			this.list = list;
		}
	}
	
	static class mal { // 각 칸의 box에 담길 말의 정보를 담고 있음
		int num; // 해당 말의 번호(1~K)
		int y; 
		int x; // [y][x]
		int dir; // 해당 말의 방향
		int idx; // 특정 box에서 해당 말의 순서
		public mal(int num, int y, int x, int dir, int idx) {
			super();
			this.num = num;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.idx = idx;
		}
	}
}
