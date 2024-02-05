package leetcode.hard;

import java.util.Arrays;

public class PalindromePartitioning_3_1278 {
	int memoPalindrome[][];

	public static void main(String[] args) {
		PalindromePartitioning_3_1278 obj = new PalindromePartitioning_3_1278();
		System.out.println(obj.minCut("leetcode", 2));

	}

	public int minCut(String s, int k) {

		int[][] dp = new int[s.length()][k];
		memoPalindrome = new int[s.length()][s.length()];
		buildPalindromeDp(s, s.length());

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		return rec(s, 0, dp, k - 1);
	}
	/*
	 * public int minCutTab(String s, int k) {
	 * 
	 * int[] dp = new int[s.length() + 1]; memoPalindrome = new
	 * int[s.length()][s.length()]; buildPalindromeDp(s, s.length()); int n =
	 * s.length(); for (int i = n - 1; i >= 0; i--) { int minCut =
	 * Integer.MAX_VALUE; for (int p = i; p < s.length(); p++) {
	 * 
	 * if (!isPalindrome(s, i, p)) { continue; }
	 * 
	 * minCut = Math.min(minCut, 1 + dp[p + 1]);
	 * 
	 * } dp[i] = minCut; } return dp[0] - 1; }
	 */

	public int rec(String s, int i, int[][] dp, int k) {

		if (k < 0 && i < s.length()) {
			return 101;
		}

		if (i >= s.length()) {

			if (k >= 0) {
				return 101;
			}
			return 0;
		}

		if (dp[i][k] != -1) {
			return dp[i][k];
		}

		int minCut = 101;
		for (int p = i; p < s.length(); p++) {

			minCut = Math.min(minCut, memoPalindrome[i][p] + rec(s, p + 1, dp, k - 1));

		}
		return dp[i][k] = minCut;

	}

	private void buildPalindromeDp(String s, int n) {

		for (int end = 1; end < s.length(); end++) {
			for (int start = 0; start < end; start++) {
				if (s.charAt(start) == s.charAt(end)) {
					memoPalindrome[start][end] = memoPalindrome[start + 1][end - 1];
				} else if (end - start <= 2) {
					memoPalindrome[start][end] = 1;
				} else if (s.charAt(start) != s.charAt(end)) {
					memoPalindrome[start][end] = 1 + memoPalindrome[start + 1][end - 1];
				}
			}
		}
	}
}
