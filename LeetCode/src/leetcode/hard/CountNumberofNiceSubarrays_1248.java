package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofNiceSubarrays_1248 {

	public static void main(String[] args) {
		CountNumberofNiceSubarrays_1248 obj = new CountNumberofNiceSubarrays_1248();
		int[] nums = new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		System.out.println(obj.numberOfSubarrays(nums, 2));
	}

	public int numberOfSubarrays(int[] nums, int k) {
		int ans = 0;

		Map<Integer, Integer> sumwithIndMap = new HashMap<>();
		sumwithIndMap.put(0, 1);
		int p = 0;

		for (int i = 0; i < nums.length; i++) {
			p += nums[i] % 2 == 0 ? 0 : 1;

			if (sumwithIndMap.containsKey(p - k)) {
				ans += sumwithIndMap.get(p - k);
			}
			sumwithIndMap.put(p, sumwithIndMap.getOrDefault(p, 0) + 1);

		}
		return ans;
	}

}
