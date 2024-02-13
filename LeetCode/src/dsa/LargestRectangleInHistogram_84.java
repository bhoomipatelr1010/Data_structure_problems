package dsa;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {

	public static void main(String[] args) {
		int nums[] = new int[] { 2, 4 };
		System.out.println(largestRectangleArea(nums));
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

}
