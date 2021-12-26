package prob_11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int btmask = 0;
		int count = Integer.parseInt(br.readLine());
		int num;
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				btmask = btmask | 1<<(num-1);
				break;
			case "remove" :
				num = Integer.parseInt(st.nextToken());
				btmask = btmask & ~(1<<(num-1));
				break;
			case "check" :
				num = Integer.parseInt(st.nextToken());
				sb.append(((btmask & 1<<(num-1))==1<<(num-1) ? 1 : 0) + "\n");
				break;
			case "toggle" :
				num = Integer.parseInt(st.nextToken());
				btmask = btmask ^ 1<<(num-1);
				break;
			case "all" :
				btmask = ~0;
				break;
			case "empty" : 
				btmask = 0;
				break;
			}
			
		}
		System.out.println(sb.toString());
	}
}