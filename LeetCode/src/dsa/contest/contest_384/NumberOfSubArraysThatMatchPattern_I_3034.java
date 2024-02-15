package dsa.contest.contest_384;

public class NumberOfSubArraysThatMatchPattern_I_3034 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 4, 4, 1, 3, 5, 5, 3 };
		int[] pattern = new int[] { 1, 0, -1 };
		System.out.println(countMatchingSubarrays(nums, pattern));
	}

	public static int countMatchingSubarrays(int[] nums, int[] pattern) {
		int n = nums.length, m = pattern.length, ps[] = new int[n - 1], psum[] = new int[n], hash = 0, res = 0;
		for (int k = 0; k < m; k++) {
			hash += pattern[k];
		}
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				ps[i] = 1;
			} else if (nums[i] > nums[i + 1]) {
				ps[i] = -1;
			} else {
				ps[i] = 0;
			}
			// prefix sum for pattern, to guaranttee O(1) for calc hash of subarrays.
			psum[i + 1] = psum[i] + ps[i];
		}
		for (int i = 0; i < n - m; i++) {
			// count if hash of subarray matches
			if (psum[i + m] - psum[i] == hash) {
				 if (valid(ps, pattern, i, m))
				res++;
			}
		}
		return res;
	}

	private static boolean valid(int[] ps, int[] pattern, int start, int len) {
		for (int i = 0; i < len; i++) {
			if (ps[start + i] != pattern[i])
				return false;
		}
		return true;
	}
}
