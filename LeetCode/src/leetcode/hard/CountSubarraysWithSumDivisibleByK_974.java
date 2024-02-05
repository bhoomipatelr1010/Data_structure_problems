package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumDivisibleByK_974 {

	public static void main(String[] args) {
		CountSubarraysWithSumDivisibleByK_974 obj = new CountSubarraysWithSumDivisibleByK_974();
		int[] nums = new int[] { -1, 2, 9 };
		System.out.println(obj.subarraysDivByK(nums, 2));

	}

	public int subarraysDivByK(int[] nums, int modulo) {

		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] % modulo;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int p = 0;
		int ans = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			p = (p + nums[i] % modulo + modulo) % modulo;

			ans += map.getOrDefault(p, 0);
			map.put(p, map.getOrDefault(p, 0) + 1);
		}

		return ans;
	}

}
