package leetcode.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

	static int time = 0;

	public static void main(String[] args) {

		for (int j = 0; j < 10; j++) {
			// Generate the bitmask
			int mask = 1 << j;

			System.out.println("mast >> " + mask);
		}
		Subsets_78 obj = new Subsets_78();
		int nums[] = new int[] { 1, 2, 9, 4, 5, 9 };

		System.err.println(obj.subsetsWithDup(nums));

	}

	List<List<Integer>> solution = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {

		backtrack(nums, 0, new ArrayList<>());
		System.out.println(time);
		return solution;

	}

	public void backtrack(int[] nums, int first, List<Integer> list) {
		time++;
		solution.add(new ArrayList<>(list));

		for (int j = first; j < nums.length; j++) {
			list.add(nums[j]);
			backtrack(nums, j + 1, list);
			list.remove(list.size() - 1);

		}
	}

	List<List<Integer>> res = new ArrayList<>();
	int[] count = new int[21];

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		for (int i : nums)
			count[i + 10]++;
		backtrack(0, new int[nums.length], 0);
		return res;
	}

	private void backtrack(int i, int[] nums, int len) {
		if (i == 21) {
			List<Integer> cur = new ArrayList<>(len);
			for (int j = 0; j < len; ++j)
				cur.add(nums[j]);
			res.add(cur);
		} else {
			backtrack(i + 1, nums, len);
			for (int j = 0; j < count[i]; ++j) {
				nums[len + j] = i - 10;
				backtrack(i + 1, nums, len + j + 1);
			}
		}
	}
}
