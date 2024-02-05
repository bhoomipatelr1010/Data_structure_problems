package amazon.medium;

public class DP_Array_Leetcode_1981 {

	public static void main(String[] args) {
		DP_Array_Leetcode_1981 obj = new DP_Array_Leetcode_1981();

		int[][] mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(obj.minimizeTheDifference(mat, 13));
	}

	public int minimizeTheDifference1(int[][] mat, int target) {

		int[][] memo = new int[mat.length][5001];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < 5001; j++) {
				memo[i][j] = -1;
			}
		}
		return dp(mat, target, 0, 0, memo, Integer.MAX_VALUE);

	}

	public int dp(int[][] mat, int target, int rowIndex, int currentSum, int[][] memo, int minDiff) {

		if (rowIndex == mat.length) {

			return Math.abs(target - currentSum);
		}
		if (memo[rowIndex][currentSum] != -1) {

			return memo[rowIndex][currentSum];
		}
		for (int j = 0; j < mat[0].length; j++) {

			minDiff = Math.min(minDiff, dp(mat, target, rowIndex + 1, currentSum + mat[rowIndex][j], memo, minDiff));
		}
		return memo[rowIndex][currentSum] = minDiff;

	}

	public int minimizeTheDifference(int[][] mat, int target) {
		int m = mat.length, n = mat[0].length; // Get matrix dimensions
		

		int minSum = 0; // Initialize minSum

		// Find the minimum value in each row and add to minSum
		for (int i = 0; i < m; i++) {
			int currRowMin = mat[i][0];
			// Find the smallest value in the current row
			for (int j = 1; j < n; j++) {
				currRowMin = Math.min(currRowMin, mat[i][j]);
			}
			minSum += currRowMin; // Add the smallest value to minSum
		}

		// If minSum is greater than or equal to target, the answer is their difference
		if (minSum >= target)
			return minSum - target;

		int N = 2 * target - minSum; // Calculate N
		// Memory array to store if a sum is achievable
		boolean[] mem = new boolean[N];
		mem[0] = true;

		for (int i = 0; i < m; i++) {
			boolean[] next = new boolean[N];
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < n; j++) {
					if (mem[k] && mat[i][j] + k < N) {
						// Mark that the new sum is achievable
						next[k + mat[i][j]] = true;
					}
				}
			}
			// Update mem to the latest row's results
			mem = next;
		}

		int min = N;
		// Find the smallest difference from target
		for (int i = 0; i < N; i++) {
			if (mem[i])
				min = Math.min(min, Math.abs(target - i));
		}
		return min;
	}
}
