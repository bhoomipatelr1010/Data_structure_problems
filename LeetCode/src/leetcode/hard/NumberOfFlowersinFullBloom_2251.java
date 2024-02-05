package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class NumberOfFlowersinFullBloom_2251 {

	public static void main(String[] args) {
		NumberOfFlowersinFullBloom_2251 obj = new NumberOfFlowersinFullBloom_2251();
		int[][] flowers = new int[][] { { 1, 10 }, { 3, 3 } };
		int[] people = new int[] { 3, 3, 2 };
		obj.fullBloomFlowers(flowers, people);

	}

	public int[] fullBloomFlowers(int[][] flowers, int[] people) {

		int[] starts = new int[flowers.length];
		int[] ends = new int[flowers.length];

		for (int i = 0; i < flowers.length; i++) {

			starts[i] = flowers[i][0];
			ends[i] = flowers[i][1] + 1;

		}
		Arrays.sort(starts);
		Arrays.sort(ends);

		int[] ans = new int[people.length];

		for (int i = 0; i < people.length; i++) {
			int startInd = binarySearch(starts, people[i]);
			int endInd = binarySearch(ends, people[i]);

			ans[i] = startInd - endInd;
		}
		return ans;
	}

	int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
