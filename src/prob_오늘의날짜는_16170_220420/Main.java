package prob_오늘의날짜는_16170_220420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LocalDateTime d = LocalDateTime.now();
//		System.out.println(d);
		System.out.println(d.getYear());
		System.out.println(d.getDayOfWeek().getValue()+1);
		System.out.println(d.getDayOfMonth());

	}

}
