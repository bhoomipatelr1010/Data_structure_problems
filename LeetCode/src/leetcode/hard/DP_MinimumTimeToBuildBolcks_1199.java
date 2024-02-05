package leetcode.hard;

import java.util.Arrays;

public class DP_MinimumTimeToBuildBolcks_1199 {

	public static void main(String[] args) {
		DP_MinimumTimeToBuildBolcks_1199 obj = new DP_MinimumTimeToBuildBolcks_1199();
		int[] nums = new int[] { 1, 2 };
		System.out.println(obj.minBuildTime(nums, 5));

	}

	public int minBuildTime(int[] blocks, int split) {
		Arrays.sort(blocks);

		int[][] dp = new int[blocks.length][blocks.length];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solve(blocks.length - 1, blocks, 1, split, dp);
	}

	public int solve(int b, int[] blocks, int worker, int splitCost, int[][] dp) {

		if (b < 0) {
			return 0;
		}

		if (worker == 0) {
			return Integer.MAX_VALUE;
		}
		if (worker >= b + 1) {
			return blocks[b];
		}
		if (dp[b][worker] != -1) {
			return dp[b][worker];
		}

		int workHere = Math.max(blocks[b], solve(b - 1, blocks, worker - 1, splitCost, dp));

		int splitHere = splitCost + solve(b, blocks, Math.min(b + 1, 2 * worker), splitCost, dp);

		dp[b][worker] = Math.min(splitHere, workHere);

		return dp[b][worker];
	}
}
