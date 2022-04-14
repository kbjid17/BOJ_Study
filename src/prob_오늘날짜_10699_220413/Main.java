package prob_오늘날짜_10699_220413;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		LocalDate d =  LocalDate.now();
		
		String formatedNow = d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		
		System.out.println(formatedNow);
	}

}
