package dsa;

public class MaximalSquare {

	public static void main(String[] args) {
		MaximalSquare obj = new MaximalSquare();
		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		obj.maximalSquare(matrix);
	}

	public int maximalSquare(char[][] matrix) {
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[] dp = new int[cols + 1];
		int maxsqlen = 0, prev = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				int temp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
					maxsqlen = Math.max(maxsqlen, dp[j]);
				} else {
					dp[j] = 0;
				}
				prev = temp;
				System.out.print(" " + prev + " .. ");
			}
		}
		System.out.println("");
		System.out.println(dp);
		return maxsqlen * maxsqlen;
	}

}
