package leetcode.hard;

import java.util.Arrays;

public class LongestIncreasingSub_2_2407 {

	public static void main(String[] args) {
		LongestIncreasingSub_2_2407 obj = new LongestIncreasingSub_2_2407();
		int nums[] = { 1, 5 };

		int k = Integer.MAX_VALUE;
		System.out.println(k);
		System.out.println(obj.tab1(nums, 1));

	}

	public int lengthOfLIS(int[] nums, int k) {

		int[][] dp = new int[nums.length][nums.length];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		return tab(nums, k, 0, 0, dp);
	}

	public int tab(int[] nums, int k, int idx, int prevIdx, int[][] dp) {

		if (idx == nums.length) {
			return 0;
		}

		if (dp[idx][prevIdx] != -1) {
			return dp[idx][prevIdx];
		}

		int lenth = 0;
		if (prevIdx - 1 == -1 || (nums[prevIdx - 1] < nums[idx] && nums[idx] - nums[prevIdx - 1] <= k)) {

			lenth = 1 + tab(nums, k, idx + 1, idx + 1, dp);
		}

		return dp[idx][prevIdx] = Math.max(lenth, tab(nums, k, idx + 1, prevIdx, dp));

	}

	public int tab1(int[] nums, int k) {

		int[][] dp = new int[nums.length + 1][nums.length + 1];

		int n = nums.length;
		for (int idx = n - 1; idx >= 0; idx--) {
			for (int prevIdx = idx; prevIdx >= 0; prevIdx--) {
				int lenth = 0;
				if (prevIdx - 1 == -1 || (nums[prevIdx - 1] < nums[idx] && nums[idx] - nums[prevIdx - 1] <= k)) {

					lenth = 1 + dp[idx + 1][idx + 1];
				}

				dp[idx][prevIdx] = Math.max(lenth, dp[idx + 1][prevIdx]);
			}
		}

		return dp[0][0];

	}

}
