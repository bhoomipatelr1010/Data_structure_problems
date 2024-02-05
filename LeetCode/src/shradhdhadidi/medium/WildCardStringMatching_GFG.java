package shradhdhadidi.medium;

import java.util.Arrays;

public class WildCardStringMatching_GFG {

	public static void main(String[] args) {
		WildCardStringMatching_GFG obj = new WildCardStringMatching_GFG();
		System.out.println(obj.wildcardMatching("*???", "aa"));

	}

	public boolean wildcardMatching(String pattern, String text) {

		/*
		 * Boolean[][] dp = new Boolean[pattern.length()][text.length()];
		 * 
		 * int i = pattern.length() - 1; int j = text.length() - 1;
		 */
		// return solution(i, j, pattern, text, dp);

		boolean[][] dp = new boolean[pattern.length() + 1][text.length() + 1];

		return tabSolOpt(pattern, text);

	}

	public boolean tabSolOpt(String pattern, String text) {

		boolean[] prev = new boolean[text.length() + 1];
		boolean[] cur = new boolean[text.length() + 1];

		prev[0] = true;

		for (int i = 1; i <= pattern.length(); i++) {

			boolean flag = true;
			for (int k = 1; k <= i; k++) {
				if (prev[0]&&pattern.charAt(i - 1) != '*') {
					flag = false;
					break;
				}
			}
			cur[0] = flag;

			for (int j = 1; j <= text.length(); j++) {

				if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
					cur[j] = prev[j - 1];
				} else if (pattern.charAt(i - 1) == '*') {

					cur[j] = cur[j - 1] || prev[j];

				} else {
					cur[j] = false;
				}
			}
			prev = Arrays.copyOf(cur, cur.length);

		}
		return prev[text.length()];
	}

	public boolean tabSol(String pattern, String text, boolean[][] dp) {

		dp[0][0] = true;

		for (int i = 1; i <= pattern.length(); i++) {

			boolean flag = true;
			for (int k = 1; k <= i; k++) {
				if (pattern.charAt(k - 1) != '*') {
					flag = false;
				}
			}
			dp[i][0] = flag;

			for (int j = 1; j <= text.length(); j++) {

				if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(i - 1) == '*') {

					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

				} else {
					dp[i][j] = false;
				}

			}
		}
		return dp[pattern.length()][text.length()];
	}

//memo
	public boolean solution(int i, int j, String pattern, String text, Boolean[][] dp) {

		if (i < 0 && j < 0) {
			return true;
		}

		if (i < 0 && j >= 0) {
			return false;
		}
		if (j < 0) {

			for (int k = 0; k <= i; k++) {
				if (pattern.charAt(k) != '*') {
					return false;
				}
			}
			return true;
		}

		if (dp[i][j] != null) {

			return dp[i][j];
		}

		if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
			return dp[i][j] = solution(i - 1, j - 1, pattern, text, dp);
		} else if (pattern.charAt(i) == '*') {

			return dp[i][j] = solution(i - 1, j, pattern, text, dp) || solution(i, j - 1, pattern, text, dp);

		} else {
			return dp[i][j] = false;
		}
	}

}
