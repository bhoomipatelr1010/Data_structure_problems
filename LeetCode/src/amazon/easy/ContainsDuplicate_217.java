package amazon.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 1 };
		System.out.println(findSolution(nums));
	}

	public static boolean findSolution(int[] nums) {

		Set<Integer> numsSet = new HashSet<>();

		for (int num : nums) {
			if (numsSet.contains(num)) {
				return true;
			} else {
				numsSet.add(num);
			}
		}
		return false;

	}
}
