package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CountSubarraysWithInteresting_2845 {

	public static void main(String[] args) {
		CountSubarraysWithInteresting_2845 obj = new CountSubarraysWithInteresting_2845();
		Integer[] nums = new Integer[] { 7, 2, 9 };
		List<Integer> numsLst = Arrays.asList(nums);
		System.out.println(obj.countInterestingSubarrays(numsLst, 4, 1));
	}

	public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

		int[] prefix = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) % modulo == k) {
				prefix[i] = 1;
			} else {
				prefix[i] = 0;
			}
		}

		Map<Integer, Long> map = new HashMap<>();
		int p = 0;
		Long ans = 0l;

		for (int i = 0; i < prefix.length; i++) {
			p = (p + prefix[i]) % modulo;

			if (p == k) {
				ans++;
			}
			int rem = p - k;
			if (rem < 0)
				rem = rem + modulo;
			ans += map.getOrDefault(rem, 0L);
			map.put(p, map.getOrDefault(p, 0L) + 1);
		}

		return ans;

	}

}
