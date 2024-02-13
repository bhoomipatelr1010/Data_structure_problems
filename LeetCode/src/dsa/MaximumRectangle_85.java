package dsa;

import java.util.Stack;

public class MaximumRectangle_85 {
	public static void main(String[] args) {

		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		System.out.println(maximalRectangle(matrix));

	}

	public static int largestRectangleArea(int[] heights) {

		Stack<Integer> st = new Stack<>();

		int n = heights.length;

		int max = Integer.MIN_VALUE;

		for (int right = 0; right <= n; right++) {
			while (!st.isEmpty() && (right == n || heights[st.peek()] > heights[right])) {

				int mid = st.pop();

				int left = st.empty() ? -1 : st.peek();

				max = Math.max(max, heights[mid] * (right - left - 1));

			}
			st.push(right);

		}

		return max;
	}

	public static int maximalRectangle(char[][] matrix) {

		int n = matrix.length;

		if (n == 0) {
			return 0;
		}
		int m = matrix[0].length;

		int maxArea = Integer.MIN_VALUE;

		int[] dp = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
			}

			maxArea = Math.max(maxArea, largestRectangleArea(dp));

		}
		return maxArea;

	}
}
