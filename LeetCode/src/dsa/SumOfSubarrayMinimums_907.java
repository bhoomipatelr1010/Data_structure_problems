package dsa;

import java.util.Stack;

public class SumOfSubarrayMinimums_907 {

	static int mod = 1000000007;

	public static void main(String[] args) {

		int nums[] = new int[] { 3, 1, 2, 4 };
		System.out.println(sumSubarrayMins(nums));
	}

	public static int sumSubarrayMins(int[] arr) {

		Stack<Integer> st = new Stack<>();

		int n = arr.length;
		int[] sumofIn = new int[n];
		int sum = 0;

		for (int i = n - 1; i >= 0; i--) {
			while (!st.empty() && arr[st.peek()] > arr[i]) {
				st.pop();
			}

			if (st.empty()) {
				sumofIn[i] = ((n - i) * arr[i]);
			} else {

				int nearestSmallest = st.peek();
				sumofIn[i] = ((nearestSmallest - i) * arr[i]) + sumofIn[nearestSmallest];

			}
			st.push(i);

		}

		for (int count : sumofIn) {
			sum += count;
			sum %= mod;
		}
		return sum;
	}
}
