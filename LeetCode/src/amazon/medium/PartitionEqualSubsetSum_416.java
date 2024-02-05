package amazon.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum_416 {

	public static void main(String[] args) {
		PartitionEqualSubsetSum_416 obj = new PartitionEqualSubsetSum_416();
		int nums[] = new int[] { 5, 1, 11, 5 };

		// System.out.println(obj.canPartition(nums));
		System.out.println(obj.canPartition2(nums));

	}

	public boolean canPartition2(int[] nums) {
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}

		if (totalSum % 2 != 0) {
			return false;
		}

		int reqSum = totalSum / 2;

		return dp(nums, reqSum);
	}

	public boolean canPartition(int[] nums) {

		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}

		if (totalSum % 2 != 0) {
			return false;
		}

		Arrays.sort(nums);

		Map<Integer, Integer> map = new HashMap<>();

		int prefixSum = 0;
		int reqSum = totalSum / 2;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (prefixSum == reqSum || (prefixSum > reqSum && map.containsKey(prefixSum - reqSum))) {
				return true;
			}
			map.put(prefixSum, i);

		}
		return false;

	}

	// not good approach, TLE

	public boolean backTrack(int i, int[] nums, int sum, int reqSum) {
		if (reqSum == sum) {
			return true;
		}
		if (i >= nums.length) {
			return false;
		}

		sum += nums[i];
		if (backTrack(i + 1, nums, sum, reqSum)) {
			return true;
		}

		sum -= nums[i];
		return backTrack(i + 1, nums, sum, reqSum);

	}

	public boolean dp(int[] nums, int reqSum) {
		boolean[] memo = new boolean[reqSum + 1];

		memo[0] = true;
		for (int curr : nums) {

			for (int j = reqSum; j >= curr; j--) {

				memo[j] = memo[j - curr] || memo[j];

			}

		}
		return memo[reqSum];

	}

}
