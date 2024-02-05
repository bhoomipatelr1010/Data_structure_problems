package leetcode.hard;

import java.util.Arrays;

public class MaximumNumberOfNonOverlappting_2472 {
	boolean memoPalindrome[][];

	public static void main(String[] args) {
		MaximumNumberOfNonOverlappting_2472 obj = new MaximumNumberOfNonOverlappting_2472();

		System.out.println(obj.maxPalindromes("abaccdbbd", 3));
	}

	public int maxPalindromes(String s, int k) {
		int[] dp = new int[s.length()];
		memoPalindrome = new boolean[s.length()][s.length()];
		buildPalindromeDp(s, s.length());
		Arrays.fill(dp, -1);
		return rec(s, 0, k, dp);

	}

	public int rec(String s, int start, int k, int[] dp) {

		if (start >= s.length()) {
			return 0;
		}

		if (dp[start] != -1) {
			return dp[start];
		}

		int ans = 0;

		// not pick

		ans = rec(s, start + 1, k, dp);
		// pick

		for (int end = start + k - 1; end < s.length(); end++) {

			if (!memoPalindrome[start][end]) {
				continue;
			}
			ans = Math.max(ans, 1 + rec(s, end + 1, k, dp));
		}
		return dp[start] = ans;
	}

	private void buildPalindromeDp(String s, int n) {

		char[] arr = s.toCharArray();
		for (int end = 0; end < s.length(); end++) {
			for (int start = 0; start <= end; start++) {
				if (arr[start] == arr[end] && (end - start <= 2 || memoPalindrome[start + 1][end - 1])) {
					memoPalindrome[start][end] = true;
				}
			}
		}
	}
}
