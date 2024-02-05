package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarrayWithAbsoluteDiffLessOrEqLimit_1438 {

	public static void main(String[] args) {
		LongestSubarrayWithAbsoluteDiffLessOrEqLimit_1438 obj = new LongestSubarrayWithAbsoluteDiffLessOrEqLimit_1438();
		int[] nums = new int[] { 2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2 };
		System.out.println(obj.longestSubarraySol(nums, 2));

	}

	public int longestSubarraySol(int[] nums, int limit) {
		int maxlength = Integer.MIN_VALUE;

		Deque<Integer> min = new ArrayDeque<>();
		Deque<Integer> max = new ArrayDeque();

		int left = 0;

		for (int right = 0; right < nums.length; right++) {
			while (!min.isEmpty() && nums[min.getLast()] >= nums[right]) {
				min.removeLast();
			}
			min.addLast(right);
			while (!max.isEmpty() && nums[max.getLast()] <= nums[right]) {
				max.removeLast();
			}
			max.addLast(right);

			while (Math.abs(nums[max.peek()] - nums[min.peek()]) > limit) {
				left++;
				if (max.peek() < left) {
					max.pollFirst();
				}
				if (min.peek() < left) {
					min.pollFirst();
				}
			}
			maxlength = Math.max(maxlength, right - left + 1);

		}
		return maxlength;
	}

	public int longestSubarray(int[] nums, int limit) {

		int maxlength = Integer.MIN_VALUE;
		int maxEleInd = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {

			if (nums[maxEleInd] < nums[right]) {
				maxEleInd = right;
			}
			if (maxEleInd < left) {
				maxEleInd = left;
			}

			if (Math.abs(nums[maxEleInd] - nums[right]) > limit) {
				left = maxEleInd;
			}

			while (left <= right && Math.abs(nums[left] - nums[right]) > limit) {
				left++;
			}

			maxlength = Math.max(maxlength, right - left + 1);

		}
		return maxlength;

	}
}
