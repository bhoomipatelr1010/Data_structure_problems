package leetcode.hard;

import java.util.Arrays;
import java.util.Stack;

public class SubarrayWithElementsGreaterThanVaryingThreshold_2334 {

	public static void main(String[] args) {
		SubarrayWithElementsGreaterThanVaryingThreshold_2334 obj = new SubarrayWithElementsGreaterThanVaryingThreshold_2334();
		int[] nums = new int[] { 6, 5, 6, 5, 8 };
		System.out.println(obj.validSubarraySize(nums, 7));

	}

	public int validSubarraySize(int[] nums, int threshold) {
		// the thing is. The next_smaller and the prev_smaller is helping us to find
		// hoow long we can expand our element .
		// Expanding element is in both side how long we have the element that have
		// eigther smae as our value or greater than our value;
		int n = nums.length;
		int[] next_small = new int[n];
		int[] prev_small = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		Arrays.fill(next_small, n);
		Arrays.fill(prev_small, -1);
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
				stack.pop();
			}
			if (stack.size() != 0) {
				prev_small[i] = stack.peek();
			}
			stack.push(i);
		}
		stack = new Stack<>();
		stack.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
				stack.pop();
			}
			if (stack.size() != 0) {
				next_small[i] = stack.peek();
			}
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			int len = next_small[i] - prev_small[i] - 1;// representing the lenth of our sope. in
			// test case 1 lets talk about 3 it prev smaller index=0 and next smaller index
			// =4;
			// so it can be expandex 4-0-1=3 --> and those 3 element are 3 4 3.

			if (threshold / (double) len < nums[i]) {
				// here if we have 3 element in our array and our threshold is 6 then, all the
				// elemet
				// must have 6/3 =2 greater than 2 as value;
				// now testcase:1 ,we have seen that the max expanding length for 3 ie(nums[1]
				// or nums[3]) is 3 and that reprsent
				// that 3 element have 3 or more than 3 value. so they are definitly grater than
				// 2.
				// 6/3 <3 --> thats a valid case.
				return len;
			}
		}
		return -1;
	}

}
