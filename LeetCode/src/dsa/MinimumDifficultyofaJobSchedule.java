package dsa;
public class MinimumDifficultyofaJobSchedule {

	public static void main(String[] args) {
		MinimumDifficultyofaJobSchedule obj = new MinimumDifficultyofaJobSchedule();
		int[] j = new int[] { 11, 111, 22, 222, 33, 333, 44, 444 };
		obj.findSolution(j, 6);

	}

	public int findSolution(int[] jobDifficulty, int d) {

		int n = jobDifficulty.length;
		int[][] dp = new int[n][d];

		if (n < d) {
			return -1;
		}

		int lastColMaxDiff = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (lastColMaxDiff < jobDifficulty[i]) {
				lastColMaxDiff = jobDifficulty[i];
			}
			dp[i][d - 1] = Math.max(lastColMaxDiff, jobDifficulty[i]);

		}

		for (int j = d - 2; j >= 0; j--) {

			for (int i = j; i <= n - 1 - (d - 1 - j); i++) {

				int currentMax = jobDifficulty[i];
				int k = i + 1;
				dp[i][j] = jobDifficulty[i] + dp[i + 1][j + 1];
				while (k <= n - 1 - (d - 1 - j)) {

					if (currentMax < jobDifficulty[k]) {
						currentMax = jobDifficulty[k];
					}

					dp[i][j] = Math.min(dp[i][j], currentMax + dp[k + 1][j + 1]);
					k++;
				}

			}
		}

		return dp[0][0];

	}

}
