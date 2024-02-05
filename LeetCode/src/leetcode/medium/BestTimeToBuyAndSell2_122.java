package leetcode.medium;

import java.util.Arrays;

public class BestTimeToBuyAndSell2_122 {

	public static void main(String[] args) {
		int arr[] = { 7, 1, 5, 3, 6, 4 };
		BestTimeToBuyAndSell2_122 obj = new BestTimeToBuyAndSell2_122();

		System.out.println(obj.maxProfit(arr));

	}

	public int maxProfit(int[] prices) {

		int[][] dp = new int[prices.length][2];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		// int pro = fMemo(0, 1, dp, prices);

		int pro = fTab(prices);

		return pro;
	}

	int fMemo(int i, int buy, int[][] dp, int[] prices) {

		if (i == prices.length) {
			return 0;
		}

		if (dp[i][buy] != -1) {
			return dp[i][buy];
		}
		int profit = 0;

		if (buy == 1) {

			profit = Math.max(-prices[i] + fMemo(i + 1, 0, dp, prices), fMemo(i + 1, buy, dp, prices));
		} else {
			profit = Math.max(prices[i] + fMemo(i + 1, 1, dp, prices), fMemo(i + 1, buy, dp, prices));

		}

		return dp[i][buy] = profit;

	}

	int fTab(int[] prices) {

		int n = prices.length;
		int[][] dp = new int[n + 1][2];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[n][0] = dp[n][1] = 0;

		for (int i = n - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {
				int profit = 0;
				if (buy == 1) {

					profit = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
				} else {
					profit = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);

				}

				dp[i][buy] = profit;
			}
		}
		return dp[0][1];

	}
}
