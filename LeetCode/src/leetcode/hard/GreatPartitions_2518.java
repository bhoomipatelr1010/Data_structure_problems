package leetcode.hard;

import amazon.medium.PartitionEqualSubsetSum_416;

public class GreatPartitions_2518 {

	public static void main(String[] args) {
		GreatPartitions_2518 obj = new GreatPartitions_2518();
		int nums[] = new int[] { 1, 2, 3, 4 };

		System.out.println(obj.countPartitions2(nums, 4));

	}

	int countPartitions(int[] nums, int k) {
		int mod = 1000000007, ans;
		int i, j, n;
		long total = 0;
		n = nums.length;

		int[][] dp = new int[k][n + 1];

		for (i = 0; i <= n; i++) {
			dp[0][i] = 1;
		}

		for (i = 1; i < k; i++) {
			dp[i][0] = 0;
		}

		for (i = 0; i < n; i++) {
			total = total + nums[i];
		}

		if (total < 2 * k) {
			return 0;
		}

		for (i = 1; i < k; i++)
			for (j = 1; j <= n; j++) {
				if (i - nums[j - 1] >= 0) {
					dp[i][j] = (dp[i - nums[j - 1]][j - 1] + dp[i][j - 1]) % mod;
				} else if (i - nums[j - 1] < 0) {
					dp[i][j] = dp[i][j - 1];
				}
			}

		ans = 1;
		for (i = 1; i <= n; i++) {
			ans = (ans * 2) % mod;
		}

		for (i = 0; i < k; i++) {
			ans = (ans - ((2 * dp[i][n]) % mod) + mod) % mod;
		}

		return ans;

	}

	int countPartitions2(int[] nums, int k) {
		int mod = 1000000007, ans;
		int i, j, n;
		long total = 0;
		n = nums.length;

		int[] dp = new int[k];

		dp[0] = 1;

		for (i = 0; i < n; i++) {
			total = total + nums[i];
		}

		if (total < 2 * k) {
			return 0;
		}

		for (int b : nums)
			for (j = k - 1; b <= j; --j)
				dp[j] = (dp[j] + dp[j - b]) % mod;

		ans = 1;
		for (i = 1; i <= n; i++) {
			ans = (ans * 2) % mod;
		}

		for (i = 0; i < k; i++) {
			ans = (ans - ((2 * dp[i]) % mod) + mod) % mod;
		}

		return ans;

	}

}
