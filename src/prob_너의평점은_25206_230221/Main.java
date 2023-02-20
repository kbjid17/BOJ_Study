package prob_너의평점은_25206_230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<obj> ar = new ArrayList<obj>();
	static HashMap<String,Double> gradeList = new HashMap<String,Double>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		gradeList.put("A+", 4.5);
		gradeList.put("A0", 4.0);
		gradeList.put("B+", 3.5);
		gradeList.put("B0", 3.0);
		gradeList.put("C+", 2.5);
		gradeList.put("C0", 2.0);
		gradeList.put("D+", 1.5);
		gradeList.put("D0", 1.0);
		gradeList.put("F", 0.0);
		// P 과목은 그냥 계산을 안한다.
		Double sc_gr = 0.0; // (전공학점 * 과목평점) 총합
		Double sc = 0.0; // 전공학점 총합
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ar.add(new obj(st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken()));
			if(ar.get(i).grade.equals("P")) continue;
//			System.out.println(ar.get(i).toString());
			sc_gr += ar.get(i).score * gradeList.get(ar.get(i).grade);
			sc += ar.get(i).score;
		}
		
		System.out.println(String.format("%.6f", (sc_gr/sc)));
	}
	
//	A+	4.5
//	A0	4.0
//	B+	3.5
//	B0	3.0
//	C+	2.5
//	C0	2.0
//	D+	1.5
//	D0	1.0
//	F	0.0
	static class obj {
		String name;
		double score;
		String grade;
		public obj(String name, double score, String grade) {
			super();
			this.name = name;
			this.score = score;
			this.grade = grade;
		}
		
		@Override
		public String toString() {
			return "obj [name = " + name + ", score = " + score + ", grade = " + grade + "]";
		}
		
		
	}

}
