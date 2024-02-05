package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubarraysWithMedianK_2488 {

	public static void main(String[] args) {
		CountSubarraysWithMedianK_2488 obj = new CountSubarraysWithMedianK_2488();
		int[] nums = new int[] { 2, 5, 1, 4, 3, 6 };
		System.out.println(obj.countSubarrays(nums, 1));
	}

//Wrong solution
	int findSolution(int[] nums, int k) {

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		int medianIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == k) {
				medianIndex = i;
				break;
			}
		}

		if (medianIndex == 0 || medianIndex == nums.length - 1) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k && i < medianIndex) {
				left.add(nums[i]);

			} else if (nums[i] > k && i > medianIndex) {
				right.add(nums[i]);
			}
		}

		;
		int ans = 1;
		int minSize = Math.min(left.size(), right.size());
		if (minSize > 0) {
			ans += minSize * 2;
		}

		return ans;
	}

	// Right solution
	public int countSubarrays(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); // Dummy value of 0's frequency is 1.
		int ans = 0, sum = 0;
		boolean found = false;
		for (int num : nums) {
			if (num < k) {
				--sum;
			} else if (num > k) {
				++sum;
			} else {
				found = true;
			}
			if (found) {
				ans += map.getOrDefault(sum, 0) + map.getOrDefault(sum - 1, 0);
			} else {
				// prefixSumOfBalance.merge(runningBalance, 1, Integer::sum); // Similar to the
				// following statement, but it is shorter.
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		return ans;
	}
}
