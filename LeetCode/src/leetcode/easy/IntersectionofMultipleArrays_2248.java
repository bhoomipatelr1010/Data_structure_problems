package leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionofMultipleArrays_2248 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> intersection(int[][] nums) {

		HashMap<Integer, Integer> fre = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				fre.put(nums[i][j], fre.getOrDefault(nums[i][j], 0) + 1);
			}
		}
		List<Integer> res = fre.entrySet().stream().filter(e -> e.getValue() == nums.length).map(e -> e.getKey())
				.collect(Collectors.toList());
		Collections.sort(res);
		return res;

	}
}
