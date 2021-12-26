package prob_스타트와링크_14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,min = Integer.MAX_VALUE,teamAsum,teamBsum;
	static int[][] ar;
	static boolean[] visit;
	static int[] tgt,teamAs,teamBs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ar = new int[N][N];
		tgt = new int[N/2];
		teamAs = new int[2];
		teamBs = new int[2];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		team(0,0);
		System.out.println(min/2);
	}
	static void team(int tgtIdx,int srcIdx) {
		if(tgtIdx == N/2) {
			//팀 분별이 끝났으면 각 팀 N명당 2명의 조합별 모든 점수를 합하면 됨.
//			System.out.println(Arrays.toString(tgt));
			teamAsum = 0;
			teamBsum = 0;
			team_calc();
			min = Math.min(min, Math.abs(teamAsum-teamBsum));
			return;
		}
		for (int i = srcIdx; i < N; i++) {
			if(visit[i]) continue;
			tgt[tgtIdx] = i;
			visit[i] = true;
			team(tgtIdx+1,i+1);
			visit[i] = false;
		}
	}
	static void team_calc() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(visit[i] && visit[j]) {
					teamAsum += (ar[i][j]+ar[j][i]);
				}else if(!visit[i] && !visit[j]) {
					teamBsum += (ar[i][j]+ar[j][i]);
				}
			}
		}

	}
}
