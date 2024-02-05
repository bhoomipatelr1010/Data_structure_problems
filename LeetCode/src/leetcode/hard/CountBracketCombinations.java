package leetcode.hard;

public class CountBracketCombinations {

	public static void main(String[] args) {
		System.out.print(BracketCombinations(3));
	}

	public static int BracketCombinations(int num) {

		int dp[] = new int[num + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= num; i++) {
			int currentPair = 0;
			for (int j = i - 1; j >= 0; j--) {
				currentPair += dp[j] * dp[i - j - 1];
			}
			dp[i] = currentPair;
		}

		return dp[num];
	}
}
