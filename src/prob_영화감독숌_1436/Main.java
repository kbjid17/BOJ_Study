package prob_영화감독숌_1436;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N,cnt,num;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list.add("0");
		while(cnt < N) {
			list.remove(0);
			list.add(Integer.toString(++num));
			if(list.get(0).contains("666")) {
				cnt++;
			}
		}
		System.out.println(list.get(0));
	}
}