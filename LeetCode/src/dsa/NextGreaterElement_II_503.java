package dsa;

import java.util.Stack;

public class NextGreaterElement_II_503 {

	public static void main(String[] args) {
		int nums[] = new int[] { 2, 10, 12, 1, 11 };

		nextGreaterElements(nums);
	}

	public static int[] nextGreaterElements(int[] nums) {

		int[] res = new int[nums.length];

		Stack<Integer> st = new Stack();

		int n = nums.length;

		for (int j = 2 * n - 1; j >= 0; j--) {

			int cI = j % n;
			while (!st.empty() && st.peek() <= nums[cI]) {
				st.pop();
			}

			if (j < n) {
				if (st.empty()) {
					res[cI] = -1;
				} else {
					res[cI] = st.peek();
				}
			}

			st.push(nums[cI]);
		}

		return res;
	}

}
