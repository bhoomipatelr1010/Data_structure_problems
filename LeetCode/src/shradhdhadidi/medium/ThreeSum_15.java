package shradhdhadidi.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum_15 {

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, -1, 1, 2, 0, -4 };
		ThreeSum_15 obj = new ThreeSum_15();
		obj.threeSum(nums);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Set<Integer> dups = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {

			Set<Integer> seen = new HashSet<>();

			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; ++j) {
					int complement = -nums[i] - nums[j];
					if (seen.contains(complement)) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(triplet);
						res.add(triplet);
					}
					seen.add(nums[j]);
				}
			}
		}
		return new ArrayList(res);
	}
}
