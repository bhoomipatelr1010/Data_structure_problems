package shradhdhadidi.easy;

public class MaximumSumSubArray {
	public static void main(String[] args) {

		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));

	}

	public static int maxSubArray(int[] nums) {

		int sum = 0;
		int max = nums[0];
		for (int i : nums) {
			sum += i;
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;

	}
}
