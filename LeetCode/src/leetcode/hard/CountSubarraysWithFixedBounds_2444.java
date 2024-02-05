package leetcode.hard;

public class CountSubarraysWithFixedBounds_2444 {

	public static void main(String[] args) {
		CountSubarraysWithFixedBounds_2444 obj = new CountSubarraysWithFixedBounds_2444();
		int[] nums = new int[] { 1, 1, 1, 1 };

		obj.countSubarrays(nums, 1, 1);

	}

	public long countSubarrays(int[] nums, int minK, int maxK) {

		int left = -1;
		int minKIndex = -1;
		int maxKIndex = -1;
		long ans = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > maxK || nums[i] < minK) {
				left = i;
			}

			if (nums[i] == maxK) {
				maxKIndex = i;
			}

			if (nums[i] == minK) {
				minKIndex = i;
			}

			ans += Math.max(0, Math.min(maxKIndex, minKIndex) - left);

		}
		System.out.println(ans);
		return ans;

	}
}
