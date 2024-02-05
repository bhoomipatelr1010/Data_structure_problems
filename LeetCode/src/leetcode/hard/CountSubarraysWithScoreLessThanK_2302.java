package leetcode.hard;

public class CountSubarraysWithScoreLessThanK_2302 {

	public static void main(String[] args) {
		CountSubarraysWithScoreLessThanK_2302 obj = new CountSubarraysWithScoreLessThanK_2302();
		int[] nums = new int[] { 2, 1, 4, 3, 5 };

		System.out.println(obj.countSubarrays(nums, 10));

	}

	public long countSubarrays(int[] nums, long k) {

		long sum = 0, res = 0;
		for (int i = 0, j = 0; i < nums.length; ++i) {
			sum += nums[i];
			while (sum * (i - j + 1) >= k)
				sum -= nums[j++];
			res += i - j + 1;
		}
		return res;

	}

}
