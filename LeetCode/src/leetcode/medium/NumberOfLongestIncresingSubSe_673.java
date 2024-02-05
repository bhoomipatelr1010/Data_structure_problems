package leetcode.medium;

import java.util.Arrays;

public class NumberOfLongestIncresingSubSe_673 {

	public static void main(String[] args) {
		NumberOfLongestIncresingSubSe_673 obj = new NumberOfLongestIncresingSubSe_673();
		int nums[] = { 1, 3, 5, 4, 7 };
		System.out.println(obj.findNumberOfLIS(nums));

	}

	public int findNumberOfLIS(int[] nums) {

		int maxLength = 1;

		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.co
		int[] count = new int[nums.length];
		Arrays.fill(count, 1);

		for (int i = 1; i < nums.length; i++) {

			for (int j = 0; j < i; j++) {

				if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {

					dp[i] = dp[j] + 1;
					count[i] = count[j];

					if (dp[i] > maxLength) {
						maxLength = dp[i];
					}
					maxLength = Math.max(maxLength, dp[i]);
				} else if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
					count[i] += count[j];
				}

			}

		}

		int ans = 0;
		for (int i = 0; i < count.length; i++) {
			if (dp[i] == maxLength) {
				ans += count[i];
			}
		}

		return ans;

	}
}
