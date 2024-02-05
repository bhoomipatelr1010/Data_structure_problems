package leetcode.hard;

import java.util.Arrays;

public class BestTimeToBuyAndSell3_123 {

	public static void main(String[] args) {
		int arr[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		BestTimeToBuyAndSell3_123 obj = new BestTimeToBuyAndSell3_123();

		System.out.println(obj.maxProfit(arr));

	}

	public int maxProfit(int[] prices) {

		int[][][] dp = new int[prices.length][2][2];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(dp[i][j], -1);
			}

		}

		int pro = fMemo(0, 1, 1, dp, prices);
		return pro;
	}

	int fMemo(int i, int buy, int capecity, int[][][] dp, int[] prices) {

		if (capecity < 0) {
			return 0;
		}
		if (i == prices.length) {
			return 0;
		}

		if (dp[i][buy][capecity] != -1) {
			return dp[i][buy][capecity];
		}
		int profit = 0;

		if (buy == 1) {

			profit = Math.max(-prices[i] + fMemo(i + 1, 0, capecity, dp, prices),
					fMemo(i + 1, buy, capecity, dp, prices));
		} else {
			profit = Math.max(prices[i] + fMemo(i + 1, 1, capecity - 1, dp, prices),
					fMemo(i + 1, buy, capecity, dp, prices));

		}

		return dp[i][buy][capecity] = profit;

	}

}
