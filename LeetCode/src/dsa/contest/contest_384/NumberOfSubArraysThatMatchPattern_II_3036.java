package dsa.contest.contest_384;

public class NumberOfSubArraysThatMatchPattern_II_3036 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] pattern = new int[] { 1, 1 };
		System.out.println(countMatchingSubarrays(nums, pattern));

	}

	// KMP

	public static int countMatchingSubarrays(int[] nums, int[] pattern) {
		int n = nums.length, m = pattern.length, ps[] = new int[n - 1], res = 0;

		for (int i = 0; i < n - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				ps[i] = 1;
			} else if (nums[i] > nums[i + 1]) {
				ps[i] = -1;
			} else {
				ps[i] = 0;
			}
		}

		int[] pi = new int[m];

		int j = 0;
		for (int i = 1; i < m; i++) {

			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				j++;
			}
			pi[i] = j;
		}

		j = 0;
		int i = 0;

		while (j < m && i < ps.length) {
			if (pattern[j] == ps[i]) {
				j++;
				i++;
			} else {
				if (j != 0) {
					j = pi[j - 1];
				} else {
					i++;
				}
			}

			if (j == m) {
				res++;
				j = pi[j - 1];
			}
		}

		return res;
	}

}
