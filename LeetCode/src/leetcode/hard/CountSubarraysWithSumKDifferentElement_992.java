package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

class CountSubarraysWithSumKDifferentElement_992 {

	public static void main(String[] args) {
		CountSubarraysWithSumKDifferentElement_992 obj = new CountSubarraysWithSumKDifferentElement_992();
		int[] nums = new int[] { 1, 2, 1, 3, 4 };

		System.out.println(obj.atMostK(nums, 3) - obj.atMostK(nums, 2));

	}

	public int atMostK(int[] A, int K) {

		int ans = 0, left = 0;

		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (int right = 0; right < A.length; right++) {
			countMap.put(A[right], countMap.getOrDefault(A[right], 0) + 1);

			while (countMap.size() > K) {
				int eleFreq = countMap.get(A[left]);

				if (eleFreq - 1 == 0) {
					countMap.remove(A[left]);
				} else {
					countMap.put(A[left], countMap.get(A[left]) - 1);
				}
				left++;
			}

			ans += right - left + 1;

		}
		return ans;
	}

	public int subarraysWithKDistinct(int[] A, int K) {
		Window window1 = new Window();
		Window window2 = new Window();
		int ans = 0, left1 = 0, left2 = 0;

		for (int right = 0; right < A.length; ++right) {
			int x = A[right];
			window1.add(x);
			window2.add(x);

			while (window1.different() > K)
				window1.remove(A[left1++]);
			while (window2.different() >= K)
				window2.remove(A[left2++]);

			ans += left2 - left1;
		}

		return ans;
	}
}

class Window {
	Map<Integer, Integer> count;
	int nonzero;

	Window() {
		count = new HashMap();
		nonzero = 0;
	}

	void add(int x) {
		count.put(x, count.getOrDefault(x, 0) + 1);
		if (count.get(x) == 1)
			nonzero++;
	}

	void remove(int x) {
		count.put(x, count.get(x) - 1);
		if (count.get(x) == 0)
			nonzero--;
	}

	int different() {
		return nonzero;
	}
}