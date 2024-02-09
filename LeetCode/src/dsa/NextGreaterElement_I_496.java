package dsa;

import java.util.Stack;

public class NextGreaterElement_I_496 {

	public static void main(String[] args) {
		int nums1[] = new int[] { 4, 1, 2, 10 };
		int nums2[] = new int[] { 4, 1, 2, 10, 11 };

		nextGreaterElement(nums1, nums2);

	}

	static public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] index = new int[10001];
		for (int i = 0; i < nums2.length; i++)
			index[nums2[i]] = i;

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = findNextGreater(index[nums1[i]], nums2);
		}

		return nums1;
	}

	static private int findNextGreater(int index, int[] nums2) {
		for (int i = index + 1; i < nums2.length; i++) {
			if (nums2[i] > nums2[index])
				return nums2[i];
		}
		return -1;
	}

	// one more approach using stack
	public int[] nextGreaterElementUsingStack(int[] nums1, int[] nums2) {

		int[] index = new int[10001];
		Stack<Integer> st = new Stack();

		for (int j = nums2.length - 1; j >= 0; j--) {
			while (!st.empty() && st.peek() < nums2[j]) {
				st.pop();
			}

			if (st.empty()) {
				index[nums2[j]] = -1;
			} else {
				index[nums2[j]] = st.peek();
			}
			st.push(nums2[j]);
		}

		int[] res = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {
			res[i] = index[nums1[i]];
		}
		return res;
	}
}
