package leetcode.medium;

import java.util.Arrays;

public class NumberOfLongestIncresingSub_673 {

	public static void main(String[] args) {
		NumberOfLongestIncresingSub_673 obj = new NumberOfLongestIncresingSub_673();
		int nums[] = { 0, 1, 0, 3, 2, 3 };
		System.out.println(obj.findNumberOfLIS(nums));

	}

	public int findNumberOfLIS(int[] nums) {

		int dp[][] = new int[nums.length + 1][nums.length + 1];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		// return sub(nums, 1, 0, dp);

		return memo(nums);
	}

	/*
	 * public int dp(int[] nums, int[] dpNums, int n, int i, int j, int[] count) {
	 * 
	 * // not take
	 * 
	 * int notTake = dp(nums, dpNums, n, i + 1, j, count);
	 * 
	 * // take int take = Integer.MIN_VALUE; if (nums[i] > nums[j] && dpNums[i] <
	 * dpNums[j] + 1) { take = 1 + dp(nums, dpNums, n, i + 1, i, count); }
	 * 
	 * dp[i]= return i;
	 * 
	 * }
	 */

	public int sub(int[] nums, int i, int prev_i, int dp[][]) {

		if (i > nums.length) {
			return 0;
		}

		if (dp[i][prev_i] != -1) {
			return dp[i][prev_i];
		}

		int not = sub(nums, i + 1, prev_i, dp);

		int take = Integer.MIN_VALUE;
		if (prev_i - 1 < 0 || nums[i - 1] > nums[prev_i - 1])
			take = 1 + sub(nums, i + 1, i, dp);

		return dp[i][prev_i] = Math.max(take, not);
	}

	public int memo(int[] nums) {

		int next[] = new int[nums.length + 1];
		int cur[] = new int[nums.length + 1];

		for (int i = nums.length - 1; i >= 0; i--) {
			for (int previous = i - 1; previous >= -1; previous--) {
				int not = next[previous + 1];

				int take = Integer.MIN_VALUE;
				if (previous == -1 || nums[i] > nums[previous])
					take = 1 + next[i + 1];
				cur[previous + 1] = Math.max(take, not);
			}

			next = cur;
		}
		return next[0];
	}
}
