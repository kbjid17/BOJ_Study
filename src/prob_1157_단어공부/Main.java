package prob_1157_단어공부;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static Queue<Character> q = new LinkedList<Character>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		int[] ar = new int[26];
		for(int a = 0; a < s.length; a++) {
			if(s[a] >= 'A' || s[a] >= 'a')
				ar[0]++;
			else if(s[a] >= 'B' || s[a] >= 'b')
				ar[1]++;
			else if(s[a] >= 'C' || s[a] >= 'c')
				ar[2]++;
			else if(s[a] >= 'D' || s[a] >= 'd')
				ar[3]++;
			else if(s[a] >= 'E' || s[a] >= 'e')
				ar[4]++;
			else if(s[a] >= 'F' || s[a] >= 'f')
				ar[5]++;
			else if(s[a] >= 'G' || s[a] >= 'g')
				ar[6]++;
			else if(s[a] >= 'H' || s[a] >= 'h')
				ar[7]++;
			else if(s[a] >= 'I' || s[a] >= 'i')
				ar[8]++;
			else if(s[a] >= 'J' || s[a] >= 'j')
				ar[9]++;
			else if(s[a] >= 'K' || s[a] >= 'k')
				ar[10]++;
			else if(s[a] >= 'L' || s[a] >= 'l')
				ar[11]++;
			else if(s[a] >= 'M' || s[a] >= 'm')
				ar[12]++;
			else if(s[a] >= 'N' || s[a] >= 'n')
				ar[13]++;
			else if(s[a] >= 'O' || s[a] >= 'o')
				ar[14]++;
			else if(s[a] >= 'P' || s[a] >= 'p')
				ar[15]++;
			else if(s[a] >= 'Q' || s[a] >= 'q')
				ar[16]++;
			else if(s[a] >= 'R' || s[a] >= 'r')
				ar[17]++;
			else if(s[a] >= 'S' || s[a] >= 's')
				ar[18]++;
			else if(s[a] >= 'T' || s[a] >= 't')
				ar[19]++;
			else if(s[a] >= 'U' || s[a] >= 'u')
				ar[20]++;
			else if(s[a] >= 'V' || s[a] >= 'v')
				ar[21]++;
			else if(s[a] >= 'W' || s[a] >= 'w')
				ar[22]++;
			else if(s[a] >= 'X' || s[a] >= 'x')
				ar[23]++;
			else if(s[a] >= 'Y' || s[a] >= 'y')
				ar[24]++;
			else if(s[a] >= 'Z' || s[a] >= 'z')
				ar[25]++;
			
			for (int i = 0; i < ar.length; i++) {
				max = Math.max(max, ar[i]);
			}
		}
		}
	}
