package dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowmaximum_239 {

	public static void main(String[] args) {
		int nums[] = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(maxSlidingWindow(nums, 3));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;
		int[] ans = new int[n - k + 1];

		Deque<Integer> dq = new ArrayDeque<>();
		int j = 0;
		for (int i = 0; i < nums.length; i++) {

			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}

			while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
				dq.pollFirst();
			}
			dq.offer(i);
			if (i - k + 1 >= 0) {
				ans[j++] = nums[dq.peekFirst()];
			}

		}
		return ans;

	}
}
