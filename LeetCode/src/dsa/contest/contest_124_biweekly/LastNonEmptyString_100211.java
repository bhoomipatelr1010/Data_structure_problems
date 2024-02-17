package dsa.contest.contest_124_biweekly;

import java.util.Arrays;

public class LastNonEmptyString_100211 {

	public static void main(String[] args) {
		System.out.println(lastNonEmptyString("abcd"));

	}

	public static String lastNonEmptyString(String s) {

		int[] rec = new int[26];

		int max = Integer.MIN_VALUE;

		for (char c : s.toCharArray()) {

			rec[c - 'a']++;
			max = Math.max(max, rec[c - 'a']);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (rec[c - 'a'] == max) {
				sb.append(c);
				rec[c - 'a'] -= 1;
			}
		}

		return sb.reverse().toString();
	}
}
