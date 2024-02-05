package leetcode.hard;

import java.util.Arrays;

public class PalindromePartitioning_2_132 {
	private Boolean memoPalindrome[][];

	public static void main(String[] args) {
		PalindromePartitioning_2_132 obj = new PalindromePartitioning_2_132();
		System.out.println(obj.minCut("ab"));

	}

	public int minCut(String s) {

		int[] dp = new int[s.length()];
		memoPalindrome = new Boolean[s.length()][s.length()];
		Arrays.fill(dp, -1);
		return rec(s, 0, dp) - 1;
	}

	public int minCutTab(String s) {

		int[] dp = new int[s.length() + 1];
		buildPalindromeDp(s, s.length());
		int n = s.length();
		for (int i = n - 1; i >= 0; i--) {
			int minCut = Integer.MAX_VALUE;
			for (int p = i; p < s.length(); p++) {

				if (!isPalindrome(s, i, p)) {
					continue;
				}

				minCut = Math.min(minCut, 1 + dp[p + 1]);

			}
			dp[i] = minCut;
		}
		return dp[0] - 1;
	}

	public int rec(String s, int i, int[] dp) {

		if (i >= s.length()) {
			return 0;
		}

		if (dp[i] != -1) {
			return dp[i];
		}

		int minCut = Integer.MAX_VALUE;
		for (int p = i; p < s.length(); p++) {

			if (!isPalindrome(s, i, p)) {
				continue;
			}

			minCut = Math.min(minCut, 1 + rec(s, p + 1, dp));

		}
		return dp[i] = minCut;

	}

	private void buildPalindromeDp(String s, int n) {
		for (int end = 0; end < s.length(); end++) {
			for (int start = 0; start <= end; start++) {
				if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || memoPalindrome[start + 1][end - 1])) {
					memoPalindrome[start][end] = true;
				}
			}
		}
	}

	public boolean checkIfPalindrom(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		}
		return true;
	}

	private boolean isPalindrome(String s, int start, int end) {
		if (start >= end) {
			return true;
		}
		// check for results in memoPalindrome
		if (memoPalindrome[start][end] != null) {
			return memoPalindrome[start][end];
		}
		return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1);
	}
}
