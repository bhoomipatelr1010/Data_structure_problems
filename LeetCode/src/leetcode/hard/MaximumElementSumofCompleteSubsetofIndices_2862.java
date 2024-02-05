package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumElementSumofCompleteSubsetofIndices_2862 {

	public static void main(String[] args) {
		MaximumElementSumofCompleteSubsetofIndices_2862 obj = new MaximumElementSumofCompleteSubsetofIndices_2862();

		Integer[] nums = new Integer[] { 5, 10, 3, 100, 1, 13, 7, 9, 100, 5, 10, 3, 10, 1, 100, 7, 9, 4, 5, 10, 3, 10, 1,
				13, 7, 9, 4 };
		List<Integer> A = Arrays.asList(nums);

		obj.maximumSum(A);

	}

	public long maximumSum(List<Integer> A) {
		long res = 0;
		for (int k = 1; k <= A.size(); k++) {
			long cur = 0;
			for (int v = 1; v * v * k <= A.size(); v++) {

			
				cur += A.get(k * v * v - 1);
			}
			res = Math.max(res, cur);
		}
		return res;
	}
}
