package leetcode.hard;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javafx.util.Pair;

public class ShortestSubarraysWithSumAtLeastK_862 {

	public static void main(String[] args) {
		ShortestSubarraysWithSumAtLeastK_862 obj = new ShortestSubarraysWithSumAtLeastK_862();
		int[] nums = new int[] { -12, -22, -33, 5 };
		System.out.println(obj.shortestSubarrayYoutube(nums, 4));

	}

	public int shortestSubarrayNSquareComplexity(int[] nums, int k) {
		int minLength = Integer.MAX_VALUE;
		int p = 0;

		Map<Integer, Integer> map = new HashMap();
		for (int right = 0; right < nums.length; right++) {

			p += nums[right];

			if (nums[right] >= k) {
				minLength = Math.min(minLength, 1);
			} else {
				int left = 0;

				if (map.containsKey(p - k)) {
					left = map.get(p - k);
				}
				int temp = 0;
				for (int i = right; i >= left; i--) {
					temp += nums[i];
					if (temp >= k) {
						minLength = Math.min(minLength, right - i + 1);
						break;
					}
				}
			}

			map.put(p, right);

		}
		if (minLength == Integer.MAX_VALUE) {
			return -1;
		}
		return minLength;
	}

	public int shortestSubarray(int[] A, int K) {
		int N = A.length;
		long[] P = new long[N + 1];
		for (int i = 0; i < N; ++i)
			P[i + 1] = P[i] + (long) A[i];

		// Want smallest y-x with P[y] - P[x] >= K
		int ans = N + 1; // N+1 is impossible
		Deque<Integer> monoq = new LinkedList(); // opt(y) candidates, as indices of P

		for (int y = 0; y < P.length; ++y) {
			// Want opt(y) = largest x with P[x] <= P[y] - K;
			while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
				monoq.removeLast();
			while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
				ans = Math.min(ans, y - monoq.removeFirst());

			monoq.addLast(y);
		}

		return ans < N + 1 ? ans : -1;
	}

	int shortestSubarrayYoutube(int[] nums, int k) {
		int n = nums.length;
		Deque<Pair<Integer, Integer>> dq = new LinkedList();
		int sum = 0;
		int shortest = n + 1;

		for (int i = 0; i < n; ++i) {
			sum += nums[i];
			if (sum >= k)
				shortest = Math.min(shortest, i + 1);// Sum from start to i-th index

			Pair<Integer, Integer> curr = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
			while (!dq.isEmpty() && (sum - dq.getFirst().getValue() >= k)) {
				shortest = Math.min(shortest, (i - dq.removeFirst().getKey()));

			}

			// Maintain monotonically non-decreasing order of deque
			while (!dq.isEmpty() && sum <= dq.getLast().getValue())
				dq.removeLast();
			dq.addLast(new Pair(i, sum));// Push i-th sum
		}
		return shortest == (n + 1) ? -1 : shortest;
	}
}
