package prob_컨베이어벨트위의로봇_20055_220414_실패;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static conv[] ar; // [N+1]의 크기를 가지는 배열
	static ArrayList<Integer> list = new ArrayList<Integer>(); // 로봇의 위치를 저장하는 배열. 순서가 있어야 하기 때문.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ar = new conv[2*N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < ar.length; i++) {
			ar[i] = new conv(Integer.parseInt(st.nextToken()),false,0); // 로봇이 없다면 순서 칸은 0으로 처리
		}
		// 입력 완료
		
		//내리는 위치 : [N], 올리는 위치 : [1]
		// 로봇을 올리는 위치에 올리거나 로봇이 어떤 칸으로 이동하면 그 칸은 즉시 1만큼 내구도가 감소
		
		int stage = 0; // 단계 수
		int cnt = 0; // 내구도가 0이 된 칸의 수
		while(true) {
			stage++; // stage는 1단계부터 시작
			
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전
			// 배열을 통째로 돌려야 함. 1->2, 2->3, 3->4 ,..., 12->1
			// 12->1, 11->12, 10->11,...,2->3, 1->2 ==> 1을 저장하고 2*N부터 차례로 돌림
			// 배열이 돌아갈 때 로봇 위치를 기억해주는 list도 변화가 있어야 함!
			conv temp = ar[1];
			for (int i = 2*N; i >= 1; i--) {
				if(i == 2*N) {
					ar[1] = ar[i];
					if(ar[1].robot) {
						// 로봇이 있다면, list의 로봇 위치도 바뀌어 줘야 함.
						list.set(ar[1].o-1,1);
					}
				}
				else if(i == 1) {
					ar[2] = temp;
					if(ar[2].robot) {
						System.out.println(ar[2].o + " " + i);
						// 로봇이 있다면, list의 로봇 위치도 바뀌어 줘야 함.
						list.set(ar[2].o-1,2);
					}
				}
				else {
					ar[i+1] = ar[i];
					if(ar[i+1].robot) {
						// 로봇이 있다면, list의 로봇 위치도 바뀌어 줘야 함.
						list.set(ar[i+1].o-1,i+1);
					}
				}
				
				//로봇이 이동했을 때, 로봇이 내리는 위치에 도달하면 즉시 내린다.
				if(ar[N].robot) {
					System.out.println(ar[N].o);
					for (int j = 1; j <= 2*N; j++) {
						if(ar[j].robot && ar[j].o > ar[N].o) {
							ar[j].o -=1;
						}
					}
					list.remove(ar[N].o-1);
					ar[N].robot = false;
					ar[N].o = 0; // 순서 정보를 지움 -> 이 지운 순서보다 뒤에 있는 로봇을은 앞으로 가져옴.
				}
			}
			System.out.println(Arrays.toString(ar));
			
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			// 가장 먼저 벨트에 올라간 로봇부터 ==> 로봇이 올라간 순서가 있음을 의미 => 올라간 로봇들을 순서대로 리스트에 올리고 확인
			for (int a : list) {
				if(ar[a%(2*N)+1].n > 0 && !ar[a%(2*N)+1].robot) { // 이동하려는 칸의 내구도가 1 이상이며 로봇이 없어야 함
					/*
					 ar에 있는 로봇 정보가 한칸 앞으로 이동하고
					 list에 있는 로봇 정보가 변해야 함.
					 */
					ar[a%(2*N)+1].robot = true;
					ar[a%(2*N)+1].o = ar[a].o; //앞 칸은 내구도가 있고 로봇이 없으므로 이전 칸에서 가져옴
					list.set(ar[a%(2*N)+1].o-1 , a%(2*N)+1); // robot의 위치를 가지는 list에서도 위치를 한칸 앞으로 이동
					ar[a].robot = false;
					ar[a].o = 0; // 현재 칸에는 로봇이 이동해서 사라짐
					ar[a].n -=1; // 현재 칸에서 로봇의 이동이 발생했으므로 내구도 값이 줄어듦
					if(ar[a].n == 0) {
						cnt++;
					}
				}
			}
			//로봇이 이동했을 때, 로봇이 내리는 위치에 도달하면 즉시 내린다.
			if(ar[N].robot) {
				for (int j = 1; j <= 2*N; j++) {
					if(ar[j].robot && ar[j].o > ar[N].o) {
						ar[j].o -=1;
					}
				}
				list.remove(ar[N].o-1);
				ar[N].robot = false;
				ar[N].o = 0; // 순서 정보를 지움 -> 이 지운 순서보다 뒤에 있는 로봇을은 앞으로 가져옴.
			}
			
			//3. 올리는 위치(1)에 있는 칸의 내구도가 0이 아니라면 올리는 위치에 로봇을 올린다.
			if(ar[1].n > 0) {
				ar[1].robot = true;
				list.add(1);
				ar[1].o = list.size();
				ar[1].n -=1;
			}
			
			
			//4. 내구도가 0인 칸이 K개 이상이면 과정 종료. 그렇지 않다면 1번으로 돌아감.
			if(cnt >= K) {
				System.out.println(stage);
				return;
			}
			
		}
		
	}
	/*
	ar : 컨베이어 벨트 배열
	벨트엔 로봇이 올라갈 수 있음.
	벨트에 로봇이 올라갔는지 확인해야 함.
	*/
	static class conv {
		int n; // 내구도
		boolean robot; // 로봇이 올라왔는지 안올라왔는지(로봇이 없을 때 올라갈 수 있어야 함)
		int o; // 로봇의 순서를 기억
		public conv(int n, boolean robot, int o) {
			super();
			this.n = n;
			this.robot = robot;
			this.o = o;
		}
		@Override
		public String toString() {
			return "conv [n=" + n + ", robot=" + robot + ", o=" + o + "]";
		}
		
		
	}

}
