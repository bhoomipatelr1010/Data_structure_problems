package leetcode.hard;

public class PalindromePartitioning_4_1745 {
	boolean memoPalindrome[][];

	public static void main(String[] args) {
		PalindromePartitioning_4_1745 obj = new PalindromePartitioning_4_1745();
		System.out.println(obj.checkPartitioning("bcbddxy"));

	}

	public boolean checkPartitioning(String s) {
		Boolean[][] dp = new Boolean[s.length()][3];
		memoPalindrome = new boolean[s.length()][s.length()];
		buildPalindromeDp(s, s.length());
		return rec(s, 0, 2, dp);
	}

	public boolean rec(String s, int start, int k, Boolean[][] dp) {

		if (k < 0 && start < s.length()) {
			return false;
		}
		if (start >= s.length()) {
			return k >= 0 ? false : true;

		}

		if (dp[start][k] != null) {
			return dp[start][k];
		}

		boolean isPalindrom = false;
		for (int end = start; end < s.length(); end++) {
			if (!memoPalindrome[start][end]) {
				continue;
			}
			isPalindrom = isPalindrom || rec(s, end + 1, k - 1, dp);
		}

		return dp[start][k] = isPalindrom;

	}

// best solution
	public boolean tab(String s) {
		int n = s.length();
		memoPalindrome = new boolean[s.length()][s.length()];

		for (int end = 0; end < s.length(); end++) {
			for (int start = 0; start <= end; start++) {
				if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || memoPalindrome[start + 1][end - 1])) {
					memoPalindrome[start][end] = true;
				}
			}
		}

		for (int i = 1; i < n - 2; i++) {
			for (int j = i; j < n - 1; j++) {
				if (memoPalindrome[0][i - 1] && memoPalindrome[i][j] && memoPalindrome[j + 1][n - 1]) {
					return true;
				}
			}
		}
		return false;

	}

	private void buildPalindromeDp(String s, int n) {
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i <= j; i++) {
				if (s.charAt(i) == s.charAt(j)) {
					memoPalindrome[i][j] = ((i + 1 <= j - 1) ? memoPalindrome[i + 1][j - 1] : true);

				}
			}
		}
	}

}
