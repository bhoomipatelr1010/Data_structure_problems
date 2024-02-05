package shradhdhadidi.sorting.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;
import leetcode.hard.CountSubarraysWithSumDivisibleByK_974;

public class CountSubarrayWithZeroSum {

	public static void main(String[] args) {
		CountSubarrayWithZeroSum obj = new CountSubarrayWithZeroSum();
		int[] nums = new int[] { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		obj.findSolution(nums);
	}

	void findSolution(int nums[]) {

		int p = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		ArrayList<Pair<Integer, Integer>> out = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			p = nums[i] + p;
			if (p == 0)
				out.add(new Pair(0, i));
			List<Integer> al = new ArrayList<>();
			if (map.containsKey(p)) {
				// map[sum] stores starting index of all subarrays
				al = map.get(p);
				for (int it = 0; it < al.size(); it++) {
					out.add(new Pair(al.get(it) + 1, i));
				}
			}
			List<Integer> lst = map.getOrDefault(p, new ArrayList<>());
			lst.add(i);
			map.put(p, lst);
		}

		print(out);
	}

	void print(ArrayList<Pair<Integer, Integer>> out) {
		for (int i = 0; i < out.size(); i++) {
			Pair<Integer, Integer> p = out.get(i);
			System.out.println("Subarray found from Index " + p.getKey() + " to " + p.getValue());
		}
	}
}
