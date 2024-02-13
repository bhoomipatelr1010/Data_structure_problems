package dsa;

import java.util.Stack;

public class SumOfSubArrayRanges_2104 {
	static int mod = 1000000007;

	public static void main(String[] args) {

		int nums[] = new int[] { -94, 12, 96, -901537108, -54, -67, -988623002, 936 };
		System.out.println(subArrayRanges(nums));

	}

	public static long subArrayRanges(int[] nums) {

		Stack<Integer> minSt = new Stack<>();
		Stack<Integer> maxSt = new Stack<>();
		long sum = 0;
		int n = nums.length;

		long[] minDp = new long[n];

		long[] maxDp = new long[n];

		for (int i = n - 1; i >= 0; i--) {

			while (!minSt.empty() && nums[minSt.peek()] >= nums[i]) {
				minSt.pop();
			}

			if (minSt.empty()) {
				minDp[i] = (n - i) * (long) nums[i];
			} else {
				minDp[i] = (minSt.peek() - i) * (long) nums[i] + minDp[minSt.peek()];
			}
			minSt.push(i);

			while (!maxSt.empty() && nums[maxSt.peek()] <= nums[i]) {
				maxSt.pop();
			}

			if (maxSt.empty()) {
				maxDp[i] = (n - i) * (long) nums[i];
			} else {
				maxDp[i] = (maxSt.peek() - i) * (long) nums[i] + maxDp[maxSt.peek()];
			}
			maxSt.push(i);
		}

		for (int i = 0; i < n; i++) {
			sum += (maxDp[i] - minDp[i]) % mod;
		}
		return sum;
	}
}
