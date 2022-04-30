package prob_달달함이넘쳐흘러_17256_220430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static nums[] ar = new nums[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			ar[i] = new nums(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		System.out.println((ar[1].x-ar[0].z) + " " + (ar[1].y/ar[0].y) + " " + (ar[1].z-ar[0].x));

	}

	static class nums {
		int x;
		int y;
		int z;
		public nums(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		
	}
}
