package amazon.medium;

import java.util.HashMap;

public class LongestArithSeqLength_1027 {

	public static void main(String[] args) {
		int arr[] = new int[] { 83, 20, 17, 43, 52, 78, 68, 45 };
		LongestArithSeqLength_1027 obj = new LongestArithSeqLength_1027();
		System.out.println(obj.longestArithSeqLength(arr));
	}

	public int longestArithSeqLength(int[] nums) {

		int maxLength = 0;
		HashMap<Integer, Integer>[] dp = new HashMap[nums.length];

		for (int i = 0; i < nums.length; i++) {
			dp[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {

				int diff = nums[i] - nums[j];

				dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
				if (maxLength < dp[i].get(diff)) {
					maxLength = dp[i].get(diff);
				}

			}
		}

		System.out.println(((-6 % 5) + 5) % 5);
		return maxLength;

	}

}
